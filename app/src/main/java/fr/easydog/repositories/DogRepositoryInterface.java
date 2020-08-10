package fr.easydog.repositories;

import androidx.lifecycle.LiveData;

import fr.easydog.bo.Dog;


public interface DogRepositoryInterface {
    LiveData<Dog> getAll();
    Dog getById(int id);
    void insert(Dog dog);
    void update(Dog dog);
    void delete(Dog dog);
}
