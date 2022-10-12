package com.edfcompteur.dao;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.edfcompteur.model.Client;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Client.class}, version = 1, exportSchema = false)
public abstract class EDFRoomDatabase extends RoomDatabase {

    public abstract IClientDao clientDao();

    private static volatile EDFRoomDatabase INSTANCE;
    private static final int NUMBER_OF_TREADS = 1;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_TREADS);
    public static EDFRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (EDFRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), EDFRoomDatabase.class, "edf_database").build();
                }
            }
        }
        return INSTANCE;
    }
}
