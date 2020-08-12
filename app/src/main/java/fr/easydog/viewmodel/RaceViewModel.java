package fr.easydog.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import fr.easydog.bo.Race;
import fr.easydog.repositories.race.RaceRepository;
import fr.easydog.repositories.race.RaceRepositoryInterface;

public class RaceViewModel extends AndroidViewModel {

    private RaceRepositoryInterface raceRepository;

    public RaceViewModel(@NonNull Application application) {
        super(application);
        raceRepository = new RaceRepository(application);
    }

    public LiveData<List<Race>> getObserver(){
        return raceRepository.getObserver();
    }
    public LiveData<List<String>> getObserverLabel(){
        return raceRepository.getObserverLabel();
    }

    public void insert(final Race race) {
        raceRepository.insert(race);
    }
    public void getById(int id) {
        raceRepository.getById(id);
    }
    public void getAll() {
        raceRepository.getAll();
    }
    public void update(final Race race) {
        raceRepository.update(race);
    }
    public void delete(final Race race) {
        raceRepository.delete(race);
    }
}
