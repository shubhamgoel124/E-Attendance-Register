package com.example.yashi.e_attendanceregister.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yashi.e_attendanceregister.R;

public class SplashScreenActivity extends AppCompatActivity {
    ImageView iv;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_spash_screen);

        getSupportActionBar().hide();

        iv = (ImageView) findViewById(R.id.imageSplash);
        tv = (TextView) findViewById(R.id.textSplash);

        Animation myAnimation = AnimationUtils.loadAnimation(this, R.anim.my_transition);
        iv.startAnimation(myAnimation);
        tv.startAnimation(myAnimation);

        Thread loading = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                    Intent i = new Intent(SplashScreenActivity.this, MainActivity.class);
                    startActivity(i);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    finish();
                }
            }
        };

        loading.start();
    }
}
