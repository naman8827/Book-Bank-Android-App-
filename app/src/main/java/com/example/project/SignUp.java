package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class SignUp extends AppCompatActivity {
    private static int SPLASH_SCREEN=2000;
    Button signup,signin;
    Animation buttonAnim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        signup=findViewById(R.id.button);
        signin=findViewById(R.id.button2);
        signup.setVisibility(View.INVISIBLE);
        signin.setVisibility(View.INVISIBLE);
       buttonAnim= AnimationUtils.loadAnimation(this,R.anim.button_anim);
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        buttonAnim.setInterpolator(interpolator);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                signup.startAnimation(buttonAnim);
                signin.startAnimation(buttonAnim);
                signup.setVisibility(View.VISIBLE);
                signin.setVisibility(View.VISIBLE);
            }
        }, 1000 );

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),account_signup.class);
                startActivity(intent);
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),account_signin.class);
                startActivity(intent);
            }
        });
    }
}
