package com.example.shuiwangtest;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.shuiwangtest.util.LogUtils;

public class RadioButtonActivity extends AppCompatActivity {

    private static final String TAG = "RadioButtonActivity";

    private RadioGroup radioGroup;
    private int id1;
    private int id2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);
        radioGroup = findViewById(R.id.radioGroupId);
        id1 = R.id.radioButtonYes;
        id2 = R.id.radioButtonNo;
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                LogUtils.d(TAG, "onCheckedChanged: " + (checkedId == id1) + "  " + (checkedId == id2));

            }
        });

    }
}
