package me.chigo.gads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import me.chigo.gads.utils.AppNavigator;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 3000;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        handleSplashDelay();
    }
    private void handleSplashDelay(){

        imageView = findViewById(R.id.imageView);
        if(imageView !=null){
            imageView.setAnimation(AnimationUtils.loadAnimation(this,R.anim.splas_image_anim));
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                navigateToMainScreen();
            }
        },SPLASH_TIME_OUT);
    }

    private void navigateToMainScreen() {
        new AppNavigator(SplashActivity.this).navigateToMainScreen();
    }
}