package com.edfcompteur.model.relations;

import androidx.lifecycle.LiveData;
import androidx.room.Embedded;
import androidx.room.Relation;
import com.edfcompteur.model.Client;
import com.edfcompteur.model.Compteur;

import java.util.List;

public class ClientWithCompteurs {
    @Embedded
    Client leclient;
    @Relation(
            parentColumn = "identifiant",
            entityColumn = "identifiantClientCompteur"
    )
    LiveData<List<Compteur>> lesCompteursClient;
}
