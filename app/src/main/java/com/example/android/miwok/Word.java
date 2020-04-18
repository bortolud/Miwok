package com.example.android.miwok;

public class Word {
    private String defaultWord;
    private String miwokWord;
    private int image;
    private int sound;
    private boolean hasImage;

    public Word(String eng, String miwok, int img, int soundRef) {
        defaultWord = eng;
        miwokWord = miwok;
        image=img;
        hasImage=true;
        sound=soundRef;
    }
    public Word(String eng, String miwok, int soundRef) {
        defaultWord = eng;
        miwokWord = miwok;
        hasImage=false;
        sound=soundRef;
    //    image=img;
    }

    public String getDefaultWord(){
        return defaultWord;
    }

    public String getMiwokWord() {
        return miwokWord;
    }

    public int getImage() {
        return image;
    }

    public boolean getHasImage() {
        return hasImage;
    }

    public int getSound() {return sound;}
}