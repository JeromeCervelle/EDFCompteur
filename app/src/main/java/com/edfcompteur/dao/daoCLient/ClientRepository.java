package com.edfcompteur.dao.daoCLient;

import android.app.Application;
import androidx.lifecycle.LiveData;
import com.edfcompteur.dao.EDFRoomDatabase;
import com.edfcompteur.model.Client;
import com.edfcompteur.model.Compteur;

import java.util.List;


public class ClientRepository {

    private IClientDao mClientDao;
    private LiveData<List<Client>> mAllClients;

    public ClientRepository(Application application) {
        EDFRoomDatabase db = EDFRoomDatabase.getDatabase(application);
        mClientDao = db.clientDao();
    }

    public LiveData<List<Client>> getAllClients() {
        mAllClients = mClientDao.getAlphabetizedClients();
        return mAllClients;
    }
    public LiveData<List<Client>> getClientWithCompteurs(String identifiantClient) {
        mAllClients = mClientDao.getAlphabetizedClients();
        return mAllClients;
    }

    public void insert(Client client) {
        EDFRoomDatabase.databaseWriteExecutor.execute(() -> {
            mClientDao.insert(client);
        });
    }

    public void update(Client client) {
        EDFRoomDatabase.databaseWriteExecutor.execute(() -> {
            mClientDao.update(client);
        });
    }

    public void delete(Client client) {
        EDFRoomDatabase.databaseWriteExecutor.execute(() -> {
            mClientDao.delete(client);
        });
    }

}
