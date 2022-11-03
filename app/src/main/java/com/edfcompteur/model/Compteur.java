package com.edfcompteur.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "compteur",
foreignKeys = {
        @ForeignKey(entity = Client.class,
        parentColumns = "identifiant",
        childColumns = "identifiantClientCompteur",
        onDelete = ForeignKey.CASCADE)})
public class Compteur {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int idCompteur;

    private String adresseCompteur;

    private String identifiantClientCompteur;

    public Compteur(int idCompteur, String adresseCompteur, String identifiantClientCompteur) {
        this.idCompteur = idCompteur;
        this.adresseCompteur = adresseCompteur;
        this.identifiantClientCompteur = identifiantClientCompteur;
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

    public String getIdentifiantClientCompteur() {
        return identifiantClientCompteur;
    }

    public void setIdentifiantClientCompteur(String identifiantClientCompteur) {
        this.identifiantClientCompteur = identifiantClientCompteur;
    }
}
