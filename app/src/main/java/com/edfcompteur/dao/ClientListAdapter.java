package com.edfcompteur.dao;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import com.edfcompteur.controleur.ReleveCompteur;
import com.edfcompteur.dao.ClientViewModel;
import com.edfcompteur.model.Client;
import org.jetbrains.annotations.NotNull;

public class ClientListAdapter extends ListAdapter<Client, ReleveCompteur> {


    public ClientListAdapter(@NonNull DiffUtil.ItemCallback<Client> diffCallback) {
        super(diffCallback);
    }

    protected ClientListAdapter(@NonNull @NotNull AsyncDifferConfig<Client> config) {
        super(config);
    }

    @NonNull
    @NotNull
    @Override
    public ReleveCompteur onCreateViewHolder(ViewGroup parent, int viewType) {
        return ReleveCompteur.create(parent);

    }

    @Override
    public void onBindViewHolder(ReleveCompteur holder, int position) {
        Client current = getItem(position);
        holder.bind(current.getIdentifiant());
        holder.bind(current.getNom());
        holder.bind(current.getPrenom());
    }

    public static class ClientDiff extends DiffUtil.ItemCallback<Client> {

        @Override
        public boolean areItemsTheSame(@NonNull Client oldItem, @NonNull Client newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Client oldItem, @NonNull Client newItem) {
            return oldItem.getIdentifiant().equals(newItem.getIdentifiant());
        }
    }
}
