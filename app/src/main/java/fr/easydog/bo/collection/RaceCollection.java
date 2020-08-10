package fr.easydog.bo.collection;


import java.util.ArrayList;

import fr.easydog.bo.Race;

/**
 * RaceCollection Object
 */
public class RaceCollection {
    private ArrayList<Race> races;

    public RaceCollection(ArrayList<Race> races) {
        this.races = races;
    }

    public ArrayList<Race> getRaces() {
        return races;
    }

    public void setRaces(ArrayList<Race> races) {
        this.races = races;
    }
}
