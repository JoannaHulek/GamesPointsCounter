package com.apps.jo_hu.gamespointscounter.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.apps.jo_hu.gamespointscounter.R;
import com.apps.jo_hu.gamespointscounter.model.RoofScore;

public class ScoreTable extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_table);

        Button countRoofButton = (Button) findViewById(R.id.count_roof_button);
        countRoofButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int score = countRoofScores();
                TextView roofScoreText = (TextView) findViewById(R.id.roof_score_text);
                roofScoreText.setText(Integer.toString(score));
            }
        });
    }

    private int countRoofScores() {

        CheckBox wholeRoof = (CheckBox) findViewById(R.id.whole_roof_checkBox);
        CheckBox oneColour = (CheckBox) findViewById(R.id.one_colour_checkBox);
        CheckBox specialCards = (CheckBox) findViewById(R.id.special_cards_checkBox);

        RoofScore roofScore = new RoofScore(wholeRoof.isChecked(), oneColour.isChecked(), specialCards.isChecked());

       return roofScore.getRoofScore();
    }


}
