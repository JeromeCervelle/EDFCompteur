package com.edfcompteur.view.viewCompteur;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.edfcompteur.dao.daoCLient.ClientRepository;
import com.edfcompteur.dao.daoCompteur.CompteurRepository;
import com.edfcompteur.model.Compteur;

import java.util.List;

public class CompteurViewModel extends AndroidViewModel {

    private CompteurRepository mCompteur;
    private LiveData<List<Compteur>> mAllCompteurs;

    public CompteurViewModel(Application application) {
        super(application);
        this.mCompteur = new CompteurRepository(application);
    }

    public LiveData<List<Compteur>> getmAllCompteurs(String identifiantClient) {
        this.mAllCompteurs = mCompteur.getClientWithCompteurs(identifiantClient);
        return mAllCompteurs;
    }

    public void insert(Compteur compteur) {
        mCompteur.insert(compteur);
    }

    public void update(Compteur compteur) { mCompteur.update(compteur);}

    public void delete(Compteur compteur) { mCompteur.delete(compteur);}
}

