package com.example.mylibrary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Animation top, down;
    private static int SPLASH_SCREEN= 5000;
    private TextView logo, slogan;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        top= AnimationUtils.loadAnimation(this, R.anim.top_animation);
        down= AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        image= findViewById(R.id.imageLogo);
        logo= findViewById(R.id.textLogo);
        slogan= findViewById(R.id.textSlogan);

        image.setAnimation(top);
        logo.setAnimation(down);
        slogan.setAnimation(down);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent= new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        }, SPLASH_SCREEN);
    }
}