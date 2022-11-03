package com.edfcompteur.dao;

import android.app.Application;
import androidx.lifecycle.LiveData;
import com.edfcompteur.model.Client;
import com.edfcompteur.model.Compteur;

import java.util.List;


public class ClientRepository {

    private IClientDao mClientDao;
    private LiveData<List<Client>> mAllClients;

    private LiveData<List<Compteur>> mCompteursClient;
    private String identifiantClient;

    public ClientRepository(Application application) {
        EDFRoomDatabase db = EDFRoomDatabase.getDatabase(application);
        mClientDao = db.clientDao();
        mAllClients = mClientDao.getAlphabetizedClients();
        mCompteursClient = mClientDao.getClientWithCompteurs(identifiantClient);
    }

    public LiveData<List<Client>> getAllClients() {
        return mAllClients;
    }
    public LiveData<List<Compteur>> getClientCompteurs() {
        return mCompteursClient;
    }


    public void insert(Client client) {
        EDFRoomDatabase.databaseWriteExecutor.execute(() -> {
            mClientDao.insert(client);
        });
    }

    public void insert(Compteur leCompteur) {
        EDFRoomDatabase.databaseWriteExecutor.execute(() -> {
            mClientDao.insertCompteur(leCompteur);
        });
    }

    public void update(Client client) {
        EDFRoomDatabase.databaseWriteExecutor.execute(() -> {
            mClientDao.update(client);
        });
    }

    public void update(Compteur leCompteur) {
        EDFRoomDatabase.databaseWriteExecutor.execute(() -> {
            mClientDao.updateCompteur(leCompteur);
        });
    }

    public void delete(Client client) {
        EDFRoomDatabase.databaseWriteExecutor.execute(() -> {
            mClientDao.delete(client);
        });
    }

    public void delete(Compteur leCompteur) {
        EDFRoomDatabase.databaseWriteExecutor.execute(() -> {
            mClientDao.delete(leCompteur);
        });
    }
}
