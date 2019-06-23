package com.example.yangbin.myapp.Collect;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CollectDB extends SQLiteOpenHelper{

	public CollectDB(Context context) {
		super(context, "notes", null, 1);
		// TODO 自动生成的构造函数存根
		//四个参数分别为context，数据库名，版本号
	}

	public static final String TABLE_NAME = "notes";
	public static final String ID = "_id";
	public static final String CONTENT = "content";
	public static final String TIME = "time";

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO 自动生成的方法存根
		db.execSQL("create table "+TABLE_NAME+"("
				+ID+" integer primary key autoincrement,"
				+CONTENT+" text not null,"
				+TIME+" text not null)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO 自动生成的方法存根

	}

}
