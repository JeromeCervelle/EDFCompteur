package com.edfcompteur.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "compteur")
public class Compteur {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int idCompteur;

    private String adresseCompteur;

    private Client leClient;

    public Compteur(int idCompteur, String adresseCompteur) {
        this.idCompteur = idCompteur;
        this.adresseCompteur = adresseCompteur;
    }

    public int getIdCompteur() {
        return idCompteur;
    }

    public void setIdCompteur(int idCompteur) {
        this.idCompteur = idCompteur;
    }

    public String getAdresseCompteur() {
        return adresseCompteur;
    }

    public void setAdresseCompteur(String adresseCompteur) {
        this.adresseCompteur = adresseCompteur;
    }

    public Client getLeClient() {
        return leClient;
    }

    public void setLeClient(Client leClient) {
        this.leClient = leClient;
    }
}
