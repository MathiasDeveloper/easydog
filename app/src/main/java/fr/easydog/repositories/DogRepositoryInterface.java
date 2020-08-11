package fr.easydog.repositories;

import androidx.lifecycle.LiveData;

import java.util.List;

import fr.easydog.bo.Dog;


public interface DogRepositoryInterface {
    LiveData<List<Dog>> getObserver();
    LiveData<List<Dog>> getAll();
    Dog getById(int id);
    void insert(Dog dog);
    void update(Dog dog);
    void delete(Dog dog);
}
