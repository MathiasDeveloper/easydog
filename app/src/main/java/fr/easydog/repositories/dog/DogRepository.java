package fr.easydog.repositories.dog;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

import fr.easydog.bo.Dog;
import fr.easydog.dao.DogDaoInterface;
import fr.easydog.dao.utils.AppDatabase;

/**
 * DogRepository class
 */
public class DogRepository implements DogRepositoryInterface {

    /**
     * LiveData<List<Dog>> observer
     */
    private LiveData<List<Dog>> observer = null;

    /**
     * DogDaoInterface dogDao
     */
    private DogDaoInterface dogDao;

    /**
     * Construct
     *
     * @param context
     */
    public DogRepository(final Context context) {
        AppDatabase appDatabase = AppDatabase.getInstance(context);
        dogDao = appDatabase.getDogDao();
        observer = dogDao.getAll();
    }

    /**
     * Observer list
     *
     * @return LiveData<List < Dog>>
     */
    @Override
    public LiveData<List<Dog>> getObserver() {
        return observer;
    }

    /**
     * @return LiveData<List<Dog>>
     */
    @Override
    public LiveData<List<Dog>> getAll() {
        return dogDao.getAll();
    }

    /**
     * Get dog by id
     * @param id => id object
     * @return Dog
     */
    @Override
    public Dog getById(int id) {
        return null;
    }

    /**
     * Insert dog
     * @param dog => dog object
     * @return void
     */
    @Override
    public void insert(final Dog dog) {
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                dogDao.insert(dog);
            }
        });
    }

    /**
     * Update dog
     * @param dog => dog object
     * @return void
     */
    @Override
    public void update(final Dog dog) {
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                dogDao.update(dog);
            }
        });

    }

    /**
     * Delete dog
     * @param dog => dog object
     * @return void
     */
    @Override
    public void delete(Dog dog) {

    }

}
