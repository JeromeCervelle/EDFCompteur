package com.edfcompteur.dao;

import android.app.Application;
import androidx.lifecycle.LiveData;
import com.edfcompteur.model.Client;

public class ClientRepository {

    private IClientDao mClientDao;
    private LiveData<Client> mAllClients;

    ClientRepository(Application application) {
        EDFRoomDatabase db = EDFRoomDatabase.getDatabase(application);
        mClientDao = db.clientDao();
        mAllClients = mClientDao.getAlphabetizedClients();
    }

    LiveData<Client> getAllClients() {
        return mAllClients;
    }

    void insert(Client client) {
        EDFRoomDatabase.databaseWriteExecutor.execute(() -> {
            mClientDao.insert(client);
        });
    }
}
