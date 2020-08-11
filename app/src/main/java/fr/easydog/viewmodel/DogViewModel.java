package fr.easydog.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import fr.easydog.bo.Dog;
import fr.easydog.repositories.DogRepository;
import fr.easydog.repositories.DogRepositoryInterface;

public class DogViewModel extends AndroidViewModel {

    private DogRepositoryInterface dogRepository;

    public DogViewModel(@NonNull Application application) {
        super(application);
        dogRepository = new DogRepository(application);
    }

    public LiveData<List<Dog>> getObserver(){
        return dogRepository.getObserver();
    }

    public void insert(final Dog dog) {
        dogRepository.insert(dog);
    }
    public void getById(int id) {
        dogRepository.getById(id);
    }
    public void getAll() {
        dogRepository.getAll();
    }
    public void update(final Dog dog) {
        dogRepository.update(dog);
    }
    public void delete(final Dog dog) {
        dogRepository.delete(dog);
    }
}
