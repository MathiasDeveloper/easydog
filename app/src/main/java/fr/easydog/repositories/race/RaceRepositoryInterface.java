package fr.easydog.repositories.race;

import androidx.lifecycle.LiveData;

import java.util.List;

import fr.easydog.bo.Dog;
import fr.easydog.bo.Race;

/**
 * RaceRepositoryInterface interface
 */
public interface RaceRepositoryInterface {
    /**
     * Get observer
     * @return LiveData<List<Race>>
     */
    LiveData<List<Race>> getObserver();

    /**
     * Get observer label
     * @return LiveData<List<String>>
     */
    LiveData<List<String>> getObserverLabel();

    /**
     * Get all
     * @return LiveData<List<Race>>
     */
    LiveData<List<Race>> getAll();

    /**
     * Get Race by id
     * @param id => id object
     * @return Race
     */
    Race getById(int id);

    /**
     * Insert
     * @param race => race object
     * @return void
     */
    void insert(final Race race);

    /**
     * Update
     * @param race => race object
     * @return void
     */
    void update(final Race race);

    /**
     * Delete
     * @param race => race object
     * @return void
     */
    void delete(final Race race);
}
