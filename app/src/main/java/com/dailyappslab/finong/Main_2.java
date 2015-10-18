package com.dailyappslab.finong;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class Main_2 extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_coins);

        // получаем TabHost
        TabHost tabHost = getTabHost();
//        for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++) {
//            tabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.btn_fon1);
//        }
        // инициализация была выполнена в getTabHost
        // метод setup вызывать не нужно

        TabHost.TabSpec tabSpec;

        tabHost.getTabWidget().setDividerDrawable(R.drawable.fon_blur);

        tabSpec = tabHost.newTabSpec("tag1");
        tabSpec.setIndicator("МАГАЗИН", getResources().getDrawable(R.drawable.tab_active));
        tabSpec.setContent(new Intent(this, OneActivity.class));
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag2");
        tabSpec.setIndicator("ПОЛУЧИТЬ БЕСПЛАТНО");
        tabSpec.setContent(new Intent(this, TwoActivity.class));
        tabHost.addTab(tabSpec);
    }
}