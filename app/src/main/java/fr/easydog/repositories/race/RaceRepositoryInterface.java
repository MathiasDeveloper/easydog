package fr.easydog.repositories.race;

import androidx.lifecycle.LiveData;

import java.util.List;

import fr.easydog.bo.Dog;
import fr.easydog.bo.Race;

public interface RaceRepositoryInterface {
    LiveData<List<Race>> getObserver();
    LiveData<List<Race>> getAll();
    Race getById(int id);
    void insert(final Race race);
    void update(final Race race);
    void delete(final Race race);
}
