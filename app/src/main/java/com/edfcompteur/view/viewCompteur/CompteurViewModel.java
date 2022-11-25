package com.edfcompteur.view.viewCompteur;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.edfcompteur.dao.daoCLient.ClientRepository;
import com.edfcompteur.model.Compteur;

import java.util.List;

public class CompteurViewModel extends AndroidViewModel {

    private ClientRepository mClient;
    private LiveData<List<Compteur>> mAllCompteurs;

    public CompteurViewModel(Application application) {
        super(application);
        this.mClient = new ClientRepository(application);
    }

    public LiveData<List<Compteur>> getmAllCompteurs(String identifiantClient) {
        this.mAllCompteurs = mClient.getClientWithCompteurs(identifiantClient);
        return mAllCompteurs;
    }

    public void insert(Compteur compteur) {
        mClient.insert(compteur);
    }

    public void update(Compteur compteur) { mClient.update(compteur);}

    public void delete(Compteur compteur) { mClient.delete(compteur);}
}

