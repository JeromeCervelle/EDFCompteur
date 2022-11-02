package com.edfcompteur.dao;

import androidx.lifecycle.LiveData;
import androidx.room.*;
import com.edfcompteur.model.Client;
import com.edfcompteur.model.Compteur;

import java.util.List;

import java.util.List;

@Dao
public interface IClientDao<leclient> {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Client client);

    @Update(onConflict = OnConflictStrategy.IGNORE)
    void update(Client client);

    @Delete
    void delete(Client client);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertCompteur(Compteur leCompteur);

    @Update(onConflict = OnConflictStrategy.IGNORE)
    void updateCompteur(Compteur leCompteur);

    @Delete
    void delete(Compteur leCompteur);

    @Query("DELETE FROM client")
    void deleleAll();

    @Query("SELECT * FROM client ORDER BY client.identifiant ASC")
    LiveData<List<Client>> getAlphabetizedClients();

    @Query("SELECT * FROM compteur WHERE leClient = :leClient")
    LiveData<List<Compteur>> getClientCompteurs(Client leClient);

    LiveData<List<Compteur>> getClientCompteurs();
}
