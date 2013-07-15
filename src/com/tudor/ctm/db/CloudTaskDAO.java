package com.tudor.ctm.db;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.google.api.client.util.DateTime;
import com.google.api.services.cloudprojectendpoint.model.CloudProject;
import com.google.api.services.cloudtaskendpoint.model.CloudTask;
import com.tudor.ctm.db.SQLiteHelper.Table.TASKSTABLE;

public class CloudTaskDAO {
	private static final String TAG = "CTDAO";
	private SQLiteDatabase database;
	private SQLiteHelper dbHelper;
	private String[] allColumns = { TASKSTABLE.COLUMNS.id, TASKSTABLE.COLUMNS.title, TASKSTABLE.COLUMNS.description,
									TASKSTABLE.COLUMNS.dueDate, TASKSTABLE.COLUMNS.timeRemaining, TASKSTABLE.COLUMNS.totalTime,
									TASKSTABLE.COLUMNS.project
	};
	
	
	public CloudTaskDAO(Context context) {
		dbHelper = new SQLiteHelper(context);
	}
	
	public void open() {
		database = dbHelper.getWritableDatabase();
	}
	
	public void close() {
		dbHelper.close();
	}
	
	public boolean addTask (CloudTask task) {
		try {
			ContentValues values = new ContentValues();
			values.put(TASKSTABLE.COLUMNS.id, task.getId());
			values.put(TASKSTABLE.COLUMNS.description, task.getTaskDescription());
			values.put(TASKSTABLE.COLUMNS.dueDate, task.getTaskDueDate().getValue());
			values.put(TASKSTABLE.COLUMNS.project, task.getProject().getId());
			values.put(TASKSTABLE.COLUMNS.timeRemaining, task.getRemainingTime());
			values.put(TASKSTABLE.COLUMNS.title, task.getTaskTitle());
			values.put(TASKSTABLE.COLUMNS.totalTime, task.getTotalTime());
			database.insertOrThrow(TASKSTABLE.TABLENAME, null, values);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<CloudTask> getProjectTasks(CloudProject project) {
		Log.d(TAG, "Trying to get all the tasks for project " + project.getId());
		List<CloudTask> tasks = null;
		try {
			Cursor cursor = database.query(TASKSTABLE.TABLENAME, allColumns, null, null, null, null, null);
			cursor.moveToFirst();
			tasks = new ArrayList<CloudTask>();
			while(!cursor.isAfterLast()) {
				tasks.add(
							new CloudTask.Builder().id(cursor.getLong(0)).taskTitle(cursor.getString(1))
										.taskDescription(cursor.getString(2)).taskDueDate(new DateTime(cursor.getLong(3)))
										.remainingTime(cursor.getInt(4)).totalTime(cursor.getInt(5))
										.project(new CloudProject.Builder().id(project.getId()).name(project.getName()).build())
										.build()
						);
				cursor.moveToNext();
			}
			cursor.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tasks;
	}
	
	public void clearTable() {
		Log.w(TAG, "Clearing the table");
		database.execSQL("DELETE FROM " + TASKSTABLE.TABLENAME);
	}

	
}
