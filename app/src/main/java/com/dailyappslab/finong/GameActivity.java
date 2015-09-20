package com.dailyappslab.finong;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
//
//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.AdSize;
//import com.google.android.gms.ads.AdView;
//import com.google.android.gms.games.Game;


/**
 * Created by GreenQ on 17.09.2015.
 */
public class GameActivity extends Activity {

    Preferences preferences;
    TextView textViewCurrentLevel;
    TextView textViewGold;
    int DefaultGold;
    int DefaultLevel;
    ImageView sq1;
    ImageView sq2;
    ImageView sq3;
    ImageView sq4;
    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btn10;
    Button btn11;
    Button btn12;
    Button btn13;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.game);

        preferences = new Preferences(this);
        initViews();
        drawLevel();

        AdView adView = (AdView)this.findViewById(R.id.adView);
        try
        {
//            adView.setAdSize(AdSize.BANNER);
//            adView.setAdUnitId("ca-app-pub-3376890691318599/3908610460");
            AdRequest adRequest = new AdRequest.Builder().build();
//

            adView.loadAd(adRequest);

            // ShowRateUs();
        }
        catch (Exception ex)
        {
            AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
            dlgAlert.setMessage("Error occured" + ex.getMessage());
            dlgAlert.setTitle("Error occured");
            dlgAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();
        }
    }

    @Override
    public void onResume(){
        super.onResume();
        // Описать считывание текущего кол-ва монет и уровня с preferences

//        textViewCurrentLevel.setText(String.valueOf(preferences.GetCurrentLevel()));
//        textViewGold.setText(String.valueOf(preferences.GetGoldAmount()));
    }

    private void initViews()
    {
        sq1 = (ImageView) findViewById(R.id.sq1);
        sq2 = (ImageView) findViewById(R.id.sq2);
        sq3 = (ImageView) findViewById(R.id.sq3);
        sq4 = (ImageView) findViewById(R.id.sq4);
    }

    private void drawLevel()
    {
        DefaultGold = preferences.GetGoldAmount();
        DefaultLevel = preferences.GetCurrentLevel();
        SetImagesByLevel(preferences.GetCurrentLevel());
        //CreateGuessWordContainers(preferences.GetCurrentLevel());
        //GuessWordHandler wordHandler = new GuessWordHandler();
        //letters = new Letters();
        //randLettersSet = letters.GetRandomStrings(word);
        //SetLetterImages(randLettersSet);
    }

    private void SetImagesByLevel(int lvl)
    {
        sq1.setImageResource(getResources().getIdentifier("w" + lvl + "_1", "drawable", this.getPackageName()));
        sq2.setImageResource(getResources().getIdentifier("w" + lvl + "_2", "drawable", this.getPackageName()));
        sq3.setImageResource(getResources().getIdentifier("w" + lvl + "_3", "drawable", this.getPackageName()));
        sq4.setImageResource(getResources().getIdentifier("w" + lvl + "_4", "drawable", this.getPackageName()));
        //image4.setImageResource
    }

    public void StartZoomedImageActivity(View view)
    {
        //view.getResources().
        Globals.ZoomPicture = ((ImageView) view).getDrawable();

        Intent i = new Intent(GameActivity.this, ZoomedImageActivity.class);
        startActivity(i);

        overridePendingTransition(R.anim.layout_zoom_in, R.anim.layout_change_out);
    }
}
