package com.breaktime.chords;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Objects;

public class ChordsQuiz extends AppCompatActivity {
    private int fret = 1;
    static LayoutInflater inflater;
    Animation animationSettings;
    Dialog settingsPopup, listPopup;
    ArrayList<Chord> chordList;
    int amountOfQuestions = 1;
    int currentQuestion = 0;
    String rightAnswer;
    QuizData data;
    AlertDialog alertAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chords_quiz);
        Objects.requireNonNull(getSupportActionBar()).hide();
        data = new QuizData(getSharedPreferences(QuizData.PREFS_FILE, MODE_PRIVATE));
        if (!data.wasChordsModeOpen())
            firstOpen();

        inflater = getLayoutInflater();
        settingsPopup = new Dialog(this);
        listPopup = new Dialog(this);
        amountOfQuestions = data.getAmount();
        animationSettings = AnimationUtils.loadAnimation(this, R.anim.rotate);
        changeColor();

        findViewById(R.id.settings).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ImageView settings = findViewById(R.id.settings);
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    animationSettings.setRepeatCount(5);
                    settings.startAnimation(animationSettings);
                }

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    animationSettings.setRepeatCount(0);
                    settings.startAnimation(animationSettings);
                }
                return false;
            }
        });
    }

    private void firstOpen() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View mView = getLayoutInflater().inflate(R.layout.first_open_chords_quiz, null);
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

    private void changeColor() {
        Drawable myDrawable = ((ImageView) findViewById(R.id.startChords)).getDrawable();
        myDrawable.mutate().setColorFilter(getResources().getColor(R.color.startChordsTextColor), PorterDuff.Mode.SRC_IN);
        ((ImageView) findViewById(R.id.startChords)).setImageDrawable(myDrawable);
        findViewById(R.id.startChords).setAnimation(AnimationUtils.loadAnimation(this, R.anim.scale));
    }

    public void riseAmount(View view) {
        amountOfQuestions++;
        data.setAmount(amountOfQuestions);
        ((TextView) settingsPopup.findViewById(R.id.amount)).setText(amountOfQuestions + "");
    }

    public void downAmount(View view) {
        if (amountOfQuestions > 1)
            amountOfQuestions--;
        data.setAmount(amountOfQuestions);
        ((TextView) settingsPopup.findViewById(R.id.amount)).setText(amountOfQuestions + "");
    }

    public void openSettings(View view) {
        findViewById(R.id.startWindow).setVisibility(View.VISIBLE);
        settingsPopup.setContentView(R.layout.popup_settings_chords_quiz);
        ((TextView) settingsPopup.findViewById(R.id.amount)).setText(amountOfQuestions + "");
        settingsPopup.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settingsPopup.dismiss();
            }
        });

        settingsPopup.findViewById(R.id.chord_M).setActivated(data.getActivated(R.id.chord_M));
        settingsPopup.findViewById(R.id.chord_Sharp).setActivated(data.getActivated(R.id.chord_Sharp));
        settingsPopup.findViewById(R.id.chord_Sharp_m).setActivated(data.getActivated(R.id.chord_Sharp_m));
        settingsPopup.findViewById(R.id.chord_m).setActivated(data.getActivated(R.id.chord_m));
        settingsPopup.findViewById(R.id.chord_7).setActivated(data.getActivated(R.id.chord_7));
        settingsPopup.findViewById(R.id.chord_m7).setActivated(data.getActivated(R.id.chord_m7));
        settingsPopup.findViewById(R.id.chord_9).setActivated(data.getActivated(R.id.chord_9));
        settingsPopup.findViewById(R.id.chord_m9).setActivated(data.getActivated(R.id.chord_m9));
        settingsPopup.findViewById(R.id.chord_dim).setActivated(data.getActivated(R.id.chord_dim));
        settingsPopup.findViewById(R.id.chord_sus4).setActivated(data.getActivated(R.id.chord_sus4));

        settingsPopup.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        settingsPopup.setCancelable(false);
        settingsPopup.show();
    }

    public void setActivatedSettings(View view) {
        int id;
        try {
            id = view.getId();
            ((LinearLayout) view).setActivated(!view.isActivated());
        } catch (ClassCastException e) {
            LinearLayout layout = (LinearLayout) view.getParent();
            id = layout.getId();
            layout.setActivated(!layout.isActivated());
        }
        switch (id) {
            case R.id.chord_M:
                data.setActivated(R.id.chord_M);
                break;
            case R.id.chord_Sharp:
                data.setActivated(R.id.chord_Sharp);
                break;
            case R.id.chord_Sharp_m:
                data.setActivated(R.id.chord_Sharp_m);
                break;
            case R.id.chord_m:
                data.setActivated(R.id.chord_m);
                break;
            case R.id.chord_7:
                data.setActivated(R.id.chord_7);
                break;
            case R.id.chord_m7:
                data.setActivated(R.id.chord_m7);
                break;
            case R.id.chord_9:
                data.setActivated(R.id.chord_9);
                break;
            case R.id.chord_m9:
                data.setActivated(R.id.chord_m9);
                break;
            case R.id.chord_dim:
                data.setActivated(R.id.chord_dim);
                break;
            case R.id.chord_sus4:
                data.setActivated(R.id.chord_sus4);
                break;
        }
    }

    private void getChordsList() {
        chordList = new ArrayList<>();
        if (data.getActivated(R.id.chord_M)) {
            chordList.add(ChordsSet.A);
            chordList.add(ChordsSet.B);
            chordList.add(ChordsSet.C);
            chordList.add(ChordsSet.D);
            chordList.add(ChordsSet.E);
            chordList.add(ChordsSet.F);
            chordList.add(ChordsSet.G);
        }

        if (data.getActivated(R.id.chord_Sharp)) {
            chordList.add(ChordsSet.A_Sharp);
            chordList.add(ChordsSet.B_Sharp);
            chordList.add(ChordsSet.C_Sharp);
            chordList.add(ChordsSet.D_Sharp);
            chordList.add(ChordsSet.E_Sharp);
            chordList.add(ChordsSet.F_Sharp);
            chordList.add(ChordsSet.G_Sharp);
        }

        if (data.getActivated(R.id.chord_Sharp_m)) {
            chordList.add(ChordsSet.A_Sharp_m);
//            chordList.add(ChordsSet.B_Sharp_m);
            chordList.add(ChordsSet.C_Sharp_m);
            chordList.add(ChordsSet.D_Sharp_m);
//            chordList.add(ChordsSet.E_Sharp_m);
            chordList.add(ChordsSet.F_Sharp_m);
            chordList.add(ChordsSet.G_Sharp_m);
        }

        if (data.getActivated(R.id.chord_m)) {
            chordList.add(ChordsSet.Am);
            chordList.add(ChordsSet.Bm);
            chordList.add(ChordsSet.Cm);
            chordList.add(ChordsSet.Dm);
            chordList.add(ChordsSet.Em);
            chordList.add(ChordsSet.Fm);
            chordList.add(ChordsSet.Gm);
        }

        if (data.getActivated(R.id.chord_7)) {
            chordList.add(ChordsSet.A7);
            chordList.add(ChordsSet.B7);
            chordList.add(ChordsSet.C7);
            chordList.add(ChordsSet.D7);
            chordList.add(ChordsSet.E7);
            chordList.add(ChordsSet.F7);
            chordList.add(ChordsSet.G7);
        }

        if (data.getActivated(R.id.chord_m7)) {
            chordList.add(ChordsSet.Am7);
            chordList.add(ChordsSet.Bm7);
            chordList.add(ChordsSet.Cm7);
            chordList.add(ChordsSet.Dm7);
            chordList.add(ChordsSet.Em7);
            chordList.add(ChordsSet.Fm7);
            chordList.add(ChordsSet.Gm7);
        }

        if (data.getActivated(R.id.chord_9)) {
            chordList.add(ChordsSet.A9);
            chordList.add(ChordsSet.B9);
            chordList.add(ChordsSet.C9);
            chordList.add(ChordsSet.D9);
            chordList.add(ChordsSet.E9);
            chordList.add(ChordsSet.F9);
            chordList.add(ChordsSet.G9);
        }

        if (data.getActivated(R.id.chord_m9)) {
            chordList.add(ChordsSet.Am9);
            chordList.add(ChordsSet.Bm9);
            chordList.add(ChordsSet.Cm9);
            chordList.add(ChordsSet.Dm9);
            chordList.add(ChordsSet.Em9);
            chordList.add(ChordsSet.Fm9);
            chordList.add(ChordsSet.Gm9);
        }

        if (data.getActivated(R.id.chord_dim)) {
            chordList.add(ChordsSet.Adim);
            chordList.add(ChordsSet.Bdim);
            chordList.add(ChordsSet.Cdim);
            chordList.add(ChordsSet.Ddim);
            chordList.add(ChordsSet.Edim);
            chordList.add(ChordsSet.Fdim);
            chordList.add(ChordsSet.Gdim);
        }

        if (data.getActivated(R.id.chord_sus4)) {
            chordList.add(ChordsSet.Asus4);
            chordList.add(ChordsSet.Bsus4);
            chordList.add(ChordsSet.Csus4);
            chordList.add(ChordsSet.Dsus4);
            chordList.add(ChordsSet.Esus4);
            chordList.add(ChordsSet.Fsus4);
            chordList.add(ChordsSet.Gsus4);
        }
        shuffleChords();
    }

    private void shuffleChords() {
        ArrayList<Chord> shuffledList = new ArrayList<>();
        while (chordList.size() != 0) {
            int position = (int) (Math.random() * chordList.size());
            shuffledList.add(chordList.get(position));
            chordList.remove(position);
        }
        chordList = shuffledList;
    }

    private void readChord(Chord currentChord) {
        fret = currentChord.startLine;
        ((TextView) findViewById(R.id.guitarFret)).setText(fret + "");
        for (int i = 0; i < Strings.openCloseStrings.length; i++) {
            switch (currentChord.openStrings[i]) {
                case -1:
                    ((TextView) findViewById(Strings.openCloseStrings[i])).setText("×");
                    break;
                case 0:
                    ((TextView) findViewById(Strings.openCloseStrings[i])).setText("");
                    break;
                case 1:
                    ((TextView) findViewById(Strings.openCloseStrings[i])).setText("○");
                    break;
            }

        }
        for (int i = 0; i < Strings.strings.length; i++) {
            findViewById(Strings.barre[i]).setActivated(false);
            for (int j = 0; j < Strings.strings[0].length; j++) {
                findViewById(Strings.strings[i][j]).setActivated(false);
                findViewById(Strings.strings[i][j]).setClickable(false);
                if (currentChord.strings[i][j] == 1)
                    findViewById(Strings.strings[i][j]).setActivated(true);

                if (currentChord.strings[i][j] == 2) {
                    findViewById(Strings.barre[i]).setActivated(true);
                    for (int k = 0; k < Strings.strings[0].length; k++) {
                        findViewById(Strings.strings[i][k]).setActivated(false);
                    }
                    break;
                }
            }
        }

        for (int i = 0; i < Strings.openCloseStrings.length; i++) {
            findViewById(Strings.openCloseStrings[i]).setClickable(false);
        }
    }

    public void start(View view) {
        findViewById(R.id.startWindow).setVisibility(View.GONE);
        getChordsList();
        currentQuestion = 0;
        createQuestion();
    }

    public void enterAnswer(View view) {
        if (chordList == null || rightAnswer == null)
            return;
        MediaPlayer mp;
        if (((TextView) view).getText().toString().equals(rightAnswer)) {
            mp = MediaPlayer.create(this, R.raw.correct_answer);
            Toast.makeText(getApplicationContext(), getString(R.string.right_answer_quiz), Toast.LENGTH_SHORT).show();
        } else {
            mp = MediaPlayer.create(this, R.raw.error_answer);
            Toast.makeText(getApplicationContext(), getString(R.string.wrong_answer_quiz) + "  " + rightAnswer, Toast.LENGTH_SHORT).show();
        }
        if (mp != null)
            mp.start();
        currentQuestion++;
        if (currentQuestion == amountOfQuestions || currentQuestion == chordList.size()) {
            findViewById(R.id.startWindow).setVisibility(View.VISIBLE);
            return;
        }
        createQuestion();
    }

    private void createQuestion() {
        int currentChord = (int) (Math.random() * chordList.size());
        readChord(chordList.get(currentChord));
        rightAnswer = chordList.get(currentChord).chordName;
        chordList.remove(currentChord);

        String[] answers = new String[4];
        for (int i = 0; i < answers.length; i++) {
            String answer = ChordsSet.chordNames[(int) (Math.random() * ChordsSet.chordNames.length)];
            if (answer.equals(rightAnswer))
                answer = ChordsSet.chordNames[(int) (Math.random() * ChordsSet.chordNames.length)];
            answers[i] = answer;
        }
        answers[(int) (Math.random() * answers.length)] = rightAnswer;
        ((TextView) findViewById(R.id.button1)).setText(answers[0]);
        ((TextView) findViewById(R.id.button2)).setText(answers[1]);
        ((TextView) findViewById(R.id.button3)).setText(answers[2]);
        ((TextView) findViewById(R.id.button4)).setText(answers[3]);
    }

    public void openChordList(View view) {
        findViewById(R.id.startWindow).setVisibility(View.VISIBLE);

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
        Chords vacancies = new Chords(this, getChordsListForInfo());
        chordsView.setAdapter(vacancies);
    }

    private ArrayList<Chord> getChordsListForInfo() {
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
