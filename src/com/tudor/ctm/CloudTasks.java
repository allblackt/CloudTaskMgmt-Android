package com.tudor.ctm;

import static com.tudor.ctm.CommonUtilities.PROPERTY_EMAIL_ADDRESS;
import static com.tudor.ctm.CommonUtilities.PROPERTY_USER_ID;
import static com.tudor.ctm.CommonUtilities.PROPERTY_PROJECT_ID;
import static com.tudor.ctm.CommonUtilities.PROPERTY_PROJECT_NAME;

import com.google.api.services.cloudprojectendpoint.model.CloudProject;
import com.google.api.services.clouduserendpoint.model.CloudUser;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

public class CloudTasks extends Activity {
	
	private static final String TAG = "CT";
	private ListView listview;
	private ProgressDialog mDialog;
	private CloudUser user;
	private CloudProject project;
	private Context context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.genericlist);
		
		context = getApplicationContext();
		
		user = new CloudUser();
		project = new CloudProject();
		user.setEmail(getIntent().getStringExtra(PROPERTY_EMAIL_ADDRESS));
		user.setId(Long.parseLong(getIntent().getStringExtra(PROPERTY_USER_ID)));
		project.setId(Long.parseLong(getIntent().getStringExtra(PROPERTY_PROJECT_ID)));
		project.setName(getIntent().getStringExtra(PROPERTY_PROJECT_NAME));
		Log.d(TAG, "Starting CloudProjects activity with:" + user.toString() + project.toString());
		listview = (ListView) findViewById(R.id.lvGenericList);
	}
	
	

}
