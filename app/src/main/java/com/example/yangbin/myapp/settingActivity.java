package com.example.yangbin.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.yangbin.myapp.Collect.MainActivity;
import com.example.yangbin.myapp.Setting.Gyu;
import com.example.yangbin.myapp.Setting.Rjxx;
import com.example.yangbin.MyTool.R;

public class settingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
    }
    public void ReturnHome(View view){
        Intent intent=new Intent(this,Main2Activity.class);
        startActivity(intent);
    }
    public void Tool(View view){
        Intent intent=new Intent(this,toolActivity.class);
        startActivity(intent);
    }
    public void Collect(View view){
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);

    }
    public void Gyu(View view){

        Intent intent=new Intent(this, Gyu.class);
        startActivity(intent);
    }

    public void Rjxx(View view){
        Intent intent =new Intent(this, Rjxx.class);
        startActivity(intent);
    }
}
