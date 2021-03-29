package com.pay.sampleapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.pay.sampleapp.R;
import com.pay.sampleapp.ui.main.MainActivity;

public class SplashActivity extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 3000;
    Animation animCloud, animSun;
    ImageView imgSplashSun, imgSplashCloud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initView();
        new CountDownTimer(SPLASH_DISPLAY_LENGTH, 200) {

            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(mainIntent);
                finish();
            }

        }.start();

    }

    private void initView() {
        imgSplashSun = findViewById(R.id.imgSplashSun);
        imgSplashCloud = findViewById(R.id.imgSplashCloud);
        animCloud = AnimationUtils.loadAnimation(this, R.anim.amin_splash_cloud);
        animSun = AnimationUtils.loadAnimation(this, R.anim.anim_splash_sun);
        imgSplashCloud.startAnimation(animCloud);
        imgSplashSun.startAnimation(animSun);
    }
}