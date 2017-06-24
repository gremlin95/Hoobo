package com.example.hoobo.hoobo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private VideoView bgView ;
    private Button btnSignUp ;
    private Button btnLogin ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Declaration of Stuff
        bgView = (VideoView) findViewById(R.id.bgVideoView);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);

        btnSignUp.setOnClickListener(this);
        btnLogin.setOnClickListener(this);


        //Looping Video
        Uri uri = Uri.parse("android.resource://"+ getPackageName()+"/" +R.raw.bgimage);

        bgView.setVideoURI(uri);
        bgView.start();

        bgView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);

                mp.setVolume(0f, 0f);
            }
        });
    }

    @Override
    public void onClick(View v) {

        if(v == btnLogin){
            finish();
            startActivity(new Intent(this, loginPage.class));
        }

        if(v == btnSignUp){
            finish();
            startActivity(new Intent(this, SignUP1.class ));

        }
    }
}
