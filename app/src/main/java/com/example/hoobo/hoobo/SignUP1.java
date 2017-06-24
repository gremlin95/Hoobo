package com.example.hoobo.hoobo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUP1 extends AppCompatActivity implements View.OnClickListener {

    private Button btnGT;
    private Button btnHost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up1);

        btnGT = (Button) findViewById(R.id.btnGT);
        btnHost = (Button) findViewById(R.id.btnHost);

        btnGT.setOnClickListener(this);
        btnHost.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v == btnGT){
            finish();
            startActivity(new Intent(this, SignUp2.class));
        }

        if(v== btnHost){
            finish();
            startActivity(new Intent(this, SignUp2.class));
        }

    }
}
