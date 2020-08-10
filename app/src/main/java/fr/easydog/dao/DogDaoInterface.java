package fr.easydog.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import fr.easydog.bo.Dog;

@Dao
public interface DogDaoInterface {

    @Query("SELECT * FROM Dog")
    LiveData<Dog> getAll();

    @Query("SELECT * FROM Dog WHERE id = :id")
    Dog getById(int id);

    @Insert
    void insert(Dog dog);

    @Update
    void update(Dog dog);

    @Delete
    void delete(Dog dog);
}
