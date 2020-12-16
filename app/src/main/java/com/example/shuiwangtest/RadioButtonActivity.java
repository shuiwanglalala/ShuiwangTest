package com.example.shuiwangtest;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.ToggleButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import com.example.shuiwangtest.util.LogUtils;

public class RadioButtonActivity extends AppCompatActivity {

    private static final String TAG = "RadioButtonActivity";

    private RadioGroup radioGroup;
    private int id1;
    private int id2;
    private SwitchCompat switchCompat;
    private CheckedTextView checkedTextView;
    private ToggleButton toggleButton;
    private CheckBox checkBox;

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

        switchCompat = findViewById(R.id.switchbutton);
        checkedTextView = findViewById(R.id.checked_textview);
        toggleButton = findViewById(R.id.togglebutton);
        checkBox = findViewById(R.id.checkbox);

        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                LogUtils.d(TAG, "onCheckedChanged:1 " + isChecked);
            }
        });
        checkedTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogUtils.d(TAG, "onCheckedChanged:2 " + checkedTextView.isChecked());
                checkedTextView.toggle();
            }
        });
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                LogUtils.d(TAG, "onCheckedChanged:3 " + isChecked);
            }
        });
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                LogUtils.d(TAG, "onCheckedChanged:4 " + isChecked);
            }
        });

    }
}
