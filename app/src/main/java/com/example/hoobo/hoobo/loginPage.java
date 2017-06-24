package com.example.hoobo.hoobo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class loginPage extends AppCompatActivity implements View.OnClickListener {

    private Button btnLogin2;
    private EditText inputEmail;
    private EditText inputPwd;
    private TextView txtForgot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        //Declare the stuff
        btnLogin2 = (Button) findViewById(R.id.btnLogin2);

        inputEmail = (EditText) findViewById(R.id.inputEmail);
        inputPwd = (EditText) findViewById(R.id.inputPwd);

        txtForgot = (TextView) findViewById(R.id.txtForgot);

        btnLogin2.setOnClickListener(this);
        txtForgot.setOnClickListener(this);


    }

    private void LoginUser(){
        String email  = inputEmail.getText().toString().trim();
        String password  = inputPwd.getText().toString().trim();


    }


    @Override
    public void onClick(View v) {
        if(v == btnLogin2){
            LoginUser();
        }

        if(v == txtForgot){
            //ForgotPage();
        }

    }
}
