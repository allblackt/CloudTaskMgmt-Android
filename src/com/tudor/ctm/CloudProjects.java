package com.tudor.ctm;

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
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.cloudprojectendpoint.Cloudprojectendpoint;
import com.google.api.services.cloudprojectendpoint.model.CloudProject;
import com.google.api.services.clouduserendpoint.model.CloudUser;

import static com.tudor.ctm.CommonUtilities.PROPERTY_EMAIL_ADDRESS;
import static com.tudor.ctm.CommonUtilities.PROPERTY_USER_ID;
import static com.tudor.ctm.CommonUtilities.PROPERTY_PROJECT_ID;
import static com.tudor.ctm.CommonUtilities.PROPERTY_PROJECT_NAME;

public class CloudProjects extends Activity {

	private static final String TAG = "CPA";
	private Cloudprojectendpoint cpe = null;
	private CloudUser user = null;
	private Context context;
	private List<CloudProject> projects = null;
	private ListView listview;
	private ProgressDialog mDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.genericlist);

		ActionBar actionBar = getActionBar();
		actionBar.show();

		context = getApplicationContext();

		cpe = new Cloudprojectendpoint.Builder(
				AndroidHttp.newCompatibleTransport(), new GsonFactory(), null)
				.setApplicationName("ctm-tudor").build();

		user = new CloudUser();
		user.setEmail(getIntent().getStringExtra(PROPERTY_EMAIL_ADDRESS));
		user.setId(Long.parseLong(getIntent().getStringExtra(PROPERTY_USER_ID)));
		Log.d(TAG, "Starting CloudProjects activity with:" + user.toString());
		listview = (ListView) findViewById(R.id.lvGenericList);
		
		mDialog = new ProgressDialog(this);
		mDialog.setMessage("Loading...");
        mDialog.setCancelable(false);

		getUserProjects();
	}

	private void getUserProjects() {
		new AsyncTask<Void, Void, List<CloudProject>>() {

			@Override
			protected void onPreExecute() {
				mDialog.show();
				super.onPreExecute();
			}
			
			@Override
			protected List<CloudProject> doInBackground(Void... params) {
				try {
					List<CloudProject> results = cpe
							.getuserprojectsbyemail(user.getEmail()).execute()
							.getItems();
					return results;
				} catch (IOException e) {
					e.printStackTrace();
				}
				return null;
			}

			@Override
			protected void onPostExecute(List<CloudProject> results) {
				mDialog.hide();
				if (results != null) {
					Log.v(TAG, "Found " + results.size() + " projects for user");
					projects = results;
					populateListWithProjects();
				} else {
					Toast.makeText(context, "Null projects object", Toast.LENGTH_LONG).show();
					;
				}
			}
		}.execute();
	}

	private void populateListWithProjects() {
		final ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < projects.size(); ++i) {
			list.add(projects.get(i).getName());
		}
		final StableArrayAdapter adapter = new StableArrayAdapter(this, android.R.layout.simple_list_item_1, list);
		listview.setAdapter(adapter);

		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
				showuserTasks(position);
			}

		});
	}

	private void showuserTasks(int projectIndex) {
		CloudProject project = projects.get(projectIndex);
		Intent intent = new Intent(this, CloudTasks.class);
		intent.putExtra(PROPERTY_PROJECT_NAME, project.getName());
		intent.putExtra(PROPERTY_PROJECT_ID, project.getId().toString());
		intent.putExtra(PROPERTY_EMAIL_ADDRESS, user.getEmail());
		intent.putExtra(PROPERTY_USER_ID, user.getId().toString());
		startActivity(intent);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
    	switch(item.getItemId()) {
    	case R.id.options_clear:
    			Log.d(TAG, "Clearing data");
    			CommonUtilities.setUserDetails(context, null, null);
    			CommonUtilities.setRegistrationId(context, null);
    		break;
    	case R.id.options_exit:
    		finish();
    		break;
    	}
    	return true;
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
