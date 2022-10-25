package com.edfcompteur.dao;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.edfcompteur.model.Client;
import com.edfcompteur.model.Compteur;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Client.class, Compteur.class}, version = 1, exportSchema = false)
public abstract class EDFRoomDatabase extends RoomDatabase {

    public abstract IClientDao clientDao();

    private static volatile EDFRoomDatabase INSTANCE;
    private static final int NUMBER_OF_TREADS = 4;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_TREADS);
    public static EDFRoomDatabase getDatabase(final Context context) {

        if (INSTANCE == null) {
            synchronized (EDFRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                             EDFRoomDatabase.class, "edf_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
