package com.tudor.ctm.db;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.google.api.services.cloudprojectendpoint.model.CloudProject;

public class CloudProjectDAO {
	private static final String TAG = "CPDAO";
	private SQLiteDatabase database;
	private SQLiteHelper dbHelper;
	private String[] allColumns = { SQLiteHelper.Table.PROJECTTABLE.COLUMNS.id, SQLiteHelper.Table.PROJECTTABLE.COLUMNS.name };
	
	
	public CloudProjectDAO(Context context) {
		dbHelper = new SQLiteHelper(context);
	}
	
	public void open() {
		database = dbHelper.getWritableDatabase();
	}
	
	public void close() {
		dbHelper.close();
	}
	
	public boolean addProject (CloudProject project) {
		try {
			ContentValues values = new ContentValues();
			values.put(SQLiteHelper.Table.PROJECTTABLE.COLUMNS.id, project.getId());
			values.put(SQLiteHelper.Table.PROJECTTABLE.COLUMNS.name, project.getName());
			database.insertOrThrow(SQLiteHelper.Table.PROJECTTABLE.TABLENAME, null, values);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<CloudProject> getAllProjects() {
		Log.d(TAG, "Trying to get all the projects...");
		List<CloudProject> projects = null;
		try {
			Cursor cursor = database.query(SQLiteHelper.Table.PROJECTTABLE.TABLENAME, allColumns, null, null, null, null, null);
			cursor.moveToFirst();
			projects = new ArrayList<CloudProject>();
			while(!cursor.isAfterLast()) {
				projects.add(
							new CloudProject.Builder().id(cursor.getLong(0)).name(cursor.getString(1)).build()
						);
				cursor.moveToNext();
			}
			cursor.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return projects;
	}
	
	public void clearTable() {
		Log.w(TAG, "Clearing the table");
		database.execSQL("DELETE FROM " + SQLiteHelper.Table.PROJECTTABLE.TABLENAME);
	}

	
}
