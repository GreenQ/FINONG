package com.dailyappslab.finong;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.startad.lib.SADView;

public class MainActivity extends Activity {

    TextView textViewCurrentLevel;
    TextView textViewGold;
    int goldBonus;
    boolean wasShown = false;
    SADView sadView;

    Preferences preferences;

    AnimationDrawable animation;
    Animation anim;

    ImageView buttonImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.main);
        preferences = new Preferences(this);
//        initViews();

        sadView = new SADView(this, getResources().getString(R.string.sadViewMiniBanner));
        LinearLayout layout = (LinearLayout)findViewById(R.id.admob);

        // Add the adView to it
        layout.addView(this.sadView);
        sadView.loadAd(SADView.LANGUAGE_RU);

        StartDailyCoinsActivity(null);

//        buttonImage = (ImageView) findViewById(R.id.play);
//        buttonImage.setBackgroundResource(R.drawable.btnanim);
//        animation = (AnimationDrawable) buttonImage.getBackground();

        anim = AnimationUtils.loadAnimation(this, R.anim.btn_anim);
    }

    public void StartGovnoActivity(View view)
    {
        Intent i = new Intent(MainActivity.this, GameActivity.class);
        startActivity(i);

        overridePendingTransition(R.anim.layout_change_in, R.anim.layout_change_out);
    }

    public void StartMarketActivity(View view)
    {
        Intent i = new Intent(MainActivity.this, MarketActivity.class);
        startActivity(i);

        overridePendingTransition(R.anim.layout_change_in, R.anim.layout_change_out);
    }

    public void StartGameActivity(View view)
    {
        //animation.stop();
        //animation.start();
        view.startAnimation(anim);
        anim.setDuration(400);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
        Intent i = new Intent(MainActivity.this, GameActivity.class);
        startActivity(i);
            }
        }, 3000);

        overridePendingTransition(R.anim.layout_change_in, R.anim.layout_change_out);
    }

    public void StartDailyCoinsActivity(View view)
    {
        Intent i = new Intent(MainActivity.this, DailyCoinsActivity.class);
        startActivity(i);

        overridePendingTransition(R.anim.layout_change_in, R.anim.layout_change_out);
    }

    @Override
    public void onResume(){
        super.onResume();
        // Описать считывание текущего кол-ва монет и уровня с preferences

        //textViewCurrentLevel.setText(String.valueOf(preferences.GetCurrentLevel()));
        //textViewGold.setText(String.valueOf(preferences.GetGoldAmount()));
    }
//kek
    @Override
    public void onWindowFocusChanged(boolean hasFocus)
    {
        if(hasFocus && !wasShown) {
            getDailyCoins();
            wasShown = true;
        }
    }

//    private void initViews()
//    {
//        textViewCurrentLevel = (TextView) findViewById(R.id.textViewCurLevel);
//        textViewGold = (TextView) findViewById(R.id.textViewGold);
//    }

    private void getDailyCoins()
    {

        int daysFromLastVisit = DailyCoins.getAmountOfSequencialVisits(preferences.GetLastVisitDate(), getResources().getConfiguration().locale, preferences.GetSequencialVisitsAmount());
        switch (daysFromLastVisit)
        {
            case 0:
                preferences.EditGoldAmount(preferences.GetGoldAmount()+10);
                preferences.EditSeqvencialVisitAmount(1);
                preferences.EditLastVisitDate(System.currentTimeMillis());
                //showAmountOfAddedGold(10);
                goldBonus = 10;
                showDailyCoins();
                break;
            case 10:
                break;
            case 7:
                preferences.EditGoldAmount(preferences.GetGoldAmount()+40);
                preferences.EditLastVisitDate(System.currentTimeMillis());
                preferences.EditSeqvencialVisitAmount(preferences.GetSequencialVisitsAmount()+1);
                //showAmountOfAddedGold(40);
                goldBonus = 40;
                showDailyCoins();
                break;
            case 6:
                preferences.EditGoldAmount(preferences.GetGoldAmount()+35);
                preferences.EditLastVisitDate(System.currentTimeMillis());
                preferences.EditSeqvencialVisitAmount(preferences.GetSequencialVisitsAmount() + 1);
                //showAmountOfAddedGold(35);
                goldBonus = 35;
                showDailyCoins();
                break;
            case 5:
                preferences.EditGoldAmount(preferences.GetGoldAmount()+30);
                preferences.EditLastVisitDate(System.currentTimeMillis());
                preferences.EditSeqvencialVisitAmount(preferences.GetSequencialVisitsAmount() + 1);
                //showAmountOfAddedGold(30);
                goldBonus = 30;
                showDailyCoins();
                break;
            case 4:
                preferences.EditGoldAmount(preferences.GetGoldAmount()+25);
                preferences.EditLastVisitDate(System.currentTimeMillis());
                preferences.EditSeqvencialVisitAmount(preferences.GetSequencialVisitsAmount() + 1);
                //showAmountOfAddedGold(25);
                goldBonus = 25;
                showDailyCoins();
                break;
            case 3:
                preferences.EditGoldAmount(preferences.GetGoldAmount()+20);
                preferences.EditLastVisitDate(System.currentTimeMillis());
                preferences.EditSeqvencialVisitAmount(preferences.GetSequencialVisitsAmount() + 1);
                //showAmountOfAddedGold(20);
                goldBonus = 20;
                showDailyCoins();
                break;
            case 2:
                preferences.EditGoldAmount(preferences.GetGoldAmount()+15);
                preferences.EditLastVisitDate(System.currentTimeMillis());
                preferences.EditSeqvencialVisitAmount(preferences.GetSequencialVisitsAmount() + 1);
                //showAmountOfAddedGold(15);
                goldBonus = 15;
                showDailyCoins();
                break;
            case 1:
                preferences.EditGoldAmount(preferences.GetGoldAmount()+10);
                preferences.EditLastVisitDate(System.currentTimeMillis());
                preferences.EditSeqvencialVisitAmount(preferences.GetSequencialVisitsAmount()+1);
                //showAmountOfAddedGold(10);
                goldBonus = 10;
                showDailyCoins();
                break;
            default:
                /*storedPreferences.EditGoldAmount(storedPreferences.GetGoldAmount()+10);
                storedPreferences.EditLastVisitDate(System.currentTimeMillis());*/
                //showAmountOfAddedGold(0);
                break;
        }
        preferences.EditLastVisitDate(System.currentTimeMillis());
    }

    private void showDailyCoins()
    {

    }
}
