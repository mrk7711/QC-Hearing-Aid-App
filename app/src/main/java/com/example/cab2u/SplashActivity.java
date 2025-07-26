package com.example.cab2u;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {

                SplashActivity.this.startActivity(new Intent(SplashActivity.this,SwitchActivity.class));
                SplashActivity.this.finish();
            }
        },3000);
    }
}