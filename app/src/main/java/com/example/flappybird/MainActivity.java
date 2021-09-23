package com.example.flappybird;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        AppHolder.assign(this.getApplicationContext());
        View mButton = findViewById(R.id.exitBtn);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(1);
            }});

    }

    public void startGame(View view){
        // An Intent is a messaging object that used to request an action from another app component
        Intent intent = new Intent(this,GameActivity.class);
        startActivity(intent);
        finish();
    }

    public void exitGame(View view){



    }
}