package com.example.pause.activity.splash;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.pause.R;
import com.example.pause.activity.tutorial.WelcomeActivity;

public class SplashActivity extends   AppCompatActivity {

    private static int SPLASH_TIME_OUT=2000;


    /**
     * On Create Override .
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        this.splashActivityShow();
    }

    private void launchWelcomeScreen() {
        startActivity(  new Intent(SplashActivity.this,WelcomeActivity.class ));
        finish();
    }
    /**
     *  Showing splash screen with a timer. This will be useful when you
     * want to show case your app logo Company.
     */
    private void splashActivityShow() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                launchWelcomeScreen();
                finish();
            }
        }, SPLASH_TIME_OUT);

    }
}