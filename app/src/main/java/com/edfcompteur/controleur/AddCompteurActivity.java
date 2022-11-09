package com.edfcompteur.controleur;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.edfcompteur.R;
import com.edfcompteur.dao.EDFRoomDatabase;
import com.edfcompteur.model.Compteur;
import com.edfcompteur.view.CompteurListAdapter;
import com.edfcompteur.view.CompteurViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AddCompteurActivity extends AppCompatActivity {

    private CompteurViewModel mCompteurViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_compteur);

        Bundle extras = getIntent().getExtras();
        System.out.println(extras.getString("ID_CLIENT"));

        RecyclerView recyclerViewCompteur = findViewById(R.id.recyclerviewCompteur);
        final CompteurListAdapter adapterCompteur = new CompteurListAdapter(new CompteurListAdapter.CompteurDiff());
        recyclerViewCompteur.setAdapter(adapterCompteur);
        recyclerViewCompteur.setLayoutManager(new LinearLayoutManager(recyclerViewCompteur.getContext()));

        mCompteurViewModel = new ViewModelProvider(this).get(CompteurViewModel.class);
        mCompteurViewModel.getmAllCompteurs(extras.getString("ID_CLIENT")).observe(this, adapterCompteur::submitList);

        final FloatingActionButton button = findViewById(R.id.button_save);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(AddCompteurActivity.this, AjouterUnCompteur.class);
            intent.putExtra("idClientCompteur", extras.getString("ID_CLIENT"));
            NewCompteurActivityResultLauncher.launch(intent);
        });
    }

        ActivityResultLauncher<Intent> NewCompteurActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),

                result -> {

                    if (result.getResultCode() == RESULT_OK) {
                        assert result.getData() != null;
                        Compteur compteur = new Compteur(
                                result.getData().getStringExtra(AjouterUnCompteur.EXTRA_REPLY_ADRESSE_COMPTEUR),
                                result.getData().getStringExtra(AjouterUnCompteur.EXTRA_REPLY_ID_CLIENT_COMPTEUR)
                        );

                        EDFRoomDatabase.databaseWriteExecutor.execute(() -> mCompteurViewModel.insert(compteur));
                        compteurInsere();

                    } else {
                        compteurNonInsere();
                    }
                });



        private void compteurInsere() {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("Résultat :")
                    .setMessage("Compteur inséré dans la BD")
                    .setPositiveButton("OK", (dialog, which) -> {

                    })
                    .create()
                    .show();
        }

        private void compteurNonInsere() {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("Problème :")
                    .setMessage("Compteur non inséré dans la BD")
                    .setPositiveButton("OK", (dialog, which) -> {

                    })
                    .create()
                    .show();
        }
    }