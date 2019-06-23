package com.example.yangbin.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yangbin.MyTool.R;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Timer timer=new Timer();
        TimerTask timerTask=new TimerTask(){
            @Override
            public void run(){
                Intent i=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(i);
                MainActivity.this.finish();
            }
        };
        timer.schedule(timerTask,1000*2);
    }
    }

