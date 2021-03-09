package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Presentation.TaskActivity;

import static java.lang.Thread.sleep;

public class SplashPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if(getSupportActionBar() != null)
            getSupportActionBar().hide();
        setContentView(R.layout.activity_splash);
        Thread splashThread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(2100);
                    Intent it = new Intent(getApplicationContext(), TaskActivity.class);
                    startActivity(it);
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
            splashThread.start();
    }
}
