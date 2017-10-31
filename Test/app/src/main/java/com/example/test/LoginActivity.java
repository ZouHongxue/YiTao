package com.example.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import qiu.niorgai.StatusBarCompat;

public class LoginActivity extends Activity{


    private TextView find_pwd ;
    private TextView reg ;
    private Button button;
    private EditText name;
    private EditText pwd;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        StatusBarCompat.translucentStatusBar(this);
        find_pwd = (TextView) findViewById(R.id.find_pwd);
        reg = (TextView) findViewById(R.id.reg);
        button = (Button) findViewById(R.id.login);
        name = (EditText) findViewById(R.id.loginAccount_id);
        pwd = (EditText) findViewById(R.id.password_id);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String name1 =  name.getText().toString();
                String pwd1 = pwd.getText().toString();
                if(name1.equals("admin")&&pwd1.equals("admin")){
                    Intent intent = new Intent();
                    intent.setClass(LoginActivity.this,LoginAceess.class);
                    LoginActivity.this.startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(),"用户名或密码错误",Toast.LENGTH_SHORT).show();
                }
            }
        });

        find_pwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this,FindPwd.class);
                LoginActivity.this.startActivity(intent);
//                Toast.makeText(getApplicationContext(),"点了我",Toast.LENGTH_SHORT).show();
            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this,RegActivity.class);
                LoginActivity.this.startActivity(intent);
//                Toast.makeText(getApplicationContext(),"点了我",Toast.LENGTH_SHORT).show();
            }
        });
    }


}




