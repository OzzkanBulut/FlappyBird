package com.example.flappybird;

import android.content.Context;
import android.media.MediaPlayer;
import android.provider.MediaStore;

public class SoundPlayer {
    Context context ;
    MediaPlayer move,score,crash,jump,back;


    public SoundPlayer(Context context) {
        this.context = context;
        move = MediaPlayer.create(context,R.raw.swoosh);
        crash = MediaPlayer.create(context,R.raw.hit);
        jump = MediaPlayer.create(context,R.raw.wing);
        score = MediaPlayer.create(context,R.raw.ping);
        back = MediaPlayer.create(context,R.raw.background);
    }

    public void playSwoosh(){
        if(move != null){
            move.start();
        }
    }

    public void playPing(){
        if(score != null){
            score.start();
        }
    }

    public void playCrash(){
        if(crash != null){
            crash.start();
        }
    }

    public void playWing(){
        if(jump!=null){
            jump.start();
        }
    }

    public void playBack(){
        if(back != null){
            back.start();
        }
    }

    public void stopBack(){
        if(back != null){
            back.stop();
        }

    }
}
