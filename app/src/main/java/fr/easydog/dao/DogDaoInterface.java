package fr.easydog.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import fr.easydog.bo.Dog;

/**
 * DogDaoInterface interface
 */
@Dao
public interface DogDaoInterface {

    /**
     * Get all dog
     * @return LiveData<List<Dog>>
     */
    @Query("SELECT * FROM Dog")
    LiveData<List<Dog>> getAll();

    /**
     * Get one dog by id
     * @param id => id dog
     * @return Dog
     */
    @Query("SELECT * FROM Dog WHERE id = :id")
    Dog getById(int id);

    /**
     * InsertAll dog
     * @param dogs
     * @return void
     */
    @Insert
    void insertAll(List<Dog> dogs);

    /**
     * Insert one dog
     * @param dog => dog object
     * @return void
     */
    @Insert
    void insert(Dog dog);

    /**
     * Update dog object
     * @param dog => dog object
     */
    @Update
    void update(Dog dog);

    /**
     * Delete dog
     * @param dog => object dog
     * @return void
     */
    @Delete
    void delete(Dog dog);
}
