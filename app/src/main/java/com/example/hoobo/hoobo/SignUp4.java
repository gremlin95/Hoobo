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

public class SignUp4 extends AppCompatActivity implements View.OnClickListener {



    Button btnRegister;
    EditText txtPassword1;
    EditText txtPassword2;
    EditText signupEmail;
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up4);

        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser()!= null){
            //user already logged in
            //Mainpage here
            finish();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }

        progressDialog = new ProgressDialog(this);

        signupEmail = (EditText) findViewById(R.id.txtSignupEmail);

        btnRegister = (Button) findViewById(R.id.btnRegister);
        txtPassword1 = (EditText) findViewById(R.id.txtPassword1);
        txtPassword2 = (EditText) findViewById(R.id.txtPassword2);

        btnRegister.setOnClickListener(this);
    }

    private void RegisterUser(){

        String email = signupEmail.getText().toString().trim();
        String password = txtPassword2.getText().toString().trim();


        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Please enter a valid email", Toast.LENGTH_SHORT).show();
            //Stop function executing
            return;

        }

        if(TextUtils.isEmpty(password)) {

            Toast.makeText(this, "Please enter a valid Password", Toast.LENGTH_SHORT).show();
            //Stop function executing
            return;
        }

        //If completed

        progressDialog.setMessage("Registering user");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            finish();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }

                        else{
                            Toast.makeText(SignUp4.this, "Failed To Register User", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


    }


    @Override
    public void onClick(View v) {
        if (v == btnRegister) {
            RegisterUser();
        }

    }
}


