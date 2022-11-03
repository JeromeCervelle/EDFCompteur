package com.edfcompteur.controleur;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.edfcompteur.R;
import com.edfcompteur.view.ClientListAdapter;
import com.edfcompteur.dao.EDFRoomDatabase;
import com.edfcompteur.view.ClientViewHolder;
import com.edfcompteur.view.ClientViewModel;
import com.edfcompteur.model.Client;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class ReleveCompteur extends AppCompatActivity {

    public static final int UPDATE_CLIENT_ACTIVITY_REQUEST_CODE = 1;

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
            NewClientActivityResultLauncher.launch(intent);
        });
    }

    // You can do the assignment inside onAttach or onCreate, i.e, before the activity is displayed
    ActivityResultLauncher<Intent> NewClientActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                    if (result.getResultCode() == RESULT_OK) {
                        assert result.getData() != null;
                        Client client = new Client(
                                result.getData().getStringExtra(NewClient.EXTRA_REPLY_IDCLIENT),
                                result.getData().getStringExtra(NewClient.EXTRA_REPLY_NOMCLIENT),
                                result.getData().getStringExtra(NewClient.EXTRA_REPLY_PRENOMCLIENT)
                        );

                        EDFRoomDatabase.databaseWriteExecutor.execute(() -> {
                            mClientViewModel.insert(client);
                        });
                        clientInsere();

                    } else {
                        clientNonInsere();
                    }
                }
            });

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