package com.tudor.ctm;

import static com.tudor.ctm.CommonUtilities.PROPERTY_EMAIL_ADDRESS;
import static com.tudor.ctm.CommonUtilities.PROPERTY_USER_ID;
import static com.tudor.ctm.CommonUtilities.SENDER_ID;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.clouduserendpoint.Clouduserendpoint;
import com.google.api.services.clouduserendpoint.model.CloudUser;


public class Welcome extends Activity {
	
	    
	    static final int REQUEST_ACCOUNT_PICKER = 2;

	    /**
	     * Tag used on log messages.
	     */
	    static final String TAG = "CTM_WELCOME";

	    TextView mDisplay;
	    GoogleCloudMessaging gcm;
	    AtomicInteger msgId = new AtomicInteger();
	    SharedPreferences prefs;
	    Context context;
	    GoogleAccountCredential credential;

	    String regid;
	    String emailAddress;
	    Clouduserendpoint mCloudUserEndpoint = null;
	    CloudUser user;
	    
	    @Override
	    public void onCreate(Bundle savedInstanceState) {

	    	super.onCreate(savedInstanceState);

	        setContentView(R.layout.activity_main);
	        mDisplay = (TextView) findViewById(R.id.display);

        	//DO NOT DELETE THIS. YOU USE IT!!!
	        context = getApplicationContext();
	    	Clouduserendpoint.Builder endpointBuilder = new Clouduserendpoint.Builder(AndroidHttp.newCompatibleTransport(), new GsonFactory(), null);
	    	endpointBuilder.setApplicationName("ctm-tudor");
	    	mCloudUserEndpoint = endpointBuilder.build();
	    	
	        user = CommonUtilities.getRegisteredUser(context);
	        
	        if( user == null ) {
	        	credential = new GoogleAccountCredential(this, null);
		    	startActivityForResult(credential.newChooseAccountIntent(), REQUEST_ACCOUNT_PICKER);
	        } else {
	        	registerOnGCM();
	        	goToProjects();
	        }
	    }

	    private void goToProjects() {
        	Intent intent = new Intent(this, CloudProjects.class);
        	Log.d(TAG, "Starting CloudProjects activity with:" + user.toString());
        	intent.putExtra(PROPERTY_EMAIL_ADDRESS, user.getEmail());
    		intent.putExtra(PROPERTY_USER_ID, user.getId().toString());
        	startActivity(intent);
	    }
	    
	    @Override
		protected void onActivityResult(int requestCode, int resultCode, Intent data) {
			super.onActivityResult(requestCode, resultCode, data);
			switch (requestCode) {
			   case REQUEST_ACCOUNT_PICKER:
			     if (data != null && data.getExtras() != null) {
			       String accountName = data.getExtras().getString(AccountManager.KEY_ACCOUNT_NAME);
			       Log.v(TAG, "Account name from account manager:" + accountName);
			       if (accountName != null) {
			    	   Log.v(TAG, accountName);
			    	   emailAddress = accountName;
			    	   initializeNewUser(accountName);
			       }
			     }
			     break;
			 }
		}
	    
	    @Override
		public boolean onCreateOptionsMenu(Menu menu) {
			MenuInflater inflater = getMenuInflater();
			inflater.inflate(R.menu.activity_main, menu);
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


		private void registerOnGCM() {
	        regid = CommonUtilities.getRegistrationId(context);
	        
	        System.out.println(regid);
	        
	        if (regid.length() == 0) {
	            registerBackground();
	        } 
	        gcm = GoogleCloudMessaging.getInstance(this);
	    }

    
		private void registerBackground() {
	        new AsyncTask<Void,Void,String>() {
	        	
	            @Override
	            protected String doInBackground(Void... params) {
	                String msg = "";
	                try {
	                    if (gcm == null) {
	                        gcm = GoogleCloudMessaging.getInstance(context);
	                    }
	                    regid = gcm.register(SENDER_ID);
	                    msg = "Device registered, registration id=" + regid + "\n email registered for " + user.getEmail() + " - " + user.getId();
	                    mCloudUserEndpoint.registerdeviceforuser(regid, user.getEmail()).execute();

	                } catch (IOException ex) {
	                    msg = "Error :" + ex.getMessage();
	                }
	                return msg;
	            }

	            @Override
	            protected void onPostExecute(String msg) {
	                mDisplay.append(msg + "\n");
	            }
	        }.execute(null, null, null);
	    }
	    
	    private void initializeNewUser(final String emailAddress) {
	    	Log.v(TAG, "Attempting to initialize new user...");

	    	new AsyncTask<Void, Void, CloudUser>() {

				@Override
				protected CloudUser doInBackground(Void... params) {
					try {
						CloudUser u = new CloudUser();
						u.setEmail(emailAddress);
						u = mCloudUserEndpoint.insertCloudUser(u).execute();
						return u;
					} catch (IOException e) {
						e.printStackTrace();
					}
					return null;
				}

				@Override
				protected void onPostExecute(CloudUser result) {
					if(result != null) {
						user = result;
						if(result.getId() == null || result.getEmail() == null) {
							Toast.makeText(context, "Null email or user ID", Toast.LENGTH_LONG).show();
						} else {
							Log.d(TAG, "Setting user details to " + result.toString());
							CommonUtilities.setUserDetails(context, result.getEmail(), result.getId().toString());
							registerOnGCM();
							goToProjects();
						}
					} else {
						Toast.makeText(context, "User registration failed", Toast.LENGTH_LONG).show();
					}
				}
	    	}.execute();
	    }
}
