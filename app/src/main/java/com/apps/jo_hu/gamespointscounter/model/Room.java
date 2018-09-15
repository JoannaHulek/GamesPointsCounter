package com.apps.jo_hu.gamespointscounter.model;

import java.util.Arrays;
import java.util.List;

public enum Room {

    LIVING_ROOM(3, 1,4,9),
    BEDROOM(2, 1,4),
    KITCHEN(2, 1,6),
    BATHROOM(1, 1),
    CHILDREN_ROOM(2, 2,6),
    GARAGE(2, 0,4);


    final int max;
    final List<Integer> roomScore;

    Room(int min, int max, Integer... roomScore) {
        this.max = max;
        this.roomScore = Arrays.asList(roomScore);
    }

}

