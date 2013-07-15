package com.tudor.ctm;

import static com.tudor.ctm.CommonUtilities.PROPERTY_EMAIL_ADDRESS;
import static com.tudor.ctm.CommonUtilities.PROPERTY_USER_ID;

import java.util.Date;

import com.google.api.services.clouduserendpoint.model.CloudUser;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/**
 * Helper class providing methods and constants common to other classes in the
 * app.
 */
public final class CommonUtilities {

    static final String SERVER_URL = "<YOUR BASE APPLICATION SERVER URL HERE>";

    /**
     * Google API project id registered to use GCM.
     */
    static final String SENDER_ID = "<YOUR GOOGLE PROJECT ID HERE>";

    /**
     * Tag used on log messages.
     */
    static final String TAG = "GCMDemo";

    /**
     * Intent used to display a message in the screen.
     */
    static final String DISPLAY_MESSAGE_ACTION = "com.tudor.ctm.DISPLAY_MESSAGE";

    /**
     * Intent's extra that contains the message to be displayed.
     */
    static final String EXTRA_MESSAGE = "message";
    
    public static final String PROPERTY_REG_ID = "registration_id";
    public static final String PROPERTY_EMAIL_ADDRESS = "email_address";
    public static final String PROPERTY_USER_ID = "user_id";
    public static final String PROPERTY_PROJECT_ID = "project_id";
    public static final String PROPERTY_PROJECT_NAME = "project_name";
    public static final String PROPERTY_APP_VERSION = "appVersion";
    public static final String PROPERTY_TASK_TITLE = "task_title";
    public static final String PROPERTY_TASK_DESCRIPTION = "task_description";
    public static final String PROPERTY_TASK_ID = "task_id";
    public static final String PROPERTY_TASK_DUE_DATE = "task_due_date";
    public static final String PROPERTY_REMAINIG_TIME = "remaining_time";
    public static final String PROPERTY_TOTAL_TIME = "total_time";
    public static final String PROPERTY_ON_SERVER_EXPIRATION_TIME = "onServerExpirationTimeMs";
    public static final long REGISTRATION_EXPIRY_TIME_MS = 1000 * 3600 * 24 * 7;
        

    /**
     * Notifies UI to display a message.
     * <p>
     * This method is defined in the common helper because it's used both by
     * the UI and the background service.
     *
     * @param context application's context.
     * @param message message to be displayed.
     */
    static void displayMessage(Context context, String message) {
        Intent intent = new Intent(DISPLAY_MESSAGE_ACTION);
        intent.putExtra(EXTRA_MESSAGE, message);
        context.sendBroadcast(intent);
    }
    
    public static String getRegistrationId(Context context) {
        final SharedPreferences prefs = getPrivatePreferences(context);
        String registrationId = prefs.getString(PROPERTY_REG_ID, "");
        if (registrationId.length() == 0) {
            Log.v(TAG, "Registration not found.");
            return "";
        }
        // check if app was updated; if so, it must clear registration id to
        // avoid a race condition if GCM sends a message
        int registeredVersion = prefs.getInt(PROPERTY_APP_VERSION, Integer.MIN_VALUE);
        int currentVersion = getAppVersion(context);
        if (registeredVersion != currentVersion || isRegistrationExpired(context)) {
            Log.v(TAG, "App version changed or registration expired.");
            return "";
        }
        return registrationId;
    }
    
    public static void setRegistrationId(Context context, String regId) {
        final SharedPreferences prefs = getPrivatePreferences(context);
        int appVersion = getAppVersion(context);
        Log.v(TAG, "Saving regId on app version " + appVersion);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(PROPERTY_REG_ID, regId);
        editor.putInt(PROPERTY_APP_VERSION, appVersion);
        long expirationTime = System.currentTimeMillis() + REGISTRATION_EXPIRY_TIME_MS;

        Log.v(TAG, "Setting registration expiry time to " +
                new Date(expirationTime));
        editor.putLong(PROPERTY_ON_SERVER_EXPIRATION_TIME, expirationTime);
        editor.commit();

    }
    
    public static void setUserDetails(Context context, String emailAddress, String userId) {
        final SharedPreferences prefs = getPrivatePreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(PROPERTY_EMAIL_ADDRESS, emailAddress);
        editor.putString(PROPERTY_USER_ID, userId);
        editor.commit();
    }
    
    public static boolean isOnline(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            if (netInfo != null && netInfo.isConnectedOrConnecting()) {
                return true;
            }
            return false;
    }
    
    public static CloudUser getRegisteredUser(Context context) {
    	final SharedPreferences prefs = getPrivatePreferences(context);
        String emailAddress = prefs.getString(PROPERTY_EMAIL_ADDRESS, "");
        String userId = prefs.getString(PROPERTY_USER_ID, "");
        if (emailAddress.length() == 0 || userId.length() == 0) {
            Log.v(TAG, "User not found.");
            return null;
        }
        CloudUser u = new CloudUser();
        u.setEmail(emailAddress);
        u.setId(Long.parseLong(userId));
        return u;
    }
    
    /**
     * @return Application's {@code SharedPreferences}.
     */
    private static SharedPreferences getPrivatePreferences(Context context) {
        return context.getSharedPreferences(Welcome.class.getSimpleName(), 
                Context.MODE_PRIVATE);
    }
    
    private static int getAppVersion(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionCode;
        } catch (NameNotFoundException e) {
            // should never happen
            throw new RuntimeException("Could not get package name: " + e);
        }
    }
    
    private static boolean isRegistrationExpired(Context context) {
        final SharedPreferences prefs = getPrivatePreferences(context);
        // checks if the information is not stale
        long expirationTime =
                prefs.getLong(PROPERTY_ON_SERVER_EXPIRATION_TIME, -1);
        return System.currentTimeMillis() > expirationTime;
    }
}
