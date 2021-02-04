package com.example.shuiwangtest;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.example.shuiwangtest.util.GlideApp;

public class GlideActivity extends AppCompatActivity {

    private static final String TAG = "GlideActivity";
    private ImageView iv3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);

        ImageView targetImageView = (ImageView) findViewById(R.id.iv);
        String internetUrl = "http://i.imgur.com/DvpvklR.png";
        String gifUrl = "http://i.kinja-img.com/gawker-media/image/upload/s--B7tUiM5l--/gf2r69yorbdesguga10i.gif";
        GlideApp.with(this)
                .load(gifUrl)
//                .placeholder(R.mipmap.ic_navi_homepage_taxi)
                .error(R.mipmap.ic_launcher_round)
//                .crossFade(1000)
//                .dontAnimate()

//                .listener()
                .into(targetImageView);

        RequestOptions cropOptions = new RequestOptions().centerCrop();
        TransitionOptions t;
        ImageView iv2 = (ImageView) findViewById(R.id.iv2);
        Glide.with(this)
                .load(R.mipmap.meizi1)
                .fitCenter()
                .into(iv2);
        Target target;


        iv3 = (ImageView) findViewById(R.id.iv3);


    }


}
