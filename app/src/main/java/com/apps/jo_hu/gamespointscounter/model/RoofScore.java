package com.apps.jo_hu.gamespointscounter.model;

public class RoofScore {
    private final Boolean wholeRoof;
    private final Boolean oneColour;
    private final int windows;

    public int getRoofScore() {

        return CalculateResult();
    }

    private int roofScore;


    public RoofScore(Boolean wholeRoof, Boolean oneColour, int windows) {
        this.wholeRoof = wholeRoof;
        this.oneColour = oneColour;
        this.windows = windows;
    }

    private int CalculateResult(){
        if (wholeRoof) roofScore+=3;
        if (oneColour&&wholeRoof) roofScore+=5;
        if (windows>0&&wholeRoof) {
            if (oneColour) roofScore+=1;
            else if (windows<=4) roofScore+=windows;
            else roofScore+=4;
        }

        return roofScore;
    }
}
