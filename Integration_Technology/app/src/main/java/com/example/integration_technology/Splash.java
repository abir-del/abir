package com.example.integration_technology;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

public class Splash extends Activity {
    private ProgressBar mProgress;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Show the splash screen
        setContentView(R.layout.activity_splash);
        mProgress = (ProgressBar) findViewById(R.id.splash_screen_progress_bar);

        // Start lengthy operation in a background thread
        new Thread(new Runnable() {
            public void run() {
                doWork();
                startApp();
                finish();
            }
        }).start();
    }

    private void doWork() {
        for (int progress = 0; progress < 100; progress += 10) {
            try {
                Thread.sleep(500);
                mProgress.setProgress(progress);
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    }

    private void startApp() {
        Intent intent = new Intent(Splash.this, MainActivity.class);
        startActivity(intent);
    }
}