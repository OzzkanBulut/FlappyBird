package com.example.flappybird;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class AppHolder {
    static BitmapControl bitmapControl;
    static GameManager gameManager;
    static int SCRN_WIDTH_X;
    static int SCRN_HEIGHT_Y;
    static int gravityPull ;
    static int JUMP_VELOCITY;
    static int tubeGap;
    static int tube_numbers; // Holds the number of tubes
    static int tubeVelocity;
    static int minimumTubeCollection_Y;
    static int maximumTubeCollection_Y; // This will help hold the maximum value y for the bottom tube.
    static int tubeDistance;
    static Context gameActivityContext;
    static SoundPlayer soundPlay;

    public static void assign(Context context){
        // the mapScreensize method should be the first in the assign method
        mapScreenSize(context);
        bitmapControl = new BitmapControl(context.getResources());
        holdGameVariables();
        gameManager = new GameManager();
        soundPlay = new SoundPlayer(context);
    }

    public static SoundPlayer getSoundPlay(){
        return soundPlay;

    }

    public static void holdGameVariables(){
        AppHolder.gravityPull = 5 ;
        AppHolder.JUMP_VELOCITY = -40;
        AppHolder.tubeGap = 650 ;
        AppHolder.tube_numbers = 2;
        AppHolder.tubeVelocity = 24;
        AppHolder.minimumTubeCollection_Y =(int) (AppHolder.tubeGap/2.0);
        AppHolder.maximumTubeCollection_Y = AppHolder.SCRN_HEIGHT_Y - AppHolder.minimumTubeCollection_Y - AppHolder.tubeGap ;
        AppHolder.tubeDistance = AppHolder.SCRN_WIDTH_X*2/3;
    }


    public static BitmapControl getBitmapControl(){
        return bitmapControl;

    }
    public static GameManager getGameManager(){
        return gameManager;

    }


    private static void mapScreenSize(Context context){
        // The windowManager is responsible for organizing the screen of your Application and how windows should be laid out on the screen
        WindowManager manager =(WindowManager) context.getSystemService(context.WINDOW_SERVICE); // This is the interface that is used to interact with the window manager
        Display dsp = manager.getDefaultDisplay();
        DisplayMetrics dMetrics = new DisplayMetrics();
        dsp.getMetrics(dMetrics);
        int width = dMetrics.widthPixels;
        int height = dMetrics.heightPixels;
        AppHolder.SCRN_WIDTH_X = width;
        AppHolder.SCRN_HEIGHT_Y = height;





    }
}
