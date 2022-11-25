package com.edfcompteur.dao.daoCompteur;

import androidx.lifecycle.LiveData;
import androidx.room.*;
import com.edfcompteur.model.Client;
import com.edfcompteur.model.Compteur;

import java.util.List;

import java.util.List;

@Dao
public interface ICompteurDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertCompteur(Compteur leCompteur);

    @Update(onConflict = OnConflictStrategy.IGNORE)
    void updateCompteur(Compteur leCompteur);

    @Delete
    void delete(Compteur leCompteur);

    @Query("SELECT idCompteur, adresseCompteur, identifiantClientCompteur FROM compteur WHERE identifiantClientCompteur = :identifiantClientCompteur")
    LiveData<List<Compteur>> getClientWithCompteurs(String identifiantClientCompteur);
}
