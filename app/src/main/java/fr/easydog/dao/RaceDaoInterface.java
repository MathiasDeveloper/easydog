package fr.easydog.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import fr.easydog.bo.Race;

@Dao
public interface RaceDaoInterface {
    @Query("SELECT * FROM Race")
    LiveData<List<Race>> getAll();

    @Query("SELECT * FROM Race WHERE id = :id")
    Race getById(int id);

    @Query("SELECT name FROM Race")
    LiveData<List<String>> getAllLabel();

    @Insert
    void insert(Race race);

    @Insert
    void insertAll(List<Race> race);

    @Update
    void update(Race race);

    @Delete
    void delete(Race race);
}
