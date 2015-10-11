package com.dailyappslab.finong;

import android.app.Activity;
import android.app.Notification;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by TOPAC on 07.10.2015.
 */
public class HintsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.hints);
    }
}
