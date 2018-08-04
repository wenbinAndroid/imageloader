package com.mrz.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.lib.loader.ImageLoader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView iv = findViewById(R.id.iv);
        ImageLoader.with(this).radius(10).useErrRes(false)
                .load("http://pic-bucket.nosdn.127.net/photo/0001/2018-08-03/DO94OVNL00AO0001NOS" +
                        ".jpg")
                .into(iv);
    }
}
