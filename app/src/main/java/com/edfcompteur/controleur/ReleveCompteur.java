package com.edfcompteur.controleur;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.edfcompteur.R;
import org.jetbrains.annotations.NotNull;

public class ReleveCompteur extends ViewHolder {

    private final TextView clientItemView;
    public ReleveCompteur(View itemView) {
        super(itemView);
        this.clientItemView = itemView.findViewById(R.id.textView);
    }

    public void bind(String text) {
        clientItemView.setText(text);
    }

    public static ReleveCompteur create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        return new ReleveCompteur(view);
    }
}