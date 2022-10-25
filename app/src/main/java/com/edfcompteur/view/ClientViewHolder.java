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

public class ClientViewHolder extends RecyclerView.ViewHolder {

    private final TextView clientItemViewId;
    private final TextView clientItemViewNom;
    private final TextView clientItemViewPrenom;

    public ClientViewHolder(View itemView) {
        super(itemView);
        this.clientItemViewId = itemView.findViewById(R.id.id_client_card);
        this.clientItemViewNom = itemView.findViewById(R.id.hint_nom_client_card);
        this.clientItemViewPrenom = itemView.findViewById(R.id.hint_prenom_client_card);
    }

    public void bind(String textIdClient, String textNomClient, String textPrenomClient) {
        clientItemViewId.setText(textIdClient);
        clientItemViewNom.setText(textNomClient);
        clientItemViewPrenom.setText(textPrenomClient);
    }

    public static ClientViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardclient, parent, false);
        return new ClientViewHolder(view);
    }

}
