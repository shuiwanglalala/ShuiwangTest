package com.example.shuiwangtest;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shuiwangtest.okhtp.AccessHeaders;
import com.example.shuiwangtest.okhtp.AsynchronousGet;
import com.example.shuiwangtest.okhtp.CancelCall;
import com.example.shuiwangtest.okhtp.CheckHandshake;
import com.example.shuiwangtest.okhtp.GetExample;
import com.example.shuiwangtest.okhtp.LoggingInterceptors;
import com.example.shuiwangtest.okhtp.PostExample;
import com.example.shuiwangtest.okhtp.PostString;
import com.example.shuiwangtest.okhtp.PrintEvents;
import com.example.shuiwangtest.okhtp.PrintEventsNonConcurrent;

import java.io.IOException;

public class OkhttpActivity extends AppCompatActivity {

    private HandlerThread handlerThread;
    private Handler handler;
    private String[] in = new String[1];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            CancelCall.main(in);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        handlerThread = new HandlerThread("OkhttpActivity");
        handlerThread.start();
        handler = new Handler(handlerThread.getLooper());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }
}
