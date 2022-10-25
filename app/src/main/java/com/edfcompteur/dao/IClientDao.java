package com.edfcompteur.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.edfcompteur.model.Client;

import java.util.List;

@Dao
public interface IClientDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Client client);

    @Query("DELETE FROM client")
    void deleleAll();

    @Query("SELECT * FROM client ORDER BY client.identifiant ASC")
    LiveData<List<Client>> getAlphabetizedClients();

}
