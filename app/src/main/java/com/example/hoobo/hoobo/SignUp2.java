package com.example.hoobo.hoobo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class SignUp2 extends AppCompatActivity implements View.OnClickListener {

    private Button btnNext1;
    private TextView txtTC;
    private EditText txtFname;
    private EditText txtLname;
    private Spinner txtCountry;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);

        btnNext1 = (Button) findViewById(R.id.btnNext1);

        txtTC = (TextView) findViewById(R.id.txtTC);

        txtFname = (EditText) findViewById(R.id.txtFname);
        txtLname = (EditText) findViewById(R.id.txtLname);

        txtCountry = (Spinner) findViewById(R.id.txtCountry);

        btnNext1.setOnClickListener(this);
        txtTC.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v == btnNext1)
        finish();
        startActivity(new Intent(this, SignUp3.class));
    }
}
