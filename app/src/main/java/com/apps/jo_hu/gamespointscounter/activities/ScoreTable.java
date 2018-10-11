package com.apps.jo_hu.gamespointscounter.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.apps.jo_hu.gamespointscounter.R;
import com.apps.jo_hu.gamespointscounter.model.RoofScore;
import com.apps.jo_hu.gamespointscounter.model.Room;
import com.apps.jo_hu.gamespointscounter.model.RoomScore;

import java.util.ArrayList;
import java.util.List;

public class ScoreTable extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_table);

        Button countRoofButton = findViewById(R.id.count_roof_button);
        countRoofButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                int roofScore = countRoofScores();
                TextView roofScoreText = findViewById(R.id.count_roof_label);
                roofScoreText.setText(getString(R.string.roof_scores) + Integer.toString(roofScore));
            }
        });

        Button countRoomsButton = findViewById(R.id.count_rooms_button);
        countRoomsButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int roomScore = countRoomScores();
                TextView roomsScoreText = findViewById(R.id.count_rooms_label);
                roomsScoreText.setText(getString(R.string.rooms_scores)+ Integer.toString(roomScore));
            }
        }));

    }

    private int countRoofScores() {

        CheckBox wholeRoof = findViewById(R.id.whole_roof_checkBox);
        CheckBox oneColour = findViewById(R.id.one_colour_checkBox);
        EditText numberOfWindows = findViewById(R.id.windows_et);

        RoofScore roofScore = new RoofScore(wholeRoof.isChecked(), oneColour.isChecked(), getNumberOfWindows(numberOfWindows.getText().toString()));

       return roofScore.getRoofScore();
    }

    private int getNumberOfWindows (String numberOfWindows){

        if (numberOfWindows==null|| numberOfWindows.equals("")) numberOfWindows = "0";
        return Integer.parseInt(numberOfWindows);
    }


    private int countRoomScores() {
        CheckBox bathroomKitchenBedroomExtraScores = findViewById(R.id.bathroom_kitchen_bedroom_extra_scores);
        CheckBox bathroomOnEachFloorExtraScores = findViewById(R.id.bathroom_on_each_floor_extra_scores);

        RoomScore roomScore = new RoomScore(createSampleRoomsList(), bathroomKitchenBedroomExtraScores.isChecked(), bathroomOnEachFloorExtraScores.isChecked());

        return roomScore.getRoomScore();

    }

    private List<Room> createSampleRoomsList() {
        List<Room> sampleRooms = new ArrayList();
        sampleRooms.add(Room.KITCHEN);
        sampleRooms.add(Room.BATHROOM);
        sampleRooms.add(Room.BEDROOM);
        sampleRooms.add(Room.LIVING_ROOM);
        sampleRooms.add(Room.GARAGE);

        return sampleRooms;
    }



}
