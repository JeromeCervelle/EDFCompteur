package com.edfcompteur.view;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.edfcompteur.dao.ClientRepository;
import com.edfcompteur.model.Compteur;

import java.util.List;

public class CompteurViewModel extends AndroidViewModel {

    private ClientRepository mClient;
    private final LiveData<List<Compteur>> mAllCompteurs;

    public CompteurViewModel(Application application) {
        super(application);
        this.mClient = new ClientRepository(application);
        String identifiantClient = "CROFAB";
        this.mAllCompteurs = mClient.getClientWithCompteurs(identifiantClient);
    }

    public LiveData<List<Compteur>> getmAllCompteurs(String identifiantClient) {
        return mAllCompteurs;
    }

    public void insert(Compteur compteur) {
        mClient.insert(compteur);
    }

    public void update(Compteur compteur) { mClient.update(compteur);}

    public void delete(Compteur compteur) { mClient.delete(compteur);}
}

