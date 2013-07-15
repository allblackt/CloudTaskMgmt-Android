package com.tudor.ctm;

import static com.tudor.ctm.CommonUtilities.PROPERTY_PROJECT_ID;
import static com.tudor.ctm.CommonUtilities.PROPERTY_PROJECT_NAME;
import static com.tudor.ctm.CommonUtilities.PROPERTY_REMAINIG_TIME;
import static com.tudor.ctm.CommonUtilities.PROPERTY_TASK_DESCRIPTION;
import static com.tudor.ctm.CommonUtilities.PROPERTY_TASK_DUE_DATE;
import static com.tudor.ctm.CommonUtilities.PROPERTY_TASK_ID;
import static com.tudor.ctm.CommonUtilities.PROPERTY_TASK_TITLE;
import static com.tudor.ctm.CommonUtilities.PROPERTY_TOTAL_TIME;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.services.cloudprojectendpoint.model.CloudProject;
import com.google.api.services.cloudtaskendpoint.Cloudtaskendpoint;
import com.google.api.services.cloudtaskendpoint.model.CloudTask;
import com.google.api.services.clouduserendpoint.model.CloudUser;

public class TaskDisplay extends Activity {
	
	private static final String TAG = "TDA"; 
	
	private EditText taskTitle = null;
	private EditText taskDescription = null;
	private EditText taskDueDate = null;
	private EditText remainingTime = null;
	private EditText totalTime = null;
	private Button btnSave = null;
	private Context context = null;
	private CloudProject project = null;
	private CloudTask task = null;
	private CloudUser user;
	private ProgressDialog mDialog;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd - MM - yyyy", Locale.ENGLISH);
	private boolean dateFired = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_task_display);
		taskTitle = (EditText) findViewById(R.id.txtTaskTitle);
		taskDescription = (EditText) findViewById(R.id.txtTaskDescription);
		taskDueDate = (EditText) findViewById(R.id.dpDueDate);
		remainingTime = (EditText) findViewById(R.id.npTaskRemainingTime);
		totalTime = (EditText) findViewById(R.id.npTimeTotal);
		btnSave = (Button) findViewById(R.id.btnSave);
		context = getApplicationContext();
		mDialog = new ProgressDialog(this);
		mDialog.setMessage("Loading...");
        mDialog.setCancelable(false);
		
		/* Init result so that it doesn't reload when back is pressed */
		setResult(-1);
		
		project = new CloudProject.Builder().id(getIntent().getLongExtra(PROPERTY_PROJECT_ID, 0)).name(getIntent().getStringExtra(PROPERTY_PROJECT_NAME)).build();
		Log.d(TAG, "Received project " + project.toString());
		
		user = CommonUtilities.getRegisteredUser(context);
		btnSave.setOnClickListener(btnSaveOnClick);
		taskDueDate.setText(sdf.format(new Date()));
		taskDueDate.setOnTouchListener(dueDateTouchListener);
		
		/* 1 = edit, 2 = new, other = ignore */
		if(getIntent().getIntExtra("requestCode", 0) == 1) {
			Log.d(TAG, "Edit mode requested");
			task = new CloudTask.Builder().id(getIntent().getLongExtra(PROPERTY_TASK_ID, -1))
					.taskTitle(getIntent().getStringExtra(PROPERTY_TASK_TITLE))
					.taskDescription(getIntent().getStringExtra(PROPERTY_TASK_DESCRIPTION))
					.taskDueDate(new DateTime(getIntent().getLongExtra(PROPERTY_TASK_DUE_DATE, 0)))
					.remainingTime(getIntent().getIntExtra(PROPERTY_REMAINIG_TIME, 0))
					.totalTime(getIntent().getIntExtra(PROPERTY_TOTAL_TIME, 0))
					.project(project)
					.build();
			Log.d(TAG, "Received task " + task.toString());
			
			/* Set up interface */
			getActionBar().setTitle(task.getTaskTitle());
			
			taskTitle.setText(task.getTaskTitle());
			taskDescription.setText(task.getTaskDescription());
			remainingTime.setText(task.getRemainingTime().toString());
			totalTime.setText(task.getTotalTime().toString());
			taskDueDate.setText(sdf.format(new Date(task.getTaskDueDate().getValue())));
			
		} else if (getIntent().getIntExtra("requestCode", 0) == 2) {
			Log.d(TAG, "New task mode requested");
			getActionBar().setTitle("New task");
			task = new CloudTask();
		} else {
			Log.d(TAG, "Unknown more requested, exiting with -1");
			setResult(-1);
			finish();
		}
		
		if(!CommonUtilities.isOnline(context)) {
			btnSave.setEnabled(false);
		}
	}
	
	private View.OnTouchListener dueDateTouchListener = new View.OnTouchListener() {
		@Override
		public boolean onTouch(View v, MotionEvent event) {
			if(!dateFired) {
				dateFired = true;
				Calendar c = Calendar.getInstance();
				try {
					c.setTimeInMillis(sdf.parse(taskDueDate.getText().toString()).getTime());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				new DatePickerDialog(v.getContext(), dateSetListener, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();
			}
			return false;
		}
	};
	
	private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
		
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
			if(dateFired) {
				Log.d(TAG, "Date was set");
				Calendar c = Calendar.getInstance();
				c.set(year, monthOfYear, dayOfMonth);
				taskDueDate.setText(sdf.format(c.getTime()));
				dateFired = false;
			}
		}
	};
	
	private View.OnClickListener btnSaveOnClick = new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(isTaskValid()) {
					try {
						task.setTaskTitle(taskTitle.getText().toString().trim());
						task.setTaskDescription(taskDescription.getText().toString().trim());
						task.setTaskDueDate(new DateTime(sdf.parse(taskDueDate.getText().toString())));
						task.setRemainingTime( Integer.parseInt(remainingTime.getText().toString().trim()));
						task.setTotalTime(Integer.parseInt(totalTime.getText().toString().trim()));
						task.setOwner(user);
						task.setProject(project);
						
						Log.d(TAG, "About to save task:" + task.toString());
						Log.d(TAG, "Task user: " + task.getOwner().toString());
						Log.d(TAG, "Task project: " + task.getProject().toString());
						
						saveToCloud();
						
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
			}
		};
	
	private boolean isTaskValid() {
		Log.d(TAG, "Validating task...");
		String errorMessage = "";
		boolean isValid = true;
		
		if(taskTitle.getText().toString().trim().length() ==0) {
			isValid = false;
			errorMessage += " Task title must not be empty!";
		}
		
		if(taskDescription.getText().toString().trim().length() ==0) {
			isValid = false;
			errorMessage += " Task description must not be empty!";
		}
		
		try {
			if(sdf.parse(taskDueDate.getText().toString()).compareTo(new Date()) < 0 ) {
				isValid = false;
				errorMessage += " Task due date must not be in the past!";
			}
		} catch (ParseException e) {
			isValid = false;
			errorMessage += " Task due date must not be in the past!";
		}
		
		if(remainingTime.getText().toString().trim().length() == 0) {
			isValid = false;
			errorMessage += " Time remaining must be a numerical value of at least 0!";
		}
		
		if(isValid && remainingTime.getText().toString().trim().equals("0")) {
			if(totalTime.getText().toString().trim().length() == 0) {
				isValid = false;
				errorMessage += " Total time must be a numerical value of at least 0!";
			}
		} else {
			if(totalTime.getText().toString().trim().length() == 0) {
				totalTime.setText("0");
			}
		}
		if(!isValid) {
			new AlertDialog.Builder(this).setMessage(errorMessage).setNeutralButton("OK", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.cancel();
				}
			}).create().show();
		}
		return isValid;
	}
	
	private void saveToCloud() {
		final Cloudtaskendpoint cte = new Cloudtaskendpoint.Builder(AndroidHttp.newCompatibleTransport(), new GsonFactory(), null).setApplicationName("ctm-tudor").build();
		new AsyncTask<Void, Void, Boolean>() {
			
			@Override
			protected void onPreExecute() {
				mDialog.show();
				super.onPreExecute();
			}
			
			@Override
			protected Boolean doInBackground(Void... params) {
				try {
					if(task.getId() == null) {
						Log.d(TAG, "Inserting task...");
						cte.insertCloudTask(task).execute();
					} else {
						Log.d(TAG, "Updating task...");
						cte.updateCloudTask(task).execute();
					}
				} catch (IOException e) {
					e.printStackTrace();
					return false;
				}
				return true;
			}

			@Override
			protected void onPostExecute(Boolean result) {
				mDialog.hide();
				if(result) {
					exitWithSuccess();
				} else {
					exitWithError();
				}
				super.onPostExecute(result);
			}
		}.execute();
	}
	
	protected void exitWithError() {
		Toast.makeText(this, "Error occured while saving the task", Toast.LENGTH_LONG).show();		
	}

	protected void exitWithSuccess() {
		setResult(0);
		this.finish();		
	}

	@Override
	protected void onStop() {
		if(mDialog != null) {
			mDialog.dismiss();
		}
		mDialog = null;
		super.onStop();
	}

}
