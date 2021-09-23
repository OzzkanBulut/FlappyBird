package com.example.flappybird;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class GameOver extends AppCompatActivity {
    ImageButton mRestartBtn;
    TextView tScore , tBest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        mRestartBtn = findViewById(R.id.restartBtn);
        int scoreCount = getIntent().getExtras().getInt("score");
        SharedPreferences pref = getSharedPreferences("myStoragePreference",0);
        int scoreBest = pref.getInt("scoreBest",0);
        SharedPreferences.Editor  edit = pref.edit();
        if(scoreCount > scoreBest){
            scoreBest = scoreCount ;
            edit.putInt("scoreBest",scoreBest);
            edit.apply();
        }


        mRestartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(GameOver.this,MainActivity.class);
                startActivity( myIntent);
                finish();


            }
        });

        tScore = findViewById(R.id.scoreDisplay);
        tBest = findViewById(R.id.BestDisplay);
        tScore.setText("" + scoreCount);
        tBest.setText(""+scoreBest);
    }
}