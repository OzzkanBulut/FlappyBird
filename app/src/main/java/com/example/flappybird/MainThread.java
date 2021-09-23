package com.example.flappybird;

import android.graphics.Canvas;
import android.os.SystemClock;
import android.view.Surface;
import android.view.SurfaceHolder;

public class MainThread extends Thread{
    SurfaceHolder mySurfaceHolder ;
    long timeSpent ;
    long kickOfftime;
    long wait = 31;  // the time it takes for the frame to refresh in miliseconds
    boolean Running ;
    private static Canvas canvas;


    public MainThread(SurfaceHolder surfaceHolder) {
        this.mySurfaceHolder = surfaceHolder;
        Running = true ;
    }


    @Override
    public void run() {
        while(Running){
            kickOfftime = SystemClock.uptimeMillis();
            canvas = null ;
            try{
                canvas = mySurfaceHolder.lockCanvas();
                synchronized (mySurfaceHolder){
                    AppHolder.getGameManager().backgroundAnimation(canvas);
                    AppHolder.getGameManager().birdAnimation(canvas);
                    AppHolder.getGameManager().scrollingTube(canvas);
                }

            }catch (Exception e){
                e.printStackTrace();

            }
            finally {
                if(canvas != null){
                    try{
                        mySurfaceHolder.unlockCanvasAndPost(canvas);

                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
            timeSpent = SystemClock.uptimeMillis() - kickOfftime;
            if(timeSpent < wait){
                try{
                    Thread.sleep(wait-timeSpent);

                }catch(Exception e){
                    e.printStackTrace();
                }


            }
        }
    }
    public boolean IsRunning(){
        return Running;
    }
    public void setIsRunning(boolean state){
        Running = state;
    }
}
