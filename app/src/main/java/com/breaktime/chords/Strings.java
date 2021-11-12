package com.breaktime.chords;

import android.widget.TextView;

class Strings extends SearchChord {

    public static int[] barre = new int[5];
    public static int[][] strings = new int[5][6];
    public static int[] openCloseStrings = new int[6];
    static  {
        barre[0] = R.id.line1;
        barre[1] = R.id.line2;
        barre[2] = R.id.line3;
        barre[3] = R.id.line4;
        barre[4] = R.id.line5;

        strings[0][0] = R.id.line1_sting1;
        strings[0][1] = R.id.line1_sting2;
        strings[0][2] = R.id.line1_sting3;
        strings[0][3] = R.id.line1_sting4;
        strings[0][4] = R.id.line1_sting5;
        strings[0][5] = R.id.line1_sting6;

        strings[1][0] = R.id.line2_sting1;
        strings[1][1] = R.id.line2_sting2;
        strings[1][2] = R.id.line2_sting3;
        strings[1][3] = R.id.line2_sting4;
        strings[1][4] = R.id.line2_sting5;
        strings[1][5] = R.id.line2_sting6;

        strings[2][0] = R.id.line3_sting1;
        strings[2][1] = R.id.line3_sting2;
        strings[2][2] = R.id.line3_sting3;
        strings[2][3] = R.id.line3_sting4;
        strings[2][4] = R.id.line3_sting5;
        strings[2][5] = R.id.line3_sting6;

        strings[3][0] = R.id.line4_sting1;
        strings[3][1] = R.id.line4_sting2;
        strings[3][2] = R.id.line4_sting3;
        strings[3][3] = R.id.line4_sting4;
        strings[3][4] = R.id.line4_sting5;
        strings[3][5] = R.id.line4_sting6;

        strings[4][0] = R.id.line5_sting1;
        strings[4][1] = R.id.line5_sting2;
        strings[4][2] = R.id.line5_sting3;
        strings[4][3] = R.id.line5_sting4;
        strings[4][4] = R.id.line5_sting5;
        strings[4][5] = R.id.line5_sting6;

        openCloseStrings[0] = R.id.openString_1;
        openCloseStrings[1] = R.id.openString_2;
        openCloseStrings[2] = R.id.openString_3;
        openCloseStrings[3] = R.id.openString_4;
        openCloseStrings[4] = R.id.openString_5;
        openCloseStrings[5] = R.id.openString_6;
    }

    public static int searchStingPosition(TextView currentView){
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[0].length; j++) {
                if (strings[i][j] == currentView.getId())
                    return j;
            }
        }
        return  -1;
    }

    public static int searchOpenStingPosition(TextView currentView){
        for (int i = 0; i < openCloseStrings.length; i++) {
                if (openCloseStrings[i] == currentView.getId())
                    return i;
        }
        return  -1;
    }

    public static int searchLinePosition(TextView currentView){
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[0].length; j++) {
                if (strings[i][j] == currentView.getId())
                    return i;
            }
        }
        return  -1;
    }

}
