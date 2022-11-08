package com.edfcompteur.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.edfcompteur.R;
import com.edfcompteur.controleur.ReleveCompteur;
import com.edfcompteur.controleur.UpdateClient;
import org.jetbrains.annotations.NotNull;

public class CompteurViewHolder extends RecyclerView.ViewHolder {

    private final TextView idCompteurClient;
    private final TextView adresseCompteurClient;
    private final TextView idClient;

    public CompteurViewHolder(View itemView) {
        super(itemView);
        this.idCompteurClient = itemView.findViewById(R.id.editTextIdCompteur);
        this.adresseCompteurClient = itemView.findViewById(R.id.editTextAdresseCompteur);
        this.idClient = itemView.findViewById(R.id.editTextIdClient);
    }

    public void bind(int textIdCompteur, String textAdresseCompteur, String textIdClient) {
        idCompteurClient.setText(String.valueOf(textIdCompteur));
        adresseCompteurClient.setText(textAdresseCompteur);
        idClient.setText(textIdClient);
    }

    public static CompteurViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.compteur, parent, false);
        return new CompteurViewHolder(view);
    }

}
