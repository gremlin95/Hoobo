package com.example.hoobo.hoobo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp3 extends AppCompatActivity implements View.OnClickListener {

    Button btnNext2;
    EditText txtPhone;
    EditText txtSignUpEmail;
    EditText txtBday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up3);

        btnNext2 = (Button) findViewById(R.id.btnNext2);
        txtPhone = (EditText) findViewById(R.id.txtPhone);
        txtSignUpEmail = (EditText) findViewById(R.id.txtSignupEmail);
        txtBday = (EditText) findViewById(R.id.txtBday);

        btnNext2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btnNext2){
            finish();
            startActivity(new Intent(this, SignUp4.class));
        }
    }
}
