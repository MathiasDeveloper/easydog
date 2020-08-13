package fr.easydog.repositories.race;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

import fr.easydog.bo.Race;
import fr.easydog.dao.RaceDaoInterface;
import fr.easydog.dao.utils.AppDatabase;

/**
 * RaceRepository class
 */
public class RaceRepository implements RaceRepositoryInterface {

    /**
     * LiveData<List<Race>> observer
     */
    private LiveData<List<Race>> observer;

    /**
     * LiveData<List<String>> observerLabel
     */
    private LiveData<List<String>> observerLabel;

    /**
     * RaceDaoInterface raceDao
     */
    private RaceDaoInterface raceDao;

    /**
     * Construct RaceRepository
     * @param context => context app
     */
    public RaceRepository(Context context) {
        AppDatabase appDatabase = AppDatabase.getInstance(context);
        raceDao = appDatabase.getRaceDao();
        observer = raceDao.getAll();
        observerLabel = raceDao.getAllLabel();
    }

    /**
     * Get observer
     * @return LiveData<List<Race>>
     */
    @Override
    public LiveData<List<Race>> getObserver() {
        return observer;
    }

    /**
     * Get observer label for spinner
     * @return LiveData<List<String>>
     */
    @Override
    public LiveData<List<String>> getObserverLabel() {
        return observerLabel;
    }

    /**
     * Get all race
     * @return LiveData<List<Race>>
     */
    @Override
    public LiveData<List<Race>> getAll() {
        return null;
    }

    /**
     * Get race by id
     * @param id => id object
     * @return Race
     */
    @Override
    public Race getById(int id) {
        return null;
    }

    /**
     * Insert Race
     * @param race => race object
     * @return void
     */
    @Override
    public void insert(final Race race) {
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                raceDao.insert(race);
            }
        });

    }

    /**
     * Update Race
     * @param race => race object
     * @return void
     */
    @Override
    public void update(Race race) {

    }

    /**
     * Delete object race
     * @param race => Race object
     */
    @Override
    public void delete(Race race) {

    }
}
