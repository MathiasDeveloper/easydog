package fr.easydog.dao.helper;

import java.util.ArrayList;
import java.util.List;

import fr.easydog.bo.Dog;
import fr.easydog.bo.Race;

/**
 * DataGenerator class
 * For generate data on create database
 */
public class DataGenerator {
    /**
     * String[] NAMES
     */
    private static final String[] NAMES = new String[]{
        "Joyce", "Petter", "Tipsy", "Nat", "Normandy"
    };

    /**
     * String[] DESCRIPTIONS
     */
    private static final String[] DESCRIPTIONS = new String[]{
            "Formidable chien qui adore les gens",
            "Adorable bete qui aime jouer",
            "N'aime pas les gens du tout ! je veux le vendre",
            "Attend des calins par millier",
            "Svp je veux des amies :D",
    };

    /**
     * String[] DESCRIPTIONS
     */
    private static final String[] RACES  = new String[]{
            "PitBull", "Spitz", "Dalmatien",
            "Caniche", "Bouvier Bernois",
            "Dog allemand", "terre-neuve"
    };

    /**
     * Generate dog method
     * @return List<Dog>
     */
    public static List<Dog> generateDogs(){
        List<Dog> dogs = new ArrayList<>(NAMES.length);
        for (int i = 0; i < NAMES.length; i++) {
            Dog dog = new Dog();
            dog.setName(NAMES[i]);
            dog.setDescription(DESCRIPTIONS[i]);
            dogs.add(dog);
        }

        return dogs;
    }

    /**
     * Generate race method
     * @return List<Race>
     */
    public static List<Race> generateRaces(){
        List<Race> races = new ArrayList<>(RACES.length);
        for (int i = 0; i < RACES.length; i++) {
            Race race = new Race(RACES[i]);
            races.add(race);
        }
        return races;
    }
}
