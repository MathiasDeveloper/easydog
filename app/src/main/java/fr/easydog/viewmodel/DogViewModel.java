package fr.easydog.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import fr.easydog.bo.Dog;
import fr.easydog.repositories.dog.DogRepository;
import fr.easydog.repositories.dog.DogRepositoryInterface;

/**
 * DogViewModel class
 */
public class DogViewModel extends AndroidViewModel {

    /**
     * DogRepositoryInterface dogRepository
     */
    private DogRepositoryInterface dogRepository;

    /**
     * Construct DogViewModel
     * @param application
     */
    public DogViewModel(@NonNull Application application) {
        super(application);
        dogRepository = new DogRepository(application);
    }

    /**
     * Get Observer
     * @return LiveData<List<Dog>>
     */
    public LiveData<List<Dog>> getObserver(){
        return dogRepository.getObserver();
    }

    /**
     * Insert dog
     * @param dog => object dog
     * @return void
     */
    public void insert(final Dog dog) {
        dogRepository.insert(dog);
    }

    /**
     * Get dog by id
     * @param id => id object
     */
    public void getById(int id) {
        dogRepository.getById(id);
    }

    /**
     * Get all dog
     * @return void
     */
    public void getAll() {
        dogRepository.getAll();
    }
    /**
     * Update dog
     * @param dog => dog object
     * @return void
     */
    public void update(final Dog dog) {
        dogRepository.update(dog);
    }
    /**
     * Delete dog
     * @param dog => dog object
     * @return void
     */
    public void delete(final Dog dog) {
        dogRepository.delete(dog);
    }
}
