package com.example.yangbin.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.example.yangbin.myapp.BaiduTranslate.fyActivity;
import com.example.yangbin.myapp.Kecbiao.MainActivity;
import com.example.yangbin.myapp.Rjiben.NotepadActivity;
import com.example.yangbin.MyTool.R;

public class toolActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool);

    }
    public void Collect(View view){
        Intent intent=new Intent(this, com.example.yangbin.myapp.Collect.MainActivity.class);
        startActivity(intent);
    }
    public  void Setting(View view){
        Intent intent=new Intent(this,settingActivity.class);
        startActivity(intent);
    }
    public void ReturnHome(View view){
        Intent intent=new Intent(this,Main2Activity.class);
        startActivity(intent);
    }
    public  void Jsq(View view){
        Intent intent=new Intent(this,jsqActivity.class);
        startActivity(intent);
    }
    public void Fy(View view){
        Intent intent=new Intent(this, fyActivity.class);
        startActivity(intent);
    }

    public void Kcb(View view){
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void Rjb(View view){
        Intent intent=new Intent(this, NotepadActivity.class);
        startActivity(intent);
    }
}
