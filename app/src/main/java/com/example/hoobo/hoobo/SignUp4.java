package com.example.hoobo.hoobo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp4 extends AppCompatActivity implements View.OnClickListener {

    Button btnRegister;
    EditText txtPassword1;
    EditText txtPassword2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up4);

        btnRegister = (Button) findViewById(R.id.btnRegister);
        txtPassword1 = (EditText) findViewById(R.id.txtPassword1);
        txtPassword2 = (EditText) findViewById(R.id.txtPassword2);

        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btnRegister){
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }

    }
}
