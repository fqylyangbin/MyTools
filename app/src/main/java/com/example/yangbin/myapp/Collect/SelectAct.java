package com.example.yangbin.myapp.Collect;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.yangbin.MyTool.R;

public class SelectAct extends Activity implements OnClickListener{

	private Button btn_delete,btn_back;

	private VideoView detail_video;
	private TextView detail_text;
	private CollectDB notes;
	private SQLiteDatabase dbWriter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select);

		btn_delete=(Button) findViewById(R.id.button_delete);
		btn_back=(Button) findViewById(R.id.button_back);
		detail_text=(TextView)findViewById(R.id.detail_text);

		btn_delete.setOnClickListener(this);
		btn_back.setOnClickListener(this);
		detail_video.setOnClickListener(this);

		notes=new CollectDB(this);
		dbWriter=notes.getWritableDatabase();//修改权限

		detail_text.setText(getIntent().getStringExtra(CollectDB.CONTENT));
		//detail_video.start();



	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.button_delete:
				deleteListView();
				finish();
				break;
			case R.id.button_back:
				finish();
				break;
			case R.id.detail_video:
				detail_video.start();
				break;
		}
	}

	public void deleteListView(){
		dbWriter.delete(CollectDB.TABLE_NAME,
				"_id="+getIntent().getIntExtra(CollectDB.ID, 0), null);

	}
}
