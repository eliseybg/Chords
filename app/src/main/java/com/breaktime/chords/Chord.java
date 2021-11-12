package com.breaktime.chords;

class Chord {
    String chordName;
    int startLine;
    int[][] strings;
    int[] openStrings;

    Chord(String chordName, int startLine, int[][] strings, int[] openStrings) {
        this.chordName = chordName;
        this.startLine = startLine;
        this.strings = strings;
        this.openStrings = openStrings;
    }

    public boolean compare(Chord chord) {
        if (startLine != chord.startLine)
            return false;
        for (int i = 0; i < openStrings.length; i++)
            if (openStrings[i] != chord.openStrings[i])
                return false;

        for (int i = 0; i < strings.length; i++)
            for (int j = 0; j < strings[0].length; j++)
                if (strings[i][j] != chord.strings[i][j])
                    return false;


        return true;
    }
}
