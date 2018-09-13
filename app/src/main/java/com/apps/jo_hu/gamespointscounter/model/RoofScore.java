package com.apps.jo_hu.gamespointscounter.model;

public class RoofScore {
    private final Boolean wholeRoof;
    private final Boolean oneColour;
    private final Boolean specialCards;

    public int getRoofScore() {

        return CalculateResult();
    }

    private int roofScore;


    public RoofScore(Boolean wholeRoof, Boolean oneColour, Boolean specialCards) {
        this.wholeRoof = wholeRoof;
        this.oneColour = oneColour;
        this.specialCards = specialCards;
    }

    private int CalculateResult(){
        if (wholeRoof) roofScore+=4;
        if (oneColour&&wholeRoof) roofScore+=5;
        if (specialCards) roofScore+=1;

        return roofScore;
    }
}
