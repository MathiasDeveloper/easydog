package fr.easydog.repositories;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

import fr.easydog.bo.Dog;
import fr.easydog.dao.DogDaoInterface;
import fr.easydog.dao.utils.AppDatabase;

public class DogRepository implements DogRepositoryInterface {

    private static DogRepository INSTANCE = null;

    private LiveData<List<Dog>> observer = null;

    private DogDaoInterface dogDao;

    public DogRepository(final Context context) {
         AppDatabase appDatabase = AppDatabase.getInstance(context);
         dogDao = appDatabase.dogDao();
         observer = dogDao.getAll();
    }

    @Override
    public LiveData<List<Dog>> getObserver(){
        return observer;
    }

    @Override
    public LiveData<List<Dog>> getAll() {
        return dogDao.getAll();
    }

    @Override
    public Dog getById(int id) {
        return null;
    }

    @Override
    public void insert(final Dog dog) {
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                dogDao.insert(dog);
            }
        });
    }

    @Override
    public void update(Dog dog) {

    }

    @Override
    public void delete(Dog dog) {

    }

}
