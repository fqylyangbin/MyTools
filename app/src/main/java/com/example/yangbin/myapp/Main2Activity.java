package com.example.yangbin.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.yangbin.myapp.Collect.MainActivity;
import com.example.yangbin.MyTool.R;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        /*Button tool=findViewById(R.id.tool);
        tool.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                startActivity(intent);
            }
        });*/
    }
    public void Collect(View view){
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void Tool(View view){
        Intent intent=new Intent(this,toolActivity.class);
        startActivity(intent);
    }
    public  void Setting(View view){
        Intent intent=new Intent(this,settingActivity.class);
        startActivity(intent);
    }
}
