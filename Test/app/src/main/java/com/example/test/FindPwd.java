package com.example.test;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import qiu.niorgai.StatusBarCompat;

public class FindPwd extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_pwd);
        StatusBarCompat.translucentStatusBar(this);
    }
}
