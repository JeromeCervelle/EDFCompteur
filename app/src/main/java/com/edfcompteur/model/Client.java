package com.edfcompteur.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Entity(tableName = "client")
public class Client {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "identifiant")
    private String identifiant;
    @ColumnInfo(name = "nom")
    private String nom;

    @ColumnInfo(name = "prenom")
    private String prenom;

    public List<Compteur> getMesCompteurs() {
        return mesCompteurs;
    }

    public void setMesCompteurs(List<Compteur> mesCompteurs) {
        this.mesCompteurs = mesCompteurs;
    }

    @Ignore
    private List<Compteur> mesCompteurs;

//    @ColumnInfo(name = "adresse")
//    private String adresse;
//
//    @ColumnInfo(name ="codePostal")
//    private String codePostal;
//
//    @ColumnInfo(name ="ville")
//    private String ville;
//
//    @ColumnInfo(name = "telephone")
//    private String telephone;
//
//    @ColumnInfo(name = "idCompteur")
//    private String idCompteur;
//
//    @ColumnInfo(name = "ancienReleve")
//    private Double ancienReleve;
//    @ColumnInfo(name = "dateAncienReleve")
//    private String dateAncienReleve;
//
//    @ColumnInfo(name ="dernierReleve")
//    private Double dernierReleve = 0.0;
//    @ColumnInfo(name = "dateDernierReleve")
//    private String dateDernierReleve;
//    @ColumnInfo(name = "signatureBase64")
//    private String signatureBase64 = "";
//    @ColumnInfo(name = "situation")
//    private int situation = 0;

    @NotNull
    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(@NotNull String identifiant) {
        this.identifiant = identifiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

//    public String getAdresse() {
//        return adresse;
//    }
//
//    public void setAdresse(String adresse) {
//        this.adresse = adresse;
//    }
//
//    public String getCodePostal() {
//        return codePostal;
//    }
//
//    public void setCodePostal(String codePostal) {
//        this.codePostal = codePostal;
//    }
//
//    public String getVille() {
//        return ville;
//    }
//
//    public void setVille(String ville) {
//        this.ville = ville;
//    }
//
//    public String getTelephone() {
//        return telephone;
//    }
//
//    public void setTelephone(String telephone) {
//        this.telephone = telephone;
//    }
//
//    public String getIdCompteur() {
//        return idCompteur;
//    }
//
//    public void setIdCompteur(String idCompteur) {
//        this.idCompteur = idCompteur;
//    }
//
//    public Double getAncienReleve() {
//        return ancienReleve;
//    }
//
//    public void setAncienReleve(Double ancienReleve) {
//        this.ancienReleve = ancienReleve;
//    }
//
//    public String getDateAncienReleve() {
//        return dateAncienReleve;
//    }
//
//    public void setDateAncienReleve(String dateAncienReleve) {
//        this.dateAncienReleve = dateAncienReleve;
//    }
//
//    public Double getDernierReleve() {
//        return dernierReleve;
//    }
//
//    public void setDernierReleve(Double dernierReleve) {
//        this.dernierReleve = dernierReleve;
//    }
//
//    public String getDateDernierReleve() {
//        return dateDernierReleve;
//    }
//
//    public void setDateDernierReleve(String dateDernierReleve) {
//        this.dateDernierReleve = dateDernierReleve;
//    }
//
//    public String getSignatureBase64() {
//        return signatureBase64;
//    }
//
//    public void setSignatureBase64(String signatureBase64) {
//        this.signatureBase64 = signatureBase64;
//    }
//
//    public int getSituation() {
//        return situation;
//    }
//
//    public void setSituation(int situation) {
//        this.situation = situation;
//    }


    public Client() {
    }

    public Client(@NotNull String identifiant, String nom, String prenom) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.prenom = prenom;
    }

//    public void recopieClient(Client client) {
//        this.identifiant = client.identifiant;
//        this.nom = client.nom;
//        this.prenom = client.prenom;
//        this.adresse = client.adresse;
//        this.codePostal = client.codePostal;
//        this.ville = client.ville;
//        this.telephone = client.telephone;
//    }
}
