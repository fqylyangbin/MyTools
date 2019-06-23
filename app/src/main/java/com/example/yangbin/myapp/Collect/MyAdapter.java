package com.example.yangbin.myapp.Collect;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yangbin.MyTool.R;

@SuppressLint("ViewHolder")
public class MyAdapter extends BaseAdapter{

	private Context context;
	private Cursor cursor;
	private LinearLayout layout;
	private TextView tv_content;
	private TextView tv_time;

	public MyAdapter(Context context,Cursor cursor) {
		this.context=context;
		this.cursor=cursor;
	}

	@Override
	public int getCount() {
		return cursor.getCount();
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return cursor.getPosition();
	}

	@SuppressLint("InflateParams")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater=LayoutInflater.from(context);//加载视图的权限
		layout=(LinearLayout)inflater.inflate(R.layout.cell, null);//视图
		tv_content=(TextView)layout.findViewById(R.id.content);
		tv_time=(TextView)layout.findViewById(R.id.time);
		cursor.moveToPosition(position);
		String content=cursor.getString(cursor.getColumnIndex("content"));
		String time=cursor.getString(cursor.getColumnIndex("time"));
		tv_content.setText(content);
		tv_time.setText(time);
		return layout;
	}



}
