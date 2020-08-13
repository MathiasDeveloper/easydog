package fr.easydog.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import fr.easydog.bo.Race;

/**
 * RaceDaoInterface interface
 */
@Dao
public interface RaceDaoInterface {
    /**
     * Get all Race
     * @return LiveData<List<Race>>
     */
    @Query("SELECT * FROM Race")
    LiveData<List<Race>> getAll();

    /**
     * Get race by id
     * @param id => id race
     * @return Race
     */
    @Query("SELECT * FROM Race WHERE id = :id")
    Race getById(int id);

    /**
     * Get label for set on spinner
     * @return LiveData<List<String>>
     */
    @Query("SELECT name FROM Race")
    LiveData<List<String>> getAllLabel();

    /**
     * Insert race
     * @param race => race object
     * @return  void
     */
    @Insert
    void insert(Race race);

    /**
     * Insert All race object
     * @param race => race object
     * @return void
     */
    @Insert
    void insertAll(List<Race> race);

    /**
     * Update race
     * @param race => race object
     * @return  void
     */
    @Update
    void update(Race race);

    /**
     * Delete race
     * @param race => race object
     * @return  void
     */
    @Delete
    void delete(Race race);
}
