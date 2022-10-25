package com.edfcompteur.dao;

import android.app.Application;
import androidx.lifecycle.LiveData;
import com.edfcompteur.model.Client;

import java.util.List;

public class ClientRepository {

    private IClientDao mClientDao;
    private LiveData<List<Client>> mAllClients;

    public ClientRepository(Application application) {
        EDFRoomDatabase db = EDFRoomDatabase.getDatabase(application);
        mClientDao = db.clientDao();
        mAllClients = mClientDao.getAlphabetizedClients();
    }

    public LiveData<List<Client>> getAllClients() {
        return mAllClients;
    }

    public void insert(Client client) {
        EDFRoomDatabase.databaseWriteExecutor.execute(() -> {
            mClientDao.insert(client);
        });
    }
}
