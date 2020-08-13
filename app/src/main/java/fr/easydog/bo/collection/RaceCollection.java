package fr.easydog.bo.collection;


import java.util.ArrayList;

import fr.easydog.bo.Race;

/**
 * RaceCollection Object
 */
public class RaceCollection {
    /**
     * ArrayList<Race> races
     */
    private ArrayList<Race> races;

    /**
     * Construct RaceCollection
     * @param races => race list
     */
    public RaceCollection(ArrayList<Race> races) {
        this.races = races;
    }

    /**
     * Get race
     * @return ArrayList<Race> races
     */
    public ArrayList<Race> getRaces() {
        return races;
    }

    /**
     * Setter Races
     * @param races => race list
     * @return void
     */
    public void setRaces(ArrayList<Race> races) {
        this.races = races;
    }

    /**
     * Method to string
     * @return String
     */
    @Override
    public String toString() {
        return "RaceCollection{" +
                "races=" + races +
                '}';
    }
}
