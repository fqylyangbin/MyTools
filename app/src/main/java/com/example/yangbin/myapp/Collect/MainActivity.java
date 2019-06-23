package com.example.yangbin.myapp.Collect;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.example.yangbin.MyTool.R;


public class MainActivity extends AppCompatActivity implements OnClickListener, OnItemClickListener{


	private Button btn_text;
	private ListView listView;
	private Intent i;
	private MyAdapter myAdapter;
	private CollectDB notesDB;
	private SQLiteDatabase dbReader;
	private SQLiteDatabase dbWriter;
	private Cursor cursor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_clooect);

		initView();
		//clearDatabase();//初始化，将原有数据库内容清空



	}

	public void initView(){
		listView=(ListView)findViewById(R.id.list);
		btn_text=(Button)findViewById(R.id.button_text);


		btn_text.setOnClickListener(this);
		listView.setOnItemClickListener(this);


		notesDB=new CollectDB(this);
		dbReader=notesDB.getReadableDatabase();
	}

	@Override
	public void onClick(View v) {
		i=new Intent(this,AddContent.class);
		switch (v.getId()) {
			case R.id.button_text:
				i.putExtra("flag", "1");
				startActivity(i);
				break;
		}
	}

	public void selectDB(){
		cursor=dbReader.query(CollectDB.TABLE_NAME, null, null, null, null, null, null);
		myAdapter=new MyAdapter(this, cursor);
		listView.setAdapter(myAdapter);
	}

	@Override
	protected void onResume() {
		super.onResume();
		selectDB();
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		cursor.moveToPosition(position);
		Intent intent=new Intent(MainActivity.this,SelectAct.class);
		intent.putExtra(CollectDB.ID, cursor.getInt(cursor.getColumnIndex(CollectDB.ID)));
		intent.putExtra(CollectDB.CONTENT, cursor.getString(cursor.getColumnIndex(CollectDB.CONTENT)));
		intent.putExtra(CollectDB.TIME, cursor.getString(cursor.getColumnIndex(CollectDB.TIME)));
		startActivity(intent);
	}

	//清空数据库操作
	public void clearDatabase(){
		dbWriter=notesDB.getWritableDatabase();
		dbWriter.delete(CollectDB.TABLE_NAME, null, null);
	}

}
