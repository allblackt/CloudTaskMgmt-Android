package com.tudor.ctm;

import static com.tudor.ctm.CommonUtilities.PROPERTY_EMAIL_ADDRESS;
import static com.tudor.ctm.CommonUtilities.PROPERTY_PROJECT_ID;
import static com.tudor.ctm.CommonUtilities.PROPERTY_PROJECT_NAME;
import static com.tudor.ctm.CommonUtilities.PROPERTY_USER_ID;
import static com.tudor.ctm.CommonUtilities.PROPERTY_TASK_DESCRIPTION;
import static com.tudor.ctm.CommonUtilities.PROPERTY_TASK_DUE_DATE;
import static com.tudor.ctm.CommonUtilities.PROPERTY_TASK_ID;
import static com.tudor.ctm.CommonUtilities.PROPERTY_TASK_TITLE;
import static com.tudor.ctm.CommonUtilities.PROPERTY_REMAINIG_TIME;
import static com.tudor.ctm.CommonUtilities.PROPERTY_TOTAL_TIME;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.cloudprojectendpoint.model.CloudProject;
import com.google.api.services.cloudtaskendpoint.Cloudtaskendpoint;
import com.google.api.services.cloudtaskendpoint.model.CloudTask;
import com.google.api.services.clouduserendpoint.model.CloudUser;
import com.tudor.ctm.db.CloudTaskDAO;

public class CloudTasks extends Activity {
	
	private static final String TAG = "CT";
	private ListView listview;
	private ProgressDialog mDialog;
	private CloudUser user;
	private CloudProject project;
	private Context context;
	private List<CloudTask> tasks;
	private Cloudtaskendpoint cte;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		Log.d(TAG, "OnCreate");
		
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.genericlist);
		user = new CloudUser();
		project = new CloudProject();
		user.setEmail(getIntent().getStringExtra(PROPERTY_EMAIL_ADDRESS));
		user.setId(Long.parseLong(getIntent().getStringExtra(PROPERTY_USER_ID)));
		project.setId(Long.parseLong(getIntent().getStringExtra(PROPERTY_PROJECT_ID)));
		project.setName(getIntent().getStringExtra(PROPERTY_PROJECT_NAME));
		
		/* Set the title to the project name */
		ActionBar actionBar = getActionBar();
		actionBar.setTitle(project.getName());
		
		Log.d(TAG, "Starting CloudProjects activity with:" + user.toString() + project.toString());
		
		init();
		
		getUserTasks();
	}
	
	private void init() {
		context = getApplicationContext();
		cte = new Cloudtaskendpoint.Builder(AndroidHttp.newCompatibleTransport(), new GsonFactory(), null).setApplicationName("ctm-tudor").build(); 
		listview = (ListView) findViewById(R.id.lvGenericList);
		mDialog = new ProgressDialog(this);
		mDialog.setMessage("Loading...");
        mDialog.setCancelable(false);
	}
	
	private void getUserTasks() {
		new AsyncTask<Void, Void, List<CloudTask>>() {
			
			@Override
			protected void onPreExecute() {
				mDialog.show();
				super.onPreExecute();
			}			

			@Override
			protected List<CloudTask> doInBackground(Void... params) {
				List<CloudTask> tasks = null;
				CloudTaskDAO ctd = null;
				try {
					ctd = new CloudTaskDAO(context);
					ctd.open();
					
					//Check if user is online
					if(CommonUtilities.isOnline(context)) {
						//Get the tasks from the Internet
						tasks = cte.getusertasks(user.getId(), project.getId()).execute().getItems();
						if(tasks != null ) {
							ctd.clearTable();
							for (CloudTask task : tasks) {
								ctd.addTask(task);
							}
						}
						ctd.close();
					} else {
						//Get the tasks from the local Database
						tasks = ctd.getProjectTasks(project);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return tasks;
			}

			@Override
			protected void onPostExecute(List<CloudTask> result) {
				if (result != null) {
					Log.v(TAG, "Found " + result.size() + " tasks for user");
					tasks = result;
					displayTasks();
				} else {
					Toast.makeText(context, "No tasks found", Toast.LENGTH_LONG).show();
				}
				mDialog.hide();
				super.onPostExecute(result);
			}
		}.execute();
	}
	
	private void displayTasks() {
		final ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < tasks.size(); ++i) {
			list.add(tasks.get(i).getTaskTitle());
		}
		final StableArrayAdapter adapter = new StableArrayAdapter(this, android.R.layout.simple_list_item_1, list);
		listview.setAdapter(adapter);

		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
				showTaskDetails(position);
			}
		});
	}
	
	protected void showTaskDetails(int position) {
		
		CloudTask task = tasks.get(position);
		
		Log.d(TAG, "Sending task:" + task.toString());
		
		Intent intent = new Intent(this, TaskDisplay.class);
		intent.putExtra(PROPERTY_PROJECT_NAME, project.getName());
		intent.putExtra(PROPERTY_PROJECT_ID, project.getId());
		intent.putExtra(PROPERTY_TASK_ID, task.getId());
		intent.putExtra(PROPERTY_TASK_DESCRIPTION, task.getTaskDescription());
		intent.putExtra(PROPERTY_TASK_TITLE, task.getTaskTitle());
		intent.putExtra(PROPERTY_TASK_DUE_DATE, task.getTaskDueDate().getValue());
		intent.putExtra(PROPERTY_REMAINIG_TIME, task.getRemainingTime());
		intent.putExtra(PROPERTY_TOTAL_TIME, task.getTotalTime());
		startActivityForResult(intent, 1);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.cloudprojectsmenu, menu);
		return true;
	}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch(item.getItemId()) {
    	case R.id.mnuAddTask:
	    		Intent intent = new Intent(this, TaskDisplay.class);
	    		intent.putExtra(PROPERTY_PROJECT_NAME, project.getName());
	    		intent.putExtra(PROPERTY_PROJECT_ID, project.getId());
	    		startActivityForResult(intent, 2);
    		break;
    	}
    	return true;
    }
	
	@Override
    public void startActivityForResult(Intent intent, int requestCode) {
        intent.putExtra("requestCode", requestCode);
        super.startActivityForResult(intent, requestCode);
    }

	@Override
	protected void onStop() {
		if(mDialog != null) {
			mDialog.dismiss();
		}
		mDialog = null;
		super.onStop();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Log.d(TAG, "onActivityResult " + resultCode);
		if(resultCode == 0) {
			init();
			getUserTasks();
		} else {
			Log.d(TAG, "No need to reload the tasks, nothing important happened");
		}
	}
}
