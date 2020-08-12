package fr.easydog.repositories.race;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.Observable;

import fr.easydog.bo.Race;
import fr.easydog.dao.RaceDaoInterface;
import fr.easydog.dao.utils.AppDatabase;

public class RaceRepository implements RaceRepositoryInterface {

    private LiveData<List<Race>> observer;

    private RaceDaoInterface raceDao;

    public RaceRepository(Context context) {
        AppDatabase appDatabase = AppDatabase.getInstance(context);
        raceDao = appDatabase.getRaceDao();
        observer = raceDao.getAll();
    }

    @Override
    public LiveData<List<Race>> getObserver() {
        return observer;
    }

    @Override
    public LiveData<List<Race>> getAll() {
        return null;
    }

    @Override
    public Race getById(int id) {
        return null;
    }

    @Override
    public void insert(Race race) {

    }

    @Override
    public void update(Race race) {

    }

    @Override
    public void delete(Race race) {

    }
}
