package fr.easydog.dao.utils;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import fr.easydog.bo.Dog;
import fr.easydog.bo.Race;
import fr.easydog.bo.converter.DateConverter;
import fr.easydog.bo.converter.RaceConverter;
import fr.easydog.config.Environment;
import fr.easydog.dao.DogDaoInterface;
import fr.easydog.dao.RaceDaoInterface;
import fr.easydog.dao.helper.DataGenerator;

/**
 * AppDatabase class
 */
@Database(entities = {Dog.class, Race.class}, version = Environment.VERSION, exportSchema = false)
@TypeConverters({DateConverter.class, RaceConverter.class})
public abstract class AppDatabase extends RoomDatabase {

    /**
     * AppDatabase INSTANCE
     */
    public static AppDatabase INSTANCE = null;

    /**
     * ExecutorService databaseWriteExecutor
     */
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(1);

    /**
     * Getter dog dao
     * @return DogDaoInterface
     */
    public abstract DogDaoInterface getDogDao();

    /**
     * Getter race dao
     * @return RaceDaoInterface
     */
    public abstract RaceDaoInterface getRaceDao();

    /**
     * Get instance class AppDatabase
     * @param context => Context app object
     * @return AppDatabase
     */
    public static AppDatabase getInstance(Context context) {
        if (null == INSTANCE) {
            synchronized (AppDatabase.class) {
                if (null == INSTANCE) {
                    INSTANCE = Room.databaseBuilder(
                            context,
                            AppDatabase.class,
                            Environment.DB_NAME)
                            .addCallback(roomFixture)
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * Room fixture for generate data
     * @return Callback
     */
    private static Callback roomFixture = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new AsyncTask<AppDatabase,Void,Void>() {
                @Override
                protected Void doInBackground(AppDatabase... appDatabases) {
                    DogDaoInterface dogDao = INSTANCE.getDogDao();
                    RaceDaoInterface raceDao = INSTANCE.getRaceDao();
                    dogDao.insertAll(DataGenerator.generateDogs());
                    raceDao.insertAll(DataGenerator.generateRaces());
                    return null;
                }
            }.execute(INSTANCE);
        }
    };
}
