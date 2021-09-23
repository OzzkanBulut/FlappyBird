package com.example.flappybird;

import android.content.Context;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

public class GamePlay extends SurfaceView implements SurfaceHolder.Callback {
    MainThread mainThread ;
    public GamePlay(Context context) {
        super(context);
        SurfaceHolder myHolder = getHolder();
        myHolder.addCallback(this);
        mainThread = new MainThread(myHolder);
    }

    @Override
    // This method is called when the surface is created
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        mainThread.setIsRunning(true);
        mainThread.start();    }



    @Override
    // This method is called when you want to change size or orientation of the SurfaceView
    // This method will not be used because the app is always displayed on a portrait oriantetion
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) { }



    @Override
    //Stop
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {

        boolean retry = true;
        while(retry){
            try {
                mainThread.setIsRunning(false);
                mainThread.join();
            }
            catch(InterruptedException e){
                e.printStackTrace();

            }
            retry = false;

        }


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(AppHolder.getGameManager().gameState == 0){
            AppHolder.getGameManager().gameState = 1;
            AppHolder.getSoundPlay().playSwoosh();
        }else {
            AppHolder.getSoundPlay().playWing();
        }

        AppHolder.getGameManager().bird.setVelocity(AppHolder.JUMP_VELOCITY);
        return true;
    }
}
