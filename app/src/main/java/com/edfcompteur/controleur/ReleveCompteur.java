package com.edfcompteur.controleur;

import android.content.Intent;
import android.widget.Toast;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.edfcompteur.R;
import com.edfcompteur.dao.ClientListAdapter;
import com.edfcompteur.dao.EDFRoomDatabase;
import com.edfcompteur.dao.IClientDao;
import com.edfcompteur.view.ClientViewModel;
import com.edfcompteur.model.Client;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ReleveCompteur extends AppCompatActivity {

    public static final int NEW_CLIENT_ACTIVITY_REQUEST_CODE = 1;

//    public static final String EXTRA_REPLY_IDCLIENT = "com.example.android.wordlistsql.idClient";
//    public static final String EXTRA_REPLY_NOMCLIENT = "com.example.android.wordlistsql.nomClient";
//    public static final String EXTRA_REPLY_PRENOMCLIENT = "com.example.android.wordlistsql.prenomClient";

    private ClientViewModel mClientViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_releve_compteur);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final ClientListAdapter adapter = new ClientListAdapter(new ClientListAdapter.ClientDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));


        mClientViewModel = new ViewModelProvider(this).get(ClientViewModel.class);
        mClientViewModel.getmAllClients().observe(this, clients -> {
            adapter.submitList(clients);
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            Intent intent = new Intent(ReleveCompteur.this, NewClient.class);
            startActivityForResult(intent, NEW_CLIENT_ACTIVITY_REQUEST_CODE);
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_CLIENT_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Client client = new Client(
                    data.getStringExtra(NewClient.EXTRA_REPLY_IDCLIENT),
                    data.getStringExtra(NewClient.EXTRA_REPLY_NOMCLIENT),
                    data.getStringExtra(NewClient.EXTRA_REPLY_PRENOMCLIENT)
                    );

            EDFRoomDatabase.databaseWriteExecutor.execute(() -> {
                mClientViewModel.insert(client);
            });
            clientInsere();

        } else {
            clientNonInsere();
        }
    }

    private void clientInsere() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Résultat :")
                .setMessage("Client inséré dans la BD")
                .setPositiveButton("OK", (dialog, which) -> {

                })
                .create()
                .show();
    }

    private void clientNonInsere() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Problème :")
                .setMessage("Client non inséré dans la BD")
                .setPositiveButton("OK", (dialog, which) -> {

                })
                .create()
                .show();
    }
}