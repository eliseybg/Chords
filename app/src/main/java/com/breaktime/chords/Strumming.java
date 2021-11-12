package com.breaktime.chords;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

public class Strumming extends AppCompatActivity {
    SaveData data;
    AlertDialog alertAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strumming);
        data = new SaveData(getSharedPreferences(SaveData.PREFS_FILE, MODE_PRIVATE));
        Objects.requireNonNull(getSupportActionBar()).hide();
        if (!data.wasStrummingOpen())
            firstOpen();
        createChordList();
    }

    private void firstOpen() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View mView = getLayoutInflater().inflate(R.layout.first_open_strumming, null);
        mView.findViewById(R.id.btnOk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertAnswer.cancel();
            }
        });
        builder.setView(mView);
        builder.setCancelable(false);
        alertAnswer = builder.create();
        alertAnswer.show();
    }

    private void createChordList() {
        ListView chordsView = findViewById(R.id.chordsView);
        StrummingView strummingView = new StrummingView(this);
        chordsView.setAdapter(strummingView);
    }

    class StrummingView extends ArrayAdapter<String> {
//        String[] strummingName = {"", "испанский бой", "" , "шестерка"};
        String[] strummingName = {getString(R.string.four), getString(R.string.six), getString(R.string.eight), getString(R.string.tsoi), getString(R.string.spanish), getString(R.string.reggae), getString(R.string.downstrum_on_every_beat), getString(R.string.downstrum_and_come_back_twice), getString(R.string.downstrum_and_come_back_three_times)};
//        getString
//        String[] popularSongs = {"↑↓↑↑↑↑↑↑↑↑↑↑↓↓↓↓↓↓↓↓↓↓↓"};
//        String[] strumming = {"↓ ↓ ↓ ↓", "↓ ↓ ↓↑↓↑", "↓ ↓↑↓↑↓↑", "↓↑↓↑↓↑↓↑", "↓↑↓↑ ↑↓↑", "↓ ↓↑ ↑↓↑", "↓ ↓ ↑↓↑"};
        String[] strumming = {"↓↑↓↑", "↓↓↑↑↓↑", "↓↓↑↓↓↑↓↑", "↓↓↑↓↓↑↓↓↑↓↓↑", "↓↓↑↓↑↓↑", "↓↓×↓×↓↑×↓×↓×↓×↓↑×↓", "↓↓↓↓", "↓↓↓↑↓↑", "↓↓↑↓↑↓↑"};

        public StrummingView(Context context) {
            super(context, R.layout.row_chord_info, R.id.chordName, new String[9]);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row_strumming, parent, false);
            row.setEnabled(false);
            ((TextView)row.findViewById(R.id.strummingName)).setText(strummingName[position]);
            ((TextView)row.findViewById(R.id.strumming)).setText(strumming[position]);
            return row;
        }
    }
}