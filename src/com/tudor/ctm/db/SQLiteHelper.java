package com.tudor.ctm.db;

import com.tudor.ctm.db.SQLiteHelper.Table.PROJECTTABLE;
import com.tudor.ctm.db.SQLiteHelper.Table.TASKSTABLE;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLiteHelper extends SQLiteOpenHelper {
	
	private static final String TAG = "CTM-SQLH";
	private static final String DatabaseName = "ctm-tudor";
	private static final int DatabaseVersion = 1;
	
	public static final class Table {
		public static final class TASKSTABLE {
			public static final String TABLENAME = "tasks";
			public static final class COLUMNS {
				public static final String id = "_id";
				public static final String description = "description";
				public static final String title = "title";
				public static final String dueDate = "duedate";
				public static final String timeRemaining = "timeremaining";
				public static final String totalTime = "totaltime";
				public static final String project = "project";
			}
		}
		
		public static final class PROJECTTABLE {
			public static final String TABLENAME = "projects";
			public static final class COLUMNS {
				public static final String id = "_id";
				public static final String name = "name";
			}
		}
	}
	
	private static final String createProjetsTable = String.format("CREATE TABLE %s (%s text, %s text)", 
																PROJECTTABLE.TABLENAME, PROJECTTABLE.COLUMNS.id, PROJECTTABLE.COLUMNS.name);
	
	private static final String createTasksTable = String.format("CREATE TABLE %s (%s text,%s text,%s text, %s text,%s text,%s text,%s text)",
													TASKSTABLE.TABLENAME, TASKSTABLE.COLUMNS.id, TASKSTABLE.COLUMNS.description, TASKSTABLE.COLUMNS.title,
													TASKSTABLE.COLUMNS.dueDate, TASKSTABLE.COLUMNS.timeRemaining, TASKSTABLE.COLUMNS.totalTime, TASKSTABLE.COLUMNS.project);

	public SQLiteHelper(Context context) {
		super(context, DatabaseName, null, DatabaseVersion);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(createTasksTable);
		db.execSQL(createProjetsTable);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(TAG, "Dropping and recreating everything...");
		db.execSQL("DROP TABLE IF EXISTS " + TASKSTABLE.TABLENAME);
		db.execSQL("DROP TABLE IF EXISTS " + PROJECTTABLE.TABLENAME);
	}
	
}
