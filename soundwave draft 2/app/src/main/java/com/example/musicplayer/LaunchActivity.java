package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;



import java.util.logging.LogRecord;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        background.start();
        //start thread
    }

    // Create Thread that will sleep for 3 seconds
    Thread background = new Thread() {
        public void run() {
            try {

                // Thread will sleep for 3 seconds
                sleep(3*1000);

                // After 3 seconds redirect to another intent
                Intent i=new Intent(getBaseContext(),HomeActivity.class);
                startActivity(i);

                //Remove activity
                finish();


            } catch (Exception e) {
            }
        }
    };
}





