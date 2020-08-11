package fr.easydog.bo.converter;

import androidx.room.TypeConverter;

import fr.easydog.bo.Race;

public class RaceConverter {

    @TypeConverter
    public Race toStoredStringRace(String name){
        return null == name ? null : new Race(name);
    }

    @TypeConverter
    public String toStoredRace (Race race){
        return null == race ? null : race.getName();
    }
}
