package com.breaktime.chords;

class ChordsSet {
    //    openC - в самом верху аккордов, открыта или закрыта струна
//    -1 - струна не играется, крестик сверху
//    0 - зажат какой-то лад снизу, ничего сверху не стоит
//    1 - струна играется открытой, сверху 0
    private static int[] openC =
            {1, 0, 0, 1, 0, 1};
    //    C_Strings - какие лады зажаты
//    0 - струна не зажата
//    1 - струна зажата на данном ладу
    private static int[][] C_Strings = {
            {0, 0, 0, 0, 1, 0}, // 1 линия
            {0, 0, 1, 0, 0, 0}, // 2 линия
            {0, 1, 0, 0, 0, 0}, // 3 линия
            {0, 0, 0, 0, 0, 0}, // 4 линия
            {0, 0, 0, 0, 0, 0}}; // 5 линия
    //    C - имя самого аккорда
//    1 - номер лада для первой линии
//    C_Strings - зажатые струны на ладах
//    openC - открытые и закрытые струны
    public static Chord C = new Chord("C", 1, C_Strings, openC);

    private static int[] openCm =
            {0, 0, 0, 0, 0, 0};
    private static int[][] Cm_Strings = {
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {2, 2, 2, 2, 2, 2},
            {0, 0, 0, 0, 1, 0},
            {0, 0, 1, 1, 0, 0}};
    public static Chord Cm = new Chord("Cm", 1, Cm_Strings, openCm);

