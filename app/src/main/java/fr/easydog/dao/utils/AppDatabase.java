package fr.easydog.dao.utils;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import fr.easydog.bo.Dog;
import fr.easydog.config.Environment;
import fr.easydog.dao.DogDaoInterface;

@Database(entities = {Dog.class}, version = Environment.VERSION)
public abstract class AppDatabase extends RoomDatabase {

    public static AppDatabase INSTANCE = null;

    public abstract DogDaoInterface dogDao();

    public AppDatabase getInstance (Context context){
        if (null == INSTANCE){
            INSTANCE = Room.databaseBuilder(
                    context,
                    AppDatabase.class,
                    Environment.DB_NAME)
                    .build();
        }
        return INSTANCE;
    }
}
