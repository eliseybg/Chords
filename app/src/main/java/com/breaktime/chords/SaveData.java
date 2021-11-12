package com.breaktime.chords;

import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatDelegate;

public class SaveData {

    private SharedPreferences sharedPreferences;
    public static final String PREFS_FILE = "save parameters";
    private static final String PREF_FIRST_OPEN_LEARN_CHORDS = "first open learn chords";
    private static final String PREF_FIRST_OPEN_SEARCH_CHORDS = "first open search chords";
    private static final String PREF_FIRST_OPEN_STRUMMING = "first open strumming";

    private static final String PREF_APP_LANGUAGE = "language";

    private String PREF_CHORD_M = "chord M";
    private String PREF_CHORD_SHARP = "chord sharp";
    private String PREF_CHORD_SHARP_m = "chord sharp m";
    private String PREF_CHORD_m = "chord m";
    private String PREF_CHORD_7 = "chord 7";
    private String PREF_CHORD_m7 = "chord m7";
    private String PREF_CHORD_9 = "chord 9";
    private String PREF_CHORD_m9 = "chord m9";
    private String PREF_CHORD_dim = "chord dim";
    private String PREF_CHORD_sus4 = "chord sus4";
    private String PREF_SPEED = "speed";
    private String PREF_TIME = "time";
    private String PREF_MODE = "mode";
    private String PREF_DAY_NIGHT_MODE = "day night mode";

    SaveData(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }


    public void setLanguage(String language) {
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        prefEditor.putString(PREF_APP_LANGUAGE, language);
        prefEditor.apply();
    }

    public String getLanguage() {
        return sharedPreferences.getString(PREF_APP_LANGUAGE, "en");
    }


    public boolean wasLearnChordsModeOpen(){
        if(!sharedPreferences.getBoolean(PREF_FIRST_OPEN_LEARN_CHORDS, false)) {
            SharedPreferences.Editor prefEditor = sharedPreferences.edit();
            prefEditor.putBoolean(PREF_FIRST_OPEN_LEARN_CHORDS, true);
            prefEditor.apply();
            return false;
        }
        return true;
    }

    public boolean wasSearchChordsModeOpen(){
        if(!sharedPreferences.getBoolean(PREF_FIRST_OPEN_SEARCH_CHORDS, false)) {
            SharedPreferences.Editor prefEditor = sharedPreferences.edit();
            prefEditor.putBoolean(PREF_FIRST_OPEN_SEARCH_CHORDS, true);
            prefEditor.apply();
            return false;
        }
        return true;
    }
    public boolean wasStrummingOpen(){
        if(!sharedPreferences.getBoolean(PREF_FIRST_OPEN_STRUMMING, false)) {
            SharedPreferences.Editor prefEditor = sharedPreferences.edit();
            prefEditor.putBoolean(PREF_FIRST_OPEN_STRUMMING, true);
            prefEditor.apply();
            return false;
        }
        return true;
    }

    public void setActivated(int id) {
        String placeToSave = "";
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();

        switch (id) {
            case R.id.chord_M:
                placeToSave = PREF_CHORD_M;
                break;
            case R.id.chord_Sharp:
                placeToSave = PREF_CHORD_SHARP;
                break;
            case R.id.chord_Sharp_m:
                placeToSave = PREF_CHORD_SHARP_m;
                break;
            case R.id.chord_m:
                placeToSave = PREF_CHORD_m;
                break;
            case R.id.chord_7:
                placeToSave = PREF_CHORD_7;
                break;
            case R.id.chord_m7:
                placeToSave = PREF_CHORD_m7;
                break;
            case R.id.chord_9:
                placeToSave = PREF_CHORD_9;
                break;
            case R.id.chord_m9:
                placeToSave = PREF_CHORD_m9;
                break;
            case R.id.chord_dim:
                placeToSave = PREF_CHORD_dim;
                break;
            case R.id.chord_sus4:
                placeToSave = PREF_CHORD_sus4;
                break;
        }
        prefEditor.putBoolean(placeToSave, !getActivated(id));
        prefEditor.apply();
    }

    public boolean getActivated(int id) {
        String getPlace = "";

        switch (id) {
            case R.id.chord_M:
                getPlace = PREF_CHORD_M;
                break;
            case R.id.chord_Sharp:
                getPlace = PREF_CHORD_SHARP;
                break;
            case R.id.chord_Sharp_m:
                getPlace = PREF_CHORD_SHARP_m;
                break;
            case R.id.chord_m:
                getPlace = PREF_CHORD_m;
                break;
            case R.id.chord_7:
                getPlace = PREF_CHORD_7;
                break;
            case R.id.chord_m7:
                getPlace = PREF_CHORD_m7;
                break;
            case R.id.chord_9:
                getPlace = PREF_CHORD_9;
                break;
            case R.id.chord_m9:
                getPlace = PREF_CHORD_m9;
                break;
            case R.id.chord_dim:
                getPlace = PREF_CHORD_dim;
                break;
            case R.id.chord_sus4:
                getPlace = PREF_CHORD_sus4;
                break;
        }

        return sharedPreferences.getBoolean(getPlace, true);
    }

    public void setSpeed(float duration) {
        String placeToSave = PREF_SPEED;
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        prefEditor.putFloat(placeToSave, duration);
        prefEditor.apply();
    }

    public float getSpeed() {
        return sharedPreferences.getFloat(PREF_SPEED, 1);
    }

    public void setTime(int time) {
        String placeToSave = PREF_TIME;
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        prefEditor.putInt(placeToSave, time);
        prefEditor.apply();
    }

    public int getTime() {
        return sharedPreferences.getInt(PREF_TIME, 1);
    }

    public void setMode(String mode) {
        String placeToSave = PREF_MODE;
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        prefEditor.putString(placeToSave, mode);
        prefEditor.apply();
    }

    public String getMode() {
        return sharedPreferences.getString(PREF_MODE, "random");
    }

    public void setDayNightMode() {
        String placeToSave = PREF_DAY_NIGHT_MODE;
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        prefEditor.putInt(placeToSave, AppCompatDelegate.getDefaultNightMode());
        prefEditor.apply();
    }

    public int getDayNightMode() {
        return sharedPreferences.getInt(PREF_DAY_NIGHT_MODE, AppCompatDelegate.getDefaultNightMode());
    }

}
