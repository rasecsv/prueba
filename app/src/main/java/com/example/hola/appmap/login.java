package com.example.hola.appmap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;



public class login extends AppCompatActivity{
    private Button login;
    private EditText user;
    private EditText password;
    @Override protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }
}
