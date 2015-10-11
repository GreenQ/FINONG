package com.dailyappslab.finong;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
    String[] word;
    String[][] storedLetters;
    int occupiedContainerCounter = 0;
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
        showAd();
        //setHeight();

    }

//    private void setHeight()
//    {
//        //btn_l_0
//
//        for(int i = 0; i < 13; i++)
//        {
//            if(i == 13) {
//                return;
//            }
//            //findViewById(R.id.imageButtonLetter1);
//            int id = getResources().getIdentifier("btn_1_" + i, "id", this.getPackageName());
//            Button temp = (Button) findViewById(id);
//            //temp.
//            //temp.setImageResource(getResources().getIdentifier("letter_" + letters.GetLetterIndex(wordArray[i]), "drawable", this.getPackageName()));
//            temp.setHeight(temp.getWidth());
//            //temp.setVisibility(View.VISIBLE);
//            //storedLetters[i][0] = wordArray[i];
//            // }
//        }
//    }

    @Override
    public void onResume(){
        super.onResume();
        // Описать считывание текущего кол-ва монет и уровня с preferences

//        textViewCurrentLevel.setText(String.valueOf(preferences.GetCurrentLevel()));
//        textViewGold.setText(String.valueOf(preferences.GetGoldAmount()));
    }

    public void StartHintsActivity(View view)
    {
        Intent i = new Intent(GameActivity.this, HintsActivity.class);
        startActivity(i);

        overridePendingTransition(R.anim.layout_change_in, R.anim.layout_change_out);
    }

    public void StartMarketActivity(View view)
    {
        Intent i = new Intent(GameActivity.this, MarketActivity.class);
        startActivity(i);

        overridePendingTransition(R.anim.layout_change_in, R.anim.layout_change_out);
    }

    public void StartWinActivity(View view)
    {
        Intent i = new Intent(GameActivity.this, WinActivity.class);
        startActivity(i);

        overridePendingTransition(R.anim.layout_change_in, R.anim.layout_change_out);
    }

    private void initViews()
    {
        sq1 = (ImageView) findViewById(R.id.sq1);
        sq2 = (ImageView) findViewById(R.id.sq2);
        sq3 = (ImageView) findViewById(R.id.sq3);
        sq4 = (ImageView) findViewById(R.id.sq4);
    }

    private void showAd()
    {
        AdView adView = (AdView) this.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
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
//    private void CreateGuessWordContainers(int lvl)
//    {
//        LinearLayout layout = (LinearLayout) findViewById(R.id.letter_t_holder);
//        if(((LinearLayout) layout).getChildCount() > 0)
//            ((LinearLayout) layout).removeAllViews();
//
//        LinearLayout row = new LinearLayout(getBaseContext());
//        row.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
//
//        int id = getResources().getIdentifier("w" + lvl, "string", this.getPackageName());
//        word = (getResources().getString(id)).split("(?!^)");
//
//        int maxJ = word.length;
//        for (int j = 0; j < maxJ; j++) {
//            final Button btnTag = new Button(getBaseContext());
//            btnTag.setId(j);
//            btnTag.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    if (((Button) v).getText() != "") {
//                        int containerId = v.getId();
//
//                        int actualLetterIndex = getActualLetterArrayIndex(containerId);
//                        int id = getResources().getIdentifier("buttonLetter" + actualLetterIndex, "id", getPackageName());
//                        Button temp = (Button) findViewById(id);
//                        temp.setText(storedLetters[Integer.valueOf(actualLetterIndex)][0]);
//                        temp.setVisibility(View.VISIBLE);
//
//                        storedLetters[actualLetterIndex][0] = temp.getText().toString();
//                        storedLetters[actualLetterIndex][1] = "";
//                        btnTag.setText("");
//                        occupiedContainerCounter--;
//                    }
//                }
//            });
//
//            btnTag.setTextSize(TypedValue.COMPLEX_UNIT_FRACTION_PARENT, 12);
//
//            btnTag.setPadding(0,0,0,0);
//
//            btnTag.setLayoutParams(new LinearLayout.LayoutParams(AbsoluteLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
//            btnTag.setBackgroundColor(Color.BLACK);
//            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(btnTag.getLayoutParams());
//            params.width = getResources().getDimensionPixelSize(R.dimen.);
//            params.height = getResources().getDimensionPixelSize(R.dimen.guess_letter_height);
//            params.setMargins(2,2,2,2);
//            row.setGravity(Gravity.CENTER);
//            row.addView(btnTag, params);
//
//
//        }
//        createEaraserButton(row);
//        layout.addView(row);
//    }

    private int getActualLetterArrayIndex(int guessLetterIndex){
        for(int i = 0; i < 13; i++) {
            if(storedLetters[i][1] == String.valueOf(guessLetterIndex))
                return i;
        }
        return 0;
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
        Globals.ZoomPicture = ((ImageView) view).getDrawable();

        Intent i = new Intent(GameActivity.this, ZoomedImageActivity.class);
        startActivity(i);

        overridePendingTransition(R.anim.layout_zoom_in, R.anim.layout_change_out);
    }
}
