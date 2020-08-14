package fr.easydog.repositories.dog;

import androidx.lifecycle.LiveData;

import java.util.List;

import fr.easydog.bo.Dog;


/**
 * DogRepositoryInterface interface
 */
public interface DogRepositoryInterface {
    /**
     * Get observer list dog
     * @return LiveData<List<Dog>>
     */
    LiveData<List<Dog>> getObserver();

    /**
     * Get observer list dog
     * @return LiveData<List<Dog>>
     */
    LiveData<List<Dog>> getAll();

    /**
     * Get dog by id
     * @param id => id object
     * @return Dog
     */
    Dog getById(int id);

    /**
     * Insert dog
     * @param dog =>  object
     * @return Dog
     */
    void insert(final Dog dog);

    /**
     * Insert dog
     * @param dog =>  object
     * @return Dog
     */
    void update(final Dog dog);

    /**
     * Insert dog
     * @param dog => object
     * @return Dog
     */
    void delete(final Dog dog);
}
