package com.example.test;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import qiu.niorgai.StatusBarCompat;

public class LoginAceess extends Activity {

    private TextView textView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_aceess);
        StatusBarCompat.translucentStatusBar(this);
        textView = (TextView) findViewById(R.id.title_ac);
        textView.setText("登陆成功");
    }
}
