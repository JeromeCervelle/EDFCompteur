package com.edfcompteur.dao;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import com.edfcompteur.controleur.ReleveCompteur;
import com.edfcompteur.model.Client;
import com.edfcompteur.view.ClientViewHolder;
import org.jetbrains.annotations.NotNull;

public class ClientListAdapter extends ListAdapter<Client, ClientViewHolder> {


    public ClientListAdapter(@NonNull DiffUtil.ItemCallback<Client> diffCallback) {
        super(diffCallback);
    }

    @Override
    public ClientViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return ClientViewHolder.create(parent);

    }

    @Override
    public void onBindViewHolder(@NonNull ClientViewHolder holder, int position) {
        Client current = getItem(position);
        holder.bind(current.getIdentifiant(), current.getNom(), current.getPrenom());
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
