package com.breaktime.chords;

import android.content.SharedPreferences;

public class QuizData {

    private SharedPreferences sharedPreferences;
    public static final String PREFS_FILE = "save quiz data";
    private static final String PREF_FIRST_OPEN_QUIZ_CHORDS = "first open quiz chords";

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
    private String PREF_AMOUNT_OF_QUESTIONS = "amount of questions";

    QuizData(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }
    public boolean wasChordsModeOpen(){
        if(!sharedPreferences.getBoolean(PREF_FIRST_OPEN_QUIZ_CHORDS, false)) {
            SharedPreferences.Editor prefEditor = sharedPreferences.edit();
            prefEditor.putBoolean(PREF_FIRST_OPEN_QUIZ_CHORDS, true);
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

    public void setAmount(int amount) {
        String placeToSave = PREF_AMOUNT_OF_QUESTIONS;
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        prefEditor.putInt(placeToSave, amount);
        prefEditor.apply();
    }

    public int getAmount() {
        return sharedPreferences.getInt(PREF_AMOUNT_OF_QUESTIONS, 10);
    }

}
