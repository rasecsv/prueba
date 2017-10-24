package com.example.hola.appmap;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;


public class login extends AppCompatActivity  {
    private Button btn,btnGra;
    private EditText usuario;
    private EditText contra;
    private int counter=3;
    int timer=10;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        usuario=(EditText)findViewById(R.id.user);
        contra=(EditText)findViewById(R.id.password);
        btn=(Button)findViewById(R.id.btnlogin);
        btnGra=(Button)findViewById(R.id.btnGratis);
        //eyeButton=(Button)findViewById(R.id.eyeButtom);
       btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //validate(usuario.getText().toString(),password.getText().toString());
            String user="admin";
            String pass="12345";
               if(((usuario.equals(user)) && ( contra.equals(pass)))){
                    Intent intent = new Intent(login.this,MapsActivity.class);
                    startActivity(intent);
                }else {

                        //Toast.makeText(getApplicationContext(),"Usuario incorrecto", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnGra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            setContentView(R.layout.activity_maps);
            }
        });
    }
   /* private void validate(String usuario,String password){
        if ((usuario =="admin") & (password=="12345")){
            Intent intent = new Intent(login.this,MapsActivity.class);
            startActivity(intent);
        }else{
            counter--;
            //Info.setText("No "+ String.valueOf(counter));
            if (counter==0){
                btnlogin.setEnabled(false);
            }
        }*/



}
