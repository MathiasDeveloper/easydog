package fr.easydog.bo.converter;

import androidx.room.TypeConverter;

import fr.easydog.bo.Race;

/**
 * RaceConverter
 * Converter class for convert race object
 * for save on database with rooms
 */
public class RaceConverter {

    /**
     * String to Race
     * @param name => name of race
     * @return Race
     */
    @TypeConverter
    public Race toStoredStringRace(String name){
        return null == name ? null : new Race(name);
    }

    /**
     * Race to string
     * @param race => object race
     * @return String
     */
    @TypeConverter
    public String toStoredRace (Race race){
        return null == race ? null : race.getName();
    }
}
