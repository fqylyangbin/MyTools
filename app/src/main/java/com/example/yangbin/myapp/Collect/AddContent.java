package com.example.yangbin.myapp.Collect;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.VideoView;
import com.example.yangbin.MyTool.R;
import java.io.File;
import java.text.SimpleDateFormat;

@SuppressLint("SimpleDateFormat")
public class AddContent extends Activity implements OnClickListener {

	private String val;
	private Button btn_save,btn_giveup;
	private ImageView img_photo;
	private VideoView v_video;
	private EditText edit_content;


	private CollectDB notesDB;
	private SQLiteDatabase dbWriter;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_content);

		val=getIntent().getStringExtra("flag");
		btn_save=(Button)findViewById(R.id.button_save);
		btn_giveup=(Button)findViewById(R.id.button_giveup);
		img_photo=(ImageView)findViewById(R.id.img_photo);
		v_video=(VideoView)findViewById(R.id.v_video);
		edit_content=(EditText)findViewById(R.id.edit_content);

		btn_save.setOnClickListener(this);
		btn_giveup.setOnClickListener(this);
		v_video.setOnClickListener(this);

		notesDB=new CollectDB(this);
		dbWriter=((CollectDB) notesDB).getWritableDatabase();

		initView();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.button_save:
				addDB();
				finish();
				break;
			case R.id.button_giveup:
				finish();
				break;
			case R.id.v_video:
				v_video.start();
				break;
		}
	}

	public void addDB(){
		ContentValues contentValues=new ContentValues();
		contentValues.put(CollectDB.CONTENT, edit_content.getText().toString());
		contentValues.put(CollectDB.TIME, getTime());
		dbWriter.insert(CollectDB.TABLE_NAME, null, contentValues);
	}

	private String getTime(){
		SimpleDateFormat format=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		java.util.Date date=new java.util.Date();
		String string=format.format(date);
		return string;
	}
	public void initView(){
		switch (val) {
			case "1"://文字
				img_photo.setVisibility(View.GONE);
				v_video.setVisibility(View.GONE);
				break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO 自动生成的方法存根
		super.onActivityResult(requestCode, resultCode, data);
	}
}
