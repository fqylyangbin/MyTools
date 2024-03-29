package com.example.yangbin.myapp.BaiduTranslate;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.yangbin.myapp.BaiduTranslate.TransApi;
import com.example.yangbin.myapp.BaiduTranslate.TranslateResult;
import com.example.yangbin.MyTool.R;
import com.google.gson.Gson;

import java.util.List;


public class fyActivity extends AppCompatActivity {


    private Button button;
    private TextView textView;
    private Handler handler = new Handler();
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fy);
        initView();
    }

    private void initView() {
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String query =editText.getText().toString();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String resultJson = new TransApi().getTransResult(query, "auto", "en");
                        //拿到结果，对结果进行解析。
                        Gson gson = new Gson();
                        TranslateResult translateResult = gson.fromJson(resultJson, TranslateResult.class);
                        final List<TranslateResult.TransResultBean> trans_result = translateResult.getTrans_result();
                        handler.post(new Runnable() {
                            @Override
                            public void run() {

                                String dst = "";
                                for (TranslateResult.TransResultBean s : trans_result
                                        ) {
                                    dst = dst + "\n" + s.getDst();
                                }

                                textView.setText(dst);
                            }
                        });

                    }
                }).start();
            }
        });

    }
}
