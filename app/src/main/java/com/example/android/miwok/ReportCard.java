package com.example.android.miwok;

public class ReportCard {
    private float math;
    private float english;
    private float science;

    public ReportCard(){
        //initialize
        math=0;
        english=0;
        science=0;
    }

    public void setEnglish(float grade) {
        english = grade;
    }

    public void setMath(float grade) {
        math = grade;
    }

    public void setScience(float grade) {
        science = grade;
    }

    public float getEnglish() {
        return english;
    }

    public float getMath() {
        return math;
    }

    public float getScience() {
        return science;
    }

    @Override
    public String toString(){
        String toReturn = "english = " + english + "\nmath = " + math + "\nscience = " + science;
        return toReturn;
    }
}
