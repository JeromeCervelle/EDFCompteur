package com.edfcompteur.view;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import com.edfcompteur.controleur.AddCompteurActivity;
import com.edfcompteur.controleur.UpdateClient;
import com.edfcompteur.model.Client;
import com.edfcompteur.model.Compteur;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class CompteurListAdapter extends ListAdapter<Compteur, CompteurViewHolder> {


    public CompteurListAdapter(@NonNull DiffUtil.ItemCallback<Compteur> diffCallback) {
        super(diffCallback);
    }

    @NotNull
    @Override
    public CompteurViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        return CompteurViewHolder.create(parent);

    }

    @Override
    public void onBindViewHolder(@NonNull CompteurViewHolder holder, int position) {
        Compteur current = getItem(position);

        holder.bind(current.getIdCompteur(), current.getAdresseCompteur(), current.getIdentifiantClientCompteur());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent AddCompteur = new Intent(v.getContext(), AddCompteurActivity.class);
                AddCompteur.putExtra("idCompteur", current.getIdCompteur());
                AddCompteur.putExtra("adresseCompteur", current.getAdresseCompteur());
                AddCompteur.putExtra("idClientCompteur", current.getIdentifiantClientCompteur());
                v.getContext().startActivity(AddCompteur);
            }
        });
    }

    public static class CompteurDiff extends DiffUtil.ItemCallback<Compteur> {

        @Override
        public boolean areItemsTheSame(@NonNull Compteur oldItem, @NonNull Compteur newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Compteur oldItem, @NonNull Compteur newItem) {
            return Objects.equals(oldItem.getIdCompteur(), newItem.getIdCompteur());
        }
    }
}
