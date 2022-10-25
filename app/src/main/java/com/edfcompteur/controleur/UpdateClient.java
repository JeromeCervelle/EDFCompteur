package com.edfcompteur.controleur;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.edfcompteur.R;
import com.edfcompteur.dao.EDFRoomDatabase;
import com.edfcompteur.model.Client;
import com.edfcompteur.view.ClientViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class UpdateClient extends AppCompatActivity {

    private EditText mIdentifiantClient;
    private EditText mNomCLient;
    private EditText mPrenomClient;

    private ClientViewModel mClientViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_client);

        mIdentifiantClient = findViewById(R.id.editTextTextPersonIdentification);
        mNomCLient = findViewById(R.id.editTextTextPersonNom);
        mPrenomClient = findViewById(R.id.editTextTextPersonPrenom);
        mClientViewModel = new ViewModelProvider(this).get(ClientViewModel.class);

        Bundle extras = getIntent().getExtras();

        if(extras != null){
            mIdentifiantClient.setText(extras.getString("idClient"));
            mNomCLient.setText(extras.getString("nomClient"));
            mPrenomClient.setText(extras.getString("prenomClient"));
        }

        FloatingActionButton fabUpdate = findViewById(R.id.fabUpdate);
        fabUpdate.setOnClickListener(view -> {
            String identifiant = mIdentifiantClient.getText().toString();
            String nomClient = mNomCLient.getText().toString();
            String prenomClient = mPrenomClient.getText().toString();

            Client client = new Client();
            client.setIdentifiant(identifiant);
            client.setNom(nomClient);
            client.setPrenom(prenomClient);

            EDFRoomDatabase.databaseWriteExecutor.execute(() -> {
                mClientViewModel.update(client);
                });
            finish();
        });

        FloatingActionButton fabDelete = findViewById(R.id.fabDelete);
        fabDelete.setOnClickListener(view -> {
            String identifiant = mIdentifiantClient.getText().toString();
            String nomClient = mNomCLient.getText().toString();
            String prenomClient = mPrenomClient.getText().toString();

            Client client = new Client();
            client.setIdentifiant(identifiant);
            client.setNom(nomClient);
            client.setPrenom(prenomClient);

            EDFRoomDatabase.databaseWriteExecutor.execute(() -> {
                mClientViewModel.delete(client);
            });
            finish();
        });
    }
}