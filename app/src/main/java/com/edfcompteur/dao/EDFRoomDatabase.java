package com.edfcompteur.dao;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.edfcompteur.dao.daoCLient.IClientDao;
import com.edfcompteur.dao.daoCompteur.ICompteurDao;
import com.edfcompteur.model.Client;
import com.edfcompteur.model.Compteur;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Client.class, Compteur.class}, version = 4, exportSchema = false)
public abstract class EDFRoomDatabase extends RoomDatabase {

    public abstract IClientDao clientDao();
    public abstract ICompteurDao compteurDao();

    private static volatile EDFRoomDatabase INSTANCE;
    private static final int NUMBER_OF_TREADS = 4;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_TREADS);

    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {

        }
    };
    public static EDFRoomDatabase getDatabase(final Context context) {

        if (INSTANCE == null) {
            synchronized (EDFRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                             EDFRoomDatabase.class, "edf_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
