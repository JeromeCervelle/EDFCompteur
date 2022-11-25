package com.edfcompteur.dao.daoCLient;

import androidx.lifecycle.LiveData;
import androidx.room.*;
import com.edfcompteur.model.Client;
import com.edfcompteur.model.Compteur;

import java.util.List;

import java.util.List;

@Dao
public interface IClientDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Client client);

    @Update(onConflict = OnConflictStrategy.IGNORE)
    void update(Client client);

    @Delete
    void delete(Client client);

    @Query("SELECT * FROM client ORDER BY client.identifiant ASC")
    LiveData<List<Client>> getAlphabetizedClients();

}
