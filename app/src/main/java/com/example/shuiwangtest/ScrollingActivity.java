package com.example.shuiwangtest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        init();

        findViewById(R.id.btn_webview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ScrollingActivity.this, WebviewActivity.class));
            }
        });
        findViewById(R.id.btn_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ScrollingActivity.this, DialogActivity.class));
            }
        });
        findViewById(R.id.btn_radiobutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ScrollingActivity.this, RadioButtonActivity.class));
            }
        });
        findViewById(R.id.btn_tablayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ScrollingActivity.this, TablayoutActivity.class));
            }
        });
        findViewById(R.id.btn_gesture).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ScrollingActivity.this, GestureActivity.class));
            }
        });
        findViewById(R.id.btn_glide).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ScrollingActivity.this, GlideActivity.class));
            }
        });
        findViewById(R.id.btn_okhttp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ScrollingActivity.this, OkhttpActivity.class));
            }
        });
        findViewById(R.id.btn_gson).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ScrollingActivity.this, GsonActivity.class));
            }
        });
    }

    private void init() {
        Logger.addLogAdapter(new AndroidLogAdapter());
    }

}
