package com.edfcompteur.model;

import android.database.DatabaseErrorHandler;

import java.util.Date;

public class Client {

    private String identifiant, nom, prenom, adresse, codePostal, ville, telephone;

    private String idCompteur;
    private Double ancienReleve;
    private Date dateAncienReleve;

    private Double dernierReleve = 0.0;
    private Date dateDernierReleve = new Date();
    private String signatureBase64 = "";
    private int situation = 0;

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getIdCompteur() {
        return idCompteur;
    }

    public void setIdCompteur(String idCompteur) {
        this.idCompteur = idCompteur;
    }

    public Double getAncienReleve() {
        return ancienReleve;
    }

    public void setAncienReleve(Double ancienReleve) {
        this.ancienReleve = ancienReleve;
    }

    public Date getDateAncienReleve() {
        return dateAncienReleve;
    }

    public void setDateAncienReleve(Date dateAncienReleve) {
        this.dateAncienReleve = dateAncienReleve;
    }

    public Double getDernierReleve() {
        return dernierReleve;
    }

    public void setDernierReleve(Double dernierReleve) {
        this.dernierReleve = dernierReleve;
    }

    public Date getDateDernierReleve() {
        return dateDernierReleve;
    }

    public void setDateDernierReleve(Date dateDernierReleve) {
        this.dateDernierReleve = dateDernierReleve;
    }

    public String getSignatureBase64() {
        return signatureBase64;
    }

    public void setSignatureBase64(String signatureBase64) {
        this.signatureBase64 = signatureBase64;
    }

    public int getSituation() {
        return situation;
    }

    public void setSituation(int situation) {
        this.situation = situation;
    }

    public Client() {
    }

    public Client(Double dernierReleve, Date dateDernierReleve, String signatureBase64, int situation) {
        this.dernierReleve = dernierReleve;
        this.dateDernierReleve = dateDernierReleve;
        this.signatureBase64 = signatureBase64;
        this.situation = situation;
    }

    public void recopieClient(Client client) {
        this.identifiant = client.identifiant;
        this.nom = client.nom;
        this.prenom = client.prenom;
        this.adresse = client.adresse;
        this.codePostal = client.codePostal;
        this.ville = client.ville;
        this.telephone = client.telephone;
    }
}
