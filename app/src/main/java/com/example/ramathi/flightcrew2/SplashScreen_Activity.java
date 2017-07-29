package com.example.ramathi.flightcrew2;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;

/**
 * Created by TharinduWanninayake on 7/26/2017.
 */

public class SplashScreen_Activity extends Activity{

    //duration to wait
    private final int SPLASH_DISPLAY_LENGTH = 2000;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.splashscreen);

        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                // Create an Intent that will start the Menu-Activity
                Intent mainIntent = new Intent(SplashScreen_Activity.this,Login_Activity.class);
                SplashScreen_Activity.this.startActivity(mainIntent);
                SplashScreen_Activity.this.finish();
            }

        }, SPLASH_DISPLAY_LENGTH);
    }
}

