package com.example.shuiwangtest;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabLayout;

public class TablayoutActivity extends AppCompatActivity {

    private TabLayout tab1,tab2,tab3;
    private String[] titles = new String[]{"最新","热门的","我的"};
    private String[] longTitles = new String[]{"推荐","热点","北京","视频","社会","图片","娱乐","科技","汽车"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);

        setTab1();
    }

    private void setTab1(){
        tab1 = (TabLayout) findViewById(R.id.tablayout1);
        for(int i=0;i<titles.length;i++){
            tab1.addTab(tab1.newTab());
            tab1.getTabAt(i).setText(titles[i]);
        }
    }
}