    private static int[] openC7 =
            {1, 0, 0, 0, 0, 1};
    private static int[][] C7_Strings = {
            {0, 0, 0, 0, 1, 0},
            {0, 0, 1, 0, 0, 0},
            {0, 1, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord C7 = new Chord("C7", 1, C7_Strings, openC7);

    private static int[] openC_Sharp =
            {-1, 0, 0, 0, 0, 0};
    private static int[][] C_Sharp_Strings = {
            {0, 0, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0},
            {0, 0, 1, 0, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord C_Sharp = new Chord("C#", 1, C_Sharp_Strings, openC_Sharp);

    private static int[] openC_Sharp_m =
            {-1, 0, 0, 0, 0, -1};
    private static int[][] C_Sharp_m_Strings = {
            {0, 0, 0, 1, 0, 0},
            {0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord C_Sharp_m = new Chord("C#m", 1, C_Sharp_m_Strings, openC_Sharp_m);

    private static int[] openCm7 =
            {-1, -1, 0, 0, 0, 0};
    private static int[][] Cm7_Strings = {
            {0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 1},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord Cm7 = new Chord("Cm7", 1, Cm7_Strings, openCm7);

    private static int[] openC9 =
            {-1, 0, 0, 0, 0, -1};
    private static int[][] C9_Strings = {
            {0, 0, 1, 0, 0, 0},
            {0, 1, 0, 1, 1, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord C9 = new Chord("C9", 1, C9_Strings, openC9);

    private static int[] openCm9 =
            {-1, 0, 0, 0, 0, 0};
    private static int[][] Cm9_Strings = {
            {0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 1, 0, 1, 1, 1},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord Cm9 = new Chord("Cm9", 1, Cm9_Strings, openCm9);

    private static int[] openCdim =
            {-1, 0, 0, 0, 0, -1};
    private static int[][] Cdim_Strings = {
            {0, 0, 0, 0, 1, 0},
            {0, 0, 0, 1, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord Cdim = new Chord("Cdim", 1, Cdim_Strings, openCdim);

    private static int[] openCsus4 =
            {-1, 0, 0, 0, 0, 0};
    private static int[][] Csus4_Strings = {
            {0, 1, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 1, 1, 0, 0},
            {0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord Csus4 = new Chord("Csus4", 1, Csus4_Strings, openCsus4);

    private static int[] openD =
            {-1, 1, 1, 0, 0, 0};
    private static int[][] D_Strings = {
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord D = new Chord("D", 1, D_Strings, openD);

    private static int[] openDm =
            {-1, 1, 1, 0, 0, 0};
    private static int[][] Dm_Strings = {
            {0, 0, 0, 0, 0, 1},
            {0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord Dm = new Chord("Dm", 1, Dm_Strings, openDm);

    private static int[] openD7 =
            {-1, 1, 1, 0, 0, 0};
    private static int[][] D7_Strings = {
            {0, 0, 0, 0, 1, 0},
            {0, 0, 0, 1, 0, 1},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord D7 = new Chord("D7", 1, D7_Strings, openD7);

    private static int[] openD_Sharp =
            {-1, 0, 0, 0, 0, 0};
    private static int[][] D_Sharp_Strings = {
            {0, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord D_Sharp = new Chord("D#", 1, D_Sharp_Strings, openD_Sharp);

    private static int[] openD_Sharp_m =
            {-1, 0, 0, 0, 0, 0};
    private static int[][] D_Sharp_m_Strings = {
            {0, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 1},
            {0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord D_Sharp_m = new Chord("D#m", 1, D_Sharp_m_Strings, openD_Sharp_m);

    private static int[] openDm7 =
            {-1, -1, 1, 0, 0, 0};
    private static int[][] Dm7_Strings = {
            {0, 0, 0, 0, 1, 1},
            {0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord Dm7 = new Chord("Dm7", 1, Dm7_Strings, openDm7);

    private static int[] openD9 =
            {0, -1, 1, 0, 0, 1};
    private static int[][] D9_Strings = {
            {0, 0, 0, 0, 1, 0},
            {1, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord D9 = new Chord("D9", 1, D9_Strings, openD9);

    private static int[] openDm9 =
            {-1, -1, 0, 0, 0, 1};
    private static int[][] Dm9_Strings = {
            {0, 0, 0, 0, 1, 0},
            {0, 0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord Dm9 = new Chord("Dm9", 1, Dm9_Strings, openDm9);

    private static int[] openDdim =
            {-1, -1, 1, 0, 1, 0};
    private static int[][] Ddim_Strings = {
            {0, 0, 0, 1, 0, 1},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord Ddim = new Chord("Ddim", 1, Ddim_Strings, openDdim);

    private static int[] openDsus4 =
            {-1, -1, 1, 0, 0, 0};
    private static int[][] Dsus4_Strings = {
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 1},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord Dsus4 = new Chord("Dsus4", 1, Dsus4_Strings, openDsus4);

    private static int[] openE =
            {1, 0, 0, 0, 1, 1};
    private static int[][] E_Strings = {
            {0, 0, 0, 1, 0, 0},
            {0, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord E = new Chord("E", 1, E_Strings, openE);

    private static int[] openEm =
            {1, 0, 0, 1, 1, 1};
    private static int[][] Em_Strings = {
            {0, 0, 0, 0, 0, 0},
            {0, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord Em = new Chord("Em", 1, Em_Strings, openEm);

    private static int[] openE7 =
            {1, 0, 0, 0, 0, 1};
    private static int[][] E7_Strings = {
            {0, 0, 0, 1, 0, 0},
            {0, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord E7 = new Chord("E7", 1, E7_Strings, openE7);

    private static int[] openE_Sharp =
            {0, 1, 0, 0, 0, -1};
    private static int[][] E_Sharp_Strings = {
            {1, 0, 0, 0, 1, 0},
            {0, 0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord E_Sharp = new Chord("E#", 1, E_Sharp_Strings, openE_Sharp);

//
//
//
//
    private static int[] openE_Sharp_m =
            {0, 0, 0, 0, 0, 0};
    private static int[][] E_Sharp_m_Strings = {
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
//    public static Chord E_Sharp_m = new Chord("E#m", 1, E_Sharp_m_Strings, openE_Sharp_m);

    private static int[] openEm7 =
            {1, 0, 0, 1, 0, 1};
    private static int[][] Em7_Strings = {
            {0, 0, 0, 0, 0, 0},
            {0, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord Em7 = new Chord("Em7", 1, Em7_Strings, openEm7);

    private static int[] openE9 =
            {1, 0, 1, 0, 1, 0};
    private static int[][] E9_Strings = {
            {0, 0, 0, 1, 0, 0},
            {0, 1, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord E9 = new Chord("E9", 1, E9_Strings, openE9);

    private static int[] openEm9 =
            {1, 0, 1, 1, 1, 0};
    private static int[][] Em9_Strings = {
            {0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord Em9 = new Chord("Em9", 1, Em9_Strings, openEm9);

    private static int[] openEdim =
            {-1, 0, 0, 0, 0, -1};
    private static int[][] Edim_Strings = {
            {0, 1, 0, 0, 0, 0},
            {0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord Edim = new Chord("Edim", 1, Edim_Strings, openEdim);

    private static int[] openEsus4 =
            {1, 0, 0, 0, 1, 1};
    private static int[][] Esus4_Strings = {
            {0, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord Esus4 = new Chord("Esus4", 1, Esus4_Strings, openEsus4);

    private static int[] openF =
            {0, 0, 0, 0, 0, 0};
    private static int[][] F_Strings = {
            {2, 2, 2, 2, 2, 2},
            {0, 0, 0, 1, 0, 0},
            {0, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord F = new Chord("F", 1, F_Strings, openF);

    private static int[] openFm =
            {0, 0, 0, 0, 0, 0};
    private static int[][] Fm_Strings = {
            {2, 2, 2, 2, 2, 2},
            {0, 0, 0, 0, 0, 0},
            {0, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord Fm = new Chord("Fm", 1, Fm_Strings, openFm);

    private static int[] openF7 =
            {0, 0, 0, 0, 0, 0};
    private static int[][] F7_Strings = {
            {2, 2, 2, 2, 2, 2},
            {0, 0, 0, 1, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord F7 = new Chord("F7", 1, F7_Strings, openF7);

    private static int[] openF_Sharp =
            {0, 0, 0, 0, 0, 0};
    private static int[][] F_Sharp_Strings = {
            {2, 2, 2, 2, 2, 2},
            {0, 0, 0, 1, 0, 0},
            {0, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord F_Sharp = new Chord("F#", 2, F_Sharp_Strings, openF_Sharp);

    private static int[] openF_Sharp_m =
            {0, 0, 0, 0, 0, 0};
    private static int[][] F_Sharp_m_Strings = {
            {2, 2, 2, 2, 2, 2},
            {0, 0, 0, 0, 0, 0},
            {0, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord F_Sharp_m = new Chord("F#m", 2, F_Sharp_m_Strings, openF_Sharp_m);

    private static int[] openFm7 =
            {0, 0, 0, 0, 0, 0};
    private static int[][] Fm7_Strings = {
            {2, 2, 2, 2, 2, 2},
            {0, 0, 0, 0, 0, 0},
            {0, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord Fm7 = new Chord("Fm7", 1, Fm7_Strings, openFm7);

    private static int[] openF9 =
            {0, 0, 0, 0, 0, 0};
    private static int[][] F9_Strings = {
            {2, 2, 2, 2, 2, 2},
            {0, 0, 0, 1, 0, 0},
            {0, 1, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord F9 = new Chord("F9", 1, F9_Strings, openF9);

    private static int[] openFm9 =
            {0, 0, 0, 0, 0, 0};
    private static int[][] Fm9_Strings = {
            {2, 2, 2, 2, 2, 2},
            {0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord Fm9 = new Chord("Fm9", 1, Fm9_Strings, openFm9);

    private static int[] openFdim =
            {-1, 0, 0, 0, 0, -1};
    private static int[][] Fdim_Strings = {
            {0, 1, 0, 0, 0, 0},
            {0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord Fdim = new Chord("Fdim", 2, Fdim_Strings, openFdim);

    private static int[] openFsus4 =
            {0, 0, 0, 0, 0, 0};
    private static int[][] Fsus4_Strings = {
            {2, 2, 2, 2, 2, 2},
            {0, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord Fsus4 = new Chord("Fsus4", 1, Fsus4_Strings, openFsus4);

    private static int[] openG =
            {0, 0, 1, 1, 1, 0};
    private static int[][] G_Strings = {
            {0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord G = new Chord("G", 1, G_Strings, openG);

    private static int[] openGm =
            {0, 0, 0, 0, 0, 0};
    private static int[][] Gm_Strings = {
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {2, 2, 2, 2, 2, 2},
            {0, 0, 0, 0, 0, 0},
            {0, 1, 1, 0, 0, 0}};
    public static Chord Gm = new Chord("Gm", 1, Gm_Strings, openGm);

    private static int[] openG7 =
            {0, 0, 1, 1, 1, 0};
    private static int[][] G7_Strings = {
            {0, 0, 0, 0, 0, 1},
            {0, 1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord G7 = new Chord("G7", 1, G7_Strings, openG7);

    private static int[] openG_Sharp =
            {0, 0, 0, 0, 0, 0};
    private static int[][] G_Sharp_Strings = {
            {2, 2, 2, 2, 2, 2},
            {0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0}};
    public static Chord G_Sharp = new Chord("G#", 1, G_Sharp_Strings, openG_Sharp);

    private static int[] openG_Sharp_m =
            {0, 0, 0, 0, 0, 0};
    private static int[][] G_Sharp_m_Strings = {
            {2, 2, 2, 2, 2, 2},
            {0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 1, 1},
            {0, 0, 0, 0, 0, 0}};
    public static Chord G_Sharp_m = new Chord("G#m", 1, G_Sharp_m_Strings, openG_Sharp_m);

    private static int[] openGm7 =
            {-1, 0, 0, 1, 0, -1};
    private static int[][] Gm7_Strings = {
            {0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord Gm7 = new Chord("Gm7", 1, Gm7_Strings, openGm7);

    private static int[] openG9 =
            {0, -1, 1, 0, 1, 0};
    private static int[][] G9_Strings = {
            {0, 0, 0, 0, 0, 1},
            {0, 0, 0, 1, 0, 0},
            {1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord G9 = new Chord("G9", 1, G9_Strings, openG9);

    private static int[] openGm9 =
            {0, 0, 0, 0, 0, 0};
    private static int[][] Gm9_Strings = {
            {2, 2, 2, 2, 2, 2},
            {0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord Gm9 = new Chord("Gm9", 1, Gm9_Strings, openGm9);

    private static int[] openGdim =
            {-1, -1, 0, 0, 0, 0};
    private static int[][] Gdim_Strings = {
            {0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord Gdim = new Chord("Gdim", 1, Gdim_Strings, openGdim);

    private static int[] openGsus4 =
            {0, 0, 0, 0, 0, 0};
    private static int[][] Gsus4_Strings = {
            {2, 2, 2, 2, 2, 2},
            {0, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord Gsus4 = new Chord("Gsus4", 1, Gsus4_Strings, openGsus4);

    private static int[] openA =
            {1, 1, 0, 0, 0, 1};
    private static int[][] A_Strings = {
            {0, 0, 0, 0, 0, 0},
            {0, 0, 1, 1, 1, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord A = new Chord("A", 1, A_Strings, openA);

    private static int[] openAm =
            {1, 1, 0, 0, 0, 1};
    private static int[][] Am_Strings = {
            {0, 0, 0, 0, 1, 0},
            {0, 0, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord Am = new Chord("Am", 1, Am_Strings, openAm);

    private static int[] openA7 =
            {1, 1, 0, 1, 0, 1};
    private static int[][] A7_Strings = {
            {0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord A7 = new Chord("A7", 1, A7_Strings, openA7);

    private static int[] openA_Sharp =
            {-1, 0, 0, 0, 0, 0};
    private static int[][] A_Sharp_Strings = {
            {2, 2, 2, 2, 2, 2},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 1, 1, 1, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord A_Sharp = new Chord("A#", 1, A_Sharp_Strings, openA_Sharp);

    private static int[] openA_Sharp_m =
            {-1, 0, 0, 0, 0, 0};
    private static int[][] A_Sharp_m_Strings = {
            {2, 2, 2, 2, 2, 2},
            {0, 0, 0, 0, 1, 0},
            {0, 0, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord A_Sharp_m = new Chord("A#m", 1, A_Sharp_m_Strings, openA_Sharp_m);

    private static int[] openAm7 =
            {-1, 1, 0, 1, 0, 1};
    private static int[][] Am7_Strings = {
            {0, 0, 0, 0, 1, 0},
            {0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord Am7 = new Chord("Am7", 1, Am7_Strings, openAm7);

    private static int[] openA9 =
            {-1, 1, 0, 0, 0, 0};
    private static int[][] A9_Strings = {
            {0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1},
            {0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord A9 = new Chord("A9", 1, A9_Strings, openA9);

    private static int[] openAm9 =
            {-1, 1, 0, 0, 0, 0};
    private static int[][] Am9_Strings = {
            {0, 0, 1, 1, 1, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord Am9 = new Chord("Am9", 1, Am9_Strings, openAm9);

    private static int[] openAdim =
            {-1, 1, 0, 0, 0, -1};
    private static int[][] Adim_Strings = {
            {0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord Adim = new Chord("Adim", 1, Adim_Strings, openAdim);

    private static int[] openAsus4 =
            {-1, 1, 0, 0, 0, 1};
    private static int[][] Asus4_Strings = {
            {0, 0, 0, 0, 0, 0},
            {0, 0, 1, 1, 0, 0},
            {0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord Asus4 = new Chord("Asus4", 1, Asus4_Strings, openAsus4);


    private static int[] openB =
            {0, 0, 0, 0, 0, 0};
    private static int[][] B_Strings = {
            {0, 0, 0, 0, 0, 0},
            {2, 2, 2, 2, 2, 2},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 1, 1, 1, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord B = new Chord("B", 1, B_Strings, openB);

    private static int[] openBm =
            {0, 0, 0, 0, 0, 0};
    private static int[][] Bm_Strings = {
            {0, 0, 0, 0, 0, 0},
            {2, 2, 2, 2, 2, 2},
            {0, 0, 0, 0, 1, 0},
            {0, 0, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord Bm = new Chord("Bm", 1, Bm_Strings, openBm);

    private static int[] openB7 =
            {-1, 0, 0, 0, 1, 0};
    private static int[][] B7_Strings = {
            {0, 0, 1, 0, 0, 0},
            {0, 1, 0, 1, 0, 1},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord B7 = new Chord("B7", 1, B7_Strings, openB7);

    private static int[] openB_Sharp =
            {-1, 0, 0, 1, 0, 1};
    private static int[][] B_Sharp_Strings = {
            {0, 0, 0, 0, 1, 0},
            {0, 0, 1, 0, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord B_Sharp = new Chord("B#", 1, B_Sharp_Strings, openB_Sharp);

//
//
//
    private static int[] openB_Sharp_m =
            {0, 0, 0, 0, 0, 0};
    private static int[][] B_Sharp_m_Strings = {
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
//    public static Chord B_Sharp_m = new Chord("B#m", 1, B_Sharp_m_Strings, openB_Sharp_m);

    private static int[] openBm7 =
            {-1, 0, 0, 0, 0, 0};
    private static int[][] Bm7_Strings = {
            {2, 2, 2, 2, 2, 2},
            {0, 0, 0, 0, 1, 0},
            {0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord Bm7 = new Chord("Bm7", 2, Bm7_Strings, openBm7);

    private static int[] openB9 =
            {-1, 0, 0, 0, 0, 0};
    private static int[][] B9_Strings = {
            {0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 1, 0}, /////////
            {0, 0, 0, 0, 0, 1},
            {0, 0, 0, 1, 0, 0}};
    public static Chord B9 = new Chord("B9", 2, B9_Strings, openB9);

    private static int[] openBm9 =
            {-1, 0, 0, 0, 0, 0};
    private static int[][] Bm9_Strings = {
            {0, 1, 0, 0, 0, 0},
            {0, 0, 1, 1, 1, 0},//////////////
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0}};
    public static Chord Bm9 = new Chord("Bm9", 2, Bm9_Strings, openBm9);

    private static int[] openBdim =
            {-1, 0, 0, 0, 0, -1};
    private static int[][] Bdim_Strings = {
            {0, 1, 0, 0, 0, 0},
            {0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord Bdim = new Chord("Bdim", 2, Bdim_Strings, openBdim);

    private static int[] openBsus4 =
            {-1, 0, 0, 0, 0, 0};
    private static int[][] Bsus4_Strings = {
            {0, 1, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 1, 1, 0, 0},
            {0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord Bsus4 = new Chord("Bsus4", 2, Bsus4_Strings, openBsus4);






    private static int[] openCdm =
            {0, 0, 0, 0, 0, 0};
    private static int[][] Cdm_Strings = {
            {2, 2, 2, 2, 2, 2},
            {0, 0, 0, 0, 1, 0},
            {0, 0, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord Cdm = new Chord("Cdm", 4, Cdm_Strings, openCdm);

    private static int[] openFdm =
            {0, 0, 0, 0, 0, 0};
    private static int[][] Fdm_Strings = {
            {0, 0, 0, 0, 0, 0},
            {2, 2, 2, 2, 2, 2},
            {0, 0, 0, 0, 0, 0},
            {0, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord Fdm = new Chord("Fdm", 1, Fdm_Strings, openFdm);

    private static int[] openGdm =
            {0, 0, 0, 0, 0, 0};
    private static int[][] Gdm_Strings = {
            {2, 2, 2, 2, 2, 2},
            {0, 0, 0, 0, 0, 0},
            {0, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
    public static Chord Gdm = new Chord("Gdm", 4, Gdm_Strings, openGdm);

//    int[][] C = {
//            {0, 0, 0, 0, 0, 0},
//            {0, 0, 0, 0, 0, 0},
//            {0, 0, 0, 0, 0, 0},
//            {0, 0, 0, 0, 0, 0},
//            {0, 0, 0, 0, 0, 0}};



//    private static int[] openC7 =
//            {0, 0, 0, 0, 0, 0};
//    private static int[][] C7_Strings = {
//            {0, 0, 0, 0, 0, 0},
//            {0, 0, 0, 0, 0, 0},
//            {0, 0, 0, 0, 0, 0},
//            {0, 0, 0, 0, 0, 0},
//            {0, 0, 0, 0, 0, 0}};
//    public static Chord C7 = new Chord("C7", 1, C7_Strings, openC7);

    public static String[] chordNames = {
            "C", "D", "E", "F", "G", "A", "B",
            "C#", "D#", "E#", "F#", "G#", "A#", "B#",
            "Cm", "Dm", "Em", "Fm", "Gm", "Am", "Bm",
            "C#m", "D#m", "E#m", "F#m", "G#m", "A#m", "B#m",
            "C7", "D7", "E7", "F7", "G7", "A7", "B7",
            "Cm7", "Dm7", "Em7", "Fm7", "Gm7", "Am7", "Bm7",
            "C9", "D9", "E9", "F9", "G9", "A9", "B9",
            "Cm9", "Dm9", "Em9", "Fm9", "Gm9", "Am9", "Bm9",
            "Cdim", "Ddim", "Edim", "Fdim", "Gdim", "Adim", "Bdim",
            "Csus4", "Dsus4", "Esus4", "Fsus4", "Gsus4", "Asus4", "Bsus4",
    };

}
