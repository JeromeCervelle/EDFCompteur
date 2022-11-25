package com.edfcompteur.view.viewCompteur;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.edfcompteur.R;

/**
 *
 */
public class  CompteurViewHolder extends RecyclerView.ViewHolder {

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
