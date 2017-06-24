package com.example.hoobo.hoobo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loginPage extends AppCompatActivity implements View.OnClickListener {

    private Button btnLogin2;
    private EditText inputEmail;
    private EditText inputPwd;
    private TextView txtForgot;
    private ProgressDialog progressDialog;
    private FirebaseAuth fbAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        //Declare the stuff
        btnLogin2 = (Button) findViewById(R.id.btnLogin2);

        fbAuth = FirebaseAuth.getInstance();

        if(fbAuth.getCurrentUser()!= null){
            //user already logged in
            //Mainpage here
            finish();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }

        progressDialog = new ProgressDialog(this);

        inputEmail = (EditText) findViewById(R.id.inputEmail);
        inputPwd = (EditText) findViewById(R.id.inputPwd);

        txtForgot = (TextView) findViewById(R.id.txtForgot);

        btnLogin2.setOnClickListener(this);
        txtForgot.setOnClickListener(this);


    }

    private void LoginUser(){
        String email = inputEmail.getText().toString().trim();
        String password = inputPwd.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "User not registered", Toast.LENGTH_SHORT).show();
            //Stop function executing
            return;

        }

        if(TextUtils.isEmpty(password)) {

            Toast.makeText(this, "Wrong Password", Toast.LENGTH_SHORT).show();
            //Stop function executing

            return;

        }

        //If completed

        progressDialog.setMessage("Logging You in");
        progressDialog.show();

        fbAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        progressDialog.dismiss();
                        if(task.isSuccessful()) {
                            //Start main page activity
                            finish();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }

                    }
                });
    }


    @Override
    public void onClick(View v) {
        if(v == btnLogin2){
            LoginUser();
        }

        if(v == txtForgot){
            //ForgotPage
        }

    }
}
