package fr.easydog.repositories.dog;

import androidx.lifecycle.LiveData;

import java.util.List;

import fr.easydog.bo.Dog;


public interface DogRepositoryInterface {
    LiveData<List<Dog>> getObserver();
    LiveData<List<Dog>> getAll();
    Dog getById(int id);
    void insert(final Dog dog);
    void update(final Dog dog);
    void delete(final Dog dog);
}
