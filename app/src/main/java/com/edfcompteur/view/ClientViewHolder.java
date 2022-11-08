package com.edfcompteur.view;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import com.edfcompteur.R;
import com.edfcompteur.controleur.AddCompteurActivity;
import com.google.android.material.button.MaterialButton;

public class ClientViewHolder extends RecyclerView.ViewHolder {

    private final TextView clientItemViewId;
    private final TextView clientItemViewNom;
    private final TextView clientItemViewPrenom;
    
    private final MaterialButton compteurClientCard;
    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;


    public ClientViewHolder(View itemView) {
        super(itemView);
        this.clientItemViewId = itemView.findViewById(R.id.id_client_card);
        this.clientItemViewNom = itemView.findViewById(R.id.hint_nom_client_card);
        this.clientItemViewPrenom = itemView.findViewById(R.id.hint_prenom_client_card);
        this.compteurClientCard = itemView.findViewById(R.id.ajouterCompteur);
    }

    public void bind(String textIdClient, String textNomClient, String textPrenomClient) {
        clientItemViewId.setText(textIdClient);
        clientItemViewNom.setText(textNomClient);
        clientItemViewPrenom.setText(textPrenomClient);
        compteurClientCard.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), AddCompteurActivity.class);
            intent.putExtra("ID_CLIENT", textIdClient);
            v.getContext().startActivity(intent);
        });
    }

    public static ClientViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardclient, parent, false);
        return new ClientViewHolder(view);
    }
}
