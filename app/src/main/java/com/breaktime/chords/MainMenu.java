package com.breaktime.chords;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.luolc.emojirain.EmojiRainLayout;

import java.util.Locale;
import java.util.Objects;


public class MainMenu extends AppCompatActivity {
    private EmojiRainLayout mContainer;
    SaveData saveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Objects.requireNonNull(getSupportActionBar()).hide();

        saveData = new SaveData(getSharedPreferences(SaveData.PREFS_FILE, MODE_PRIVATE));
//        setLocal();
        Animation animationStrumming = AnimationUtils.loadAnimation(this, R.anim.trans_left_to_right);
        ImageView strumming = findViewById(R.id.strumming);
        strumming.startAnimation(animationStrumming);

        Animation animationChords = AnimationUtils.loadAnimation(this, R.anim.trans_right_to_left);
        ImageView chords = findViewById(R.id.chords);
        chords.startAnimation(animationChords);
        setImage();

        mContainer = findViewById(R.id.activity_main_menu);
        mContainer.addEmoji(changeColor(R.drawable.note1));
        mContainer.addEmoji(changeColor(R.drawable.note2));
        mContainer.addEmoji(changeColor(R.drawable.note3));
        mContainer.addEmoji(changeColor(R.drawable.note4));
        mContainer.addEmoji(changeColor(R.drawable.note5));
        mContainer.addEmoji(changeColor(R.drawable.note6));

        mContainer.stopDropping();
        mContainer.setPer(5);
        mContainer.setDuration(Integer.MAX_VALUE);
        mContainer.setDropDuration(12000);
        mContainer.setDropFrequency(1500);

        mContainer.startDropping();
    }

    private Drawable changeColor(int id){
        Drawable myDrawable = getResources().getDrawable(id);
        myDrawable.mutate().setColorFilter(getResources().getColor(R.color.icon_grey), PorterDuff.Mode.SRC_IN);
        return myDrawable;
    }

    public void setDayNightMode(View view) {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_UNSPECIFIED || AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_NO)
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        else
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//        setLocal();
        setImage();
        saveData.setDayNightMode();
    }

    public void setImage(){
        ImageButton imageButton = findViewById(R.id.dayNightImage);
        ImageView guitarImageButton = findViewById(R.id.guitar);
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_UNSPECIFIED || AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_NO) {
            imageButton.setBackground(getDrawable(R.drawable.sun));
            guitarImageButton.setBackground(getDrawable(R.drawable.guitar_dark));
        }
        else {
            imageButton.setBackground(getDrawable(R.drawable.moon));
            guitarImageButton.setBackground(getDrawable(R.drawable.guitar));
        }
    }

    public void openLearnChords(View view) {
        Intent intent = new Intent(this, LearnChords.class);
        startActivity(intent);
    }

    public void openChordsQuiz(View view) {
        Intent intent = new Intent(this, ChordsQuiz.class);
        startActivity(intent);
    }

    public void openSearchChord(View view) {
        Intent intent = new Intent(this, SearchChord.class);
        startActivity(intent);
    }

    public void openStrumming(View view) {
        Intent intent = new Intent(this, Strumming.class);
        startActivity(intent);
    }

    public void changeLanguage(View view) {
        String resultLocale = "";
        System.out.println(((Button)view).getText().toString());
        switch (((Button)view).getText().toString()){
            case "\uD83C\uDDF5\uD83C\uDDF1": // pl -> en
                resultLocale = "en";
                break;
            case "\uD83C\uDDEC\uD83C\uDDE7":  // en -> ru
                resultLocale = "ru";
                break;
            case "\uD83C\uDDF7\uD83C\uDDFA":  // ru -> pl
                resultLocale = "pl";
                break;
        }
        saveData.setLanguage(resultLocale);
//        setLocal();
    }

    public void setLocal() {
        String strLocal = saveData.getLanguage();
        Locale locale = new Locale(strLocal);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getBaseContext().getResources().updateConfiguration(configuration, null);

//        recreate();
        setContentView(R.layout.activity_main_menu);
        setImage();
    }
}