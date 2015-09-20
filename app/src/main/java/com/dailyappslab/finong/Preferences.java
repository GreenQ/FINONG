package com.dailyappslab.finong;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {
    SharedPreferences preferences;
    SharedPreferences preferencesOpenedLetters;
    SharedPreferences preferencesGold;
    SharedPreferences preferencesLastVisit;
    SharedPreferences preferencesSeqVisitAm;
    String Gold = "GOLD";
    String Lvl = "LVL";
    String LastVisitDate = "LAST_VISIT_DATE";
    String SequencialVisitsAmount = "SEQ_VISIT_AMOUNT";
    String AskForRate = "ASK_RATE";
    String IsFirstPackFinished = "SSECOND_PACK_DONE";

    public Preferences(Context context)
    {
        preferences = context.getSharedPreferences(Lvl, Context.MODE_PRIVATE);
        preferencesGold = context.getSharedPreferences(Gold, Context.MODE_PRIVATE);
        preferencesLastVisit = context.getSharedPreferences(LastVisitDate, Context.MODE_PRIVATE);
        preferencesSeqVisitAm = context.getSharedPreferences(SequencialVisitsAmount, Context.MODE_PRIVATE);
    }

    private boolean CheckGoldRange(int i)
    {
        if(i >= 0 && i <= 99999)
            return true;
        else
            return false;
    }
    private boolean CheckLevelRange(int i)
    {
        if(i > 0 && i <251)
            return true;
        else
            return false;
    }

    private boolean CheckSeqVisAmRange(int i)
    {
        if(i > -1 && i < 8)
            return true;
        else
            return false;
    }

    public boolean IsFirstPackFinished()
    {
        boolean temp = preferences.getBoolean(IsFirstPackFinished, false);
        return temp;
    }

    public boolean AskForRate()
    {
        boolean temp = preferences.getBoolean(AskForRate, true);
        return temp;
    }

    public int GetSequencialVisitsAmount()
    {
        int temp = preferences.getInt(SequencialVisitsAmount, 0);
        return temp;
    }

    public long GetLastVisitDate()
    {
        long temp = preferences.getLong(LastVisitDate, System.currentTimeMillis());
        return temp;
    }

    public int GetGoldAmount()
    {
        int temp = preferences.getInt(Gold, 200);

        if (CheckGoldRange(temp))
            return temp;
        else
            return 200;
    }

    public int GetCurrentLevel()
    {
        int temp = preferences.getInt(Lvl, 1) ;

        if (CheckLevelRange(temp))
            return temp;
        else
            return 1;
        //return preferences.getInt(curLevel, 1);
    }

    public void EditAskForRate()
    {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(AskForRate, false);
        editor.commit();
    }

    public void EditFirstPackCompletness()
    {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(IsFirstPackFinished, true);
        editor.commit();
    }

    public void EditSeqvencialVisitAmount(int seqVisAm)
    {
        if(!CheckSeqVisAmRange(seqVisAm))
            return;
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(SequencialVisitsAmount, seqVisAm);
        editor.commit();
    }

    public void EditLastVisitDate(long lastVisitDate)
    {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putLong(LastVisitDate, lastVisitDate);
        editor.commit();
    }

    public void EditGoldAmount(int i)
    {
        if(!CheckGoldRange(i))
            return;
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(Gold, i);
        editor.commit();
    }

    public void EditLevel(int i)
    {
        if (!CheckLevelRange(i))
            return;
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(Lvl, i);
        editor.commit();
    }
}
