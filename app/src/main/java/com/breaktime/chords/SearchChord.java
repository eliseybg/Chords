package com.breaktime.chords;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

public class SearchChord extends AppCompatActivity {
    private int fret = 1;
    static LayoutInflater inflater;
    ArrayList<Chord> chordList;
    SaveData data;
    Dialog listPopup;
    AlertDialog alertAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_chord);
        Objects.requireNonNull(getSupportActionBar()).hide();
        inflater = getLayoutInflater();
        listPopup = new Dialog(this);
        data = new SaveData(getSharedPreferences(SaveData.PREFS_FILE, MODE_PRIVATE));
        if (!data.wasSearchChordsModeOpen())
            firstOpen();
        setOnDrawListener();
        chordList = getChordsList();
    }

    private void firstOpen() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View mView = getLayoutInflater().inflate(R.layout.first_open_chord_search, null);
        Button btnCheckAnswer = (Button) mView.findViewById(R.id.btnOk);
        btnCheckAnswer.setOnClickListener(new View.OnClickListener() {
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

    float startX = 0;
    float startY = 0;

    private void setOnDrawListener() {
        for (int i = 0; i < Strings.strings.length; i++) {
            for (int j = 0; j < Strings.strings[0].length; j++) {
                setListener(findViewById(Strings.strings[i][j]), i);
            }
        }
    }

    private void setListener(View view, final int finalI) {
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    startX = event.getX();
                    startY = event.getY();
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    float endX = event.getX();
                    float endY = event.getY();

                    if (Math.abs(endX - startX) > 400) {
                        for (int i = 0; i < Strings.barre.length; i++) {
                            if (findViewById(Strings.barre[i]).isActivated() && Strings.barre[finalI] != Strings.barre[i]) {
                                findViewById(Strings.barre[i]).setActivated(false);
                                break;
                            }
                            for (int j = 0; j < Strings.strings[0].length; j++) {
                                findViewById(Strings.strings[i][j]).setClickable(true);
                            }
                        }

                        findViewById(Strings.barre[finalI]).setActivated(!findViewById(Strings.barre[finalI]).isActivated());
                        boolean isClickable = false;
                        if (!findViewById(Strings.barre[finalI]).isActivated())
                            isClickable = true;

                        for (int i = 0; i < Strings.openCloseStrings.length; i++) {
                            findViewById(Strings.openCloseStrings[i]).setClickable(isClickable);
                        }

                        for (int i = 0; i <= finalI; i++) {
                            for (int j = 0; j < Strings.strings[0].length; j++) {
                                if (findViewById(Strings.strings[i][j]).isActivated()) {
                                    findViewById(Strings.strings[i][j]).setActivated(false);
                                }
                            }
                        }
                        if (!findViewById(Strings.barre[finalI]).isActivated()) {
                            for (int i = 0; i <= finalI; i++) {
                                for (int j = 0; j < Strings.strings[0].length; j++) {
                                    findViewById(Strings.strings[i][j]).setClickable(true);
                                    ((TextView) findViewById(Strings.openCloseStrings[j])).setText("○");
                                }
                            }
                            for (int i = 0; i < Strings.strings.length; i++) {
                                for (int j = 0; j < Strings.strings[0].length; j++) {
                                    if (findViewById(Strings.strings[i][j]).isActivated()) {
                                        ((TextView) findViewById(Strings.openCloseStrings[j])).setText("");
                                    }
                                }
                            }
                        } else {
                            for (int i = 0; i < Strings.openCloseStrings.length; i++) {
                                ((TextView) findViewById(Strings.openCloseStrings[i])).setText("");
                            }
                        }
                    }
                }
                checkChord();
                return false;
            }
        });
    }

    public void setActivated(View view) {
        int string = Strings.searchStingPosition((TextView) view);
        ((TextView) findViewById(Strings.openCloseStrings[string])).setText("");
        int linePosition = Strings.searchLinePosition((TextView) view);
        int barrePosition = -1;
        for (int i = 0; i < Strings.barre.length; i++) {
            if (findViewById(Strings.barre[i]).isActivated()) {
                barrePosition = i;
                break;
            }
        }

        if (linePosition < barrePosition || findViewById(Strings.barre[Strings.searchLinePosition((TextView) view)]).isActivated())
            return;

        for (int i = 0; i < Strings.strings.length; i++) {
            if (view != findViewById(Strings.strings[i][string]) & findViewById(Strings.strings[i][string]).isActivated()) {
                findViewById(Strings.strings[i][string]).setActivated(false);
                break;
            }
        }

        view.setActivated(!view.isActivated());
        if (!view.isActivated() & barrePosition == -1)
            ((TextView) findViewById(Strings.openCloseStrings[string])).setText("○");
        checkChord();

    }

    public void riseFret(View view) {
        fret++;
        ((TextView) findViewById(R.id.guitarFret)).setText(fret + "");
        checkChord();
    }

    public void downFret(View view) {
        if (fret > 1)
            fret--;
        ((TextView) findViewById(R.id.guitarFret)).setText(fret + "");
        checkChord();
    }

    public void openCloseString(View view) {
        if (((TextView) view).getText().toString().equals("○"))
            ((TextView) view).setText("×");
        else ((TextView) view).setText("○");
        int string = Strings.searchOpenStingPosition((TextView) view);
        for (int i = 0; i < Strings.strings.length; i++)
                findViewById(Strings.strings[i][string]).setActivated(false);
        checkChord();
    }

    private void checkChord(){
        ((TextView) findViewById(R.id.chordName)).setText("");
        int[] openCloseStrings = new int[Strings.openCloseStrings.length];
        for (int i = 0; i < Strings.openCloseStrings.length; i++) {
            switch ( ((TextView) findViewById(Strings.openCloseStrings[i])).getText().toString()) {
                case "×":
                    openCloseStrings[i] = -1;
                    break;
                case "":
                    openCloseStrings[i] = 0;
                    break;
                case "○":
                    openCloseStrings[i] = 1;
                    break;
            }
        }
        int[][] strings = {
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};
        int startLine = 0;
        for (int i = 0; i < Strings.barre.length; i++) {
            if (findViewById(Strings.barre[i]).isActivated()){
                startLine = i;
                for (int j = 0; j < strings[0].length; j++) {
                    strings[i][j] = 2;
                }
                break;
            }
        }

        for (int i = startLine; i < Strings.strings.length; i++) {
            for (int j = 0; j < Strings.strings[0].length; j++) {
                if (findViewById(Strings.strings[i][j]).isActivated()){
                    strings[i][j] = 1;
                }
            }
        }

        Chord resultChord = new Chord(null, fret, strings, openCloseStrings);
        for (int i = 0; i < chordList.size(); i++) {
            if (resultChord.compare(chordList.get(i))) {
                TextView chordName = findViewById(R.id.chordName);
                if (!chordName.getText().toString().equals(""))
                chordName.setText(chordName.getText().toString() + "/");
                chordName.setText(chordName.getText().toString() + chordList.get(i).chordName);

            }
        }
    }

    public void openChordList(View view) {
        listPopup.setContentView(R.layout.popup_chord_list);
        createChordList(listPopup);
        listPopup.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listPopup.dismiss();
            }
        });

        listPopup.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        listPopup.setCancelable(false);
        listPopup.show();
    }

    private void createChordList(Dialog window) {
        ListView chordsView = window.findViewById(R.id.chordsView);
        Chords vacancies = new Chords(this, getChordsList());
        chordsView.setAdapter(vacancies);
    }

    private ArrayList<Chord> getChordsList() {
        ArrayList<Chord> chordList = new ArrayList<>();
        chordList.add(ChordsSet.A);
        chordList.add(ChordsSet.B);
        chordList.add(ChordsSet.C);
        chordList.add(ChordsSet.D);
        chordList.add(ChordsSet.E);
        chordList.add(ChordsSet.F);
        chordList.add(ChordsSet.G);

        chordList.add(ChordsSet.A_Sharp);
        chordList.add(ChordsSet.B_Sharp);
        chordList.add(ChordsSet.C_Sharp);
        chordList.add(ChordsSet.D_Sharp);
        chordList.add(ChordsSet.E_Sharp);
        chordList.add(ChordsSet.F_Sharp);
        chordList.add(ChordsSet.G_Sharp);

        chordList.add(ChordsSet.A_Sharp_m);
//            chordList.add(ChordsSet.B_Sharp_m);
        chordList.add(ChordsSet.C_Sharp_m);
        chordList.add(ChordsSet.D_Sharp_m);
//            chordList.add(ChordsSet.E_Sharp_m);
        chordList.add(ChordsSet.F_Sharp_m);
        chordList.add(ChordsSet.G_Sharp_m);

        chordList.add(ChordsSet.Am);
        chordList.add(ChordsSet.Bm);
        chordList.add(ChordsSet.Cm);
        chordList.add(ChordsSet.Dm);
        chordList.add(ChordsSet.Em);
        chordList.add(ChordsSet.Fm);
        chordList.add(ChordsSet.Gm);

        chordList.add(ChordsSet.A7);
        chordList.add(ChordsSet.B7);
        chordList.add(ChordsSet.C7);
        chordList.add(ChordsSet.D7);
        chordList.add(ChordsSet.E7);
        chordList.add(ChordsSet.F7);
        chordList.add(ChordsSet.G7);

        chordList.add(ChordsSet.Am7);
        chordList.add(ChordsSet.Bm7);
        chordList.add(ChordsSet.Cm7);
        chordList.add(ChordsSet.Dm7);
        chordList.add(ChordsSet.Em7);
        chordList.add(ChordsSet.Fm7);
        chordList.add(ChordsSet.Gm7);

        chordList.add(ChordsSet.A9);
        chordList.add(ChordsSet.B9);
        chordList.add(ChordsSet.C9);
        chordList.add(ChordsSet.D9);
        chordList.add(ChordsSet.E9);
        chordList.add(ChordsSet.F9);
        chordList.add(ChordsSet.G9);

        chordList.add(ChordsSet.Am9);
        chordList.add(ChordsSet.Bm9);
        chordList.add(ChordsSet.Cm9);
        chordList.add(ChordsSet.Dm9);
        chordList.add(ChordsSet.Em9);
        chordList.add(ChordsSet.Fm9);
        chordList.add(ChordsSet.Gm9);

        chordList.add(ChordsSet.Adim);
        chordList.add(ChordsSet.Bdim);
        chordList.add(ChordsSet.Cdim);
        chordList.add(ChordsSet.Ddim);
        chordList.add(ChordsSet.Edim);
        chordList.add(ChordsSet.Fdim);
        chordList.add(ChordsSet.Gdim);

        chordList.add(ChordsSet.Asus4);
        chordList.add(ChordsSet.Bsus4);
        chordList.add(ChordsSet.Csus4);
        chordList.add(ChordsSet.Dsus4);
        chordList.add(ChordsSet.Esus4);
        chordList.add(ChordsSet.Fsus4);
        chordList.add(ChordsSet.Gsus4);

        return chordList;
    }

    class Chords extends ArrayAdapter<String> {
        ArrayList<Chord> chordList;
        public Chords(Context context, ArrayList<Chord> chordList) {
            super(context, R.layout.row_chord_info, R.id.chordName, new String[chordList.size()]);
            this.chordList = chordList;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row_chord_info, parent, false);
            row.setEnabled(false);
            createChord(chordList.get(position), row);
            return row;
        }

        private void createChord(Chord currentChord, View row) {
            int fret = currentChord.startLine;
            ((TextView) row.findViewById(R.id.guitarFret)).setText(fret + "");
            for (int i = 0; i < Strings.openCloseStrings.length; i++) {
                switch (currentChord.openStrings[i]) {
                    case -1:
                        ((TextView) row.findViewById(Strings.openCloseStrings[i])).setText("×");
                        break;
                    case 0:
                        ((TextView) row.findViewById(Strings.openCloseStrings[i])).setText("");
                        break;
                    case 1:
                        ((TextView) row.findViewById(Strings.openCloseStrings[i])).setText("○");
                        break;
                }

            }
            for (int i = 0; i < Strings.strings.length; i++) {
                row.findViewById(Strings.barre[i]).setActivated(false);
                for (int j = 0; j < Strings.strings[0].length; j++) {
                    row.findViewById(Strings.strings[i][j]).setActivated(false);
                    row.findViewById(Strings.strings[i][j]).setClickable(false);
                    if (currentChord.strings[i][j] == 1)
                        row.findViewById(Strings.strings[i][j]).setActivated(true);

                    if (currentChord.strings[i][j] == 2) {
                        row.findViewById(Strings.barre[i]).setActivated(true);
                        for (int k = 0; k < Strings.strings[0].length; k++) {
                            row.findViewById(Strings.strings[i][k]).setActivated(false);
                        }
                        break;
                    }
                }
            }

            for (int i = 0; i < Strings.openCloseStrings.length; i++) {
                row.findViewById(Strings.openCloseStrings[i]).setClickable(false);
            }

            ((TextView) row.findViewById(R.id.chordName)).setText(currentChord.chordName);
        }
    }
}