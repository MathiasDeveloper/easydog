package fr.easydog.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import fr.easydog.bo.Race;
import fr.easydog.repositories.race.RaceRepository;
import fr.easydog.repositories.race.RaceRepositoryInterface;

/**
 * RaceViewModel class
 */
public class RaceViewModel extends AndroidViewModel {

    /**
     *  RaceRepositoryInterface raceRepository
     */
    private RaceRepositoryInterface raceRepository;

    /**
     * Construct RaceViewModel
     * @param application => Application
     */
    public RaceViewModel(@NonNull Application application) {
        super(application);
        raceRepository = new RaceRepository(application);
    }

    /**
     * Get observer race
     * @return LiveData<List<Race>>
     */
    public LiveData<List<Race>> getObserver(){
        return raceRepository.getObserver();
    }

    /**
     * Get observer label for spinner
     * @return LiveData<List<String>>
     */
    public LiveData<List<String>> getObserverLabel(){
        return raceRepository.getObserverLabel();
    }

    /**
     * Insert race
     * @param race => race object
     * @return void
     */
    public void insert(final Race race) {
        raceRepository.insert(race);
    }

    /**
     * get race by id
     * @param id => id object
     * @return void
     */
    public void getById(int id) {
        raceRepository.getById(id);
    }

    /**
     * Get all race
     * @return void
     */
    public void getAll() {
        raceRepository.getAll();
    }

    /**
     * Update Race
     * @param race => race object
     * @return void
     */
    public void update(final Race race) {
        raceRepository.update(race);
    }

    /**
     * Delete Race
     * @param race => race object
     * @return void
     */
    public void delete(final Race race) {
        raceRepository.delete(race);
    }
}
