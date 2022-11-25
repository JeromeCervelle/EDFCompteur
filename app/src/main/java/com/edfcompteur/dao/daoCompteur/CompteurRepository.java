package com.edfcompteur.dao.daoCompteur;

import android.app.Application;
import androidx.lifecycle.LiveData;
import com.edfcompteur.dao.EDFRoomDatabase;
import com.edfcompteur.dao.daoCLient.IClientDao;
import com.edfcompteur.model.Client;
import com.edfcompteur.model.Compteur;

import java.util.List;
public class CompteurRepository {

    private ICompteurDao mCompteurDao;
    private LiveData<List<Compteur>> mCompteursClient;


    public CompteurRepository(Application application) {
        EDFRoomDatabase db = EDFRoomDatabase.getDatabase(application);
        mCompteurDao = db.compteurDao();
    }

    public LiveData<List<Compteur>> getClientWithCompteurs(String identifiantClient) {
        mCompteursClient = mCompteurDao.getClientWithCompteurs(identifiantClient);
        return mCompteursClient;
    }

    public void insert(Compteur leCompteur) {
        EDFRoomDatabase.databaseWriteExecutor.execute(() -> {
            mCompteurDao.insertCompteur(leCompteur);
        });
    }

    public void update(Compteur leCompteur) {
        EDFRoomDatabase.databaseWriteExecutor.execute(() -> {
            mCompteurDao.updateCompteur(leCompteur);
        });
    }

    public void delete(Compteur leCompteur) {
        EDFRoomDatabase.databaseWriteExecutor.execute(() -> {
            mCompteurDao.delete(leCompteur);
        });
    }
}
