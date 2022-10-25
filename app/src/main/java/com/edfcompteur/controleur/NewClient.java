package com.edfcompteur.controleur;

import android.content.Intent;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.edfcompteur.R;
import com.edfcompteur.dao.ClientRepository;
import com.edfcompteur.model.Client;
import com.edfcompteur.view.ClientViewModel;

public class NewClient extends AppCompatActivity {

        public static final String EXTRA_REPLY_IDCLIENT = "com.example.android.wordlistsql.idClient";
        public static final String EXTRA_REPLY_NOMCLIENT = "com.example.android.wordlistsql.nomClient";
        public static final String EXTRA_REPLY_PRENOMCLIENT = "com.example.android.wordlistsql.prenomClient";

        private EditText mEditIdClient;
        private EditText mEditNomClient;
        private EditText mEditPrenomClient;

        private ClientRepository cltR;


    @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_new_client);
            mEditIdClient = findViewById(R.id.id_client);
            mEditNomClient = findViewById(R.id.nom_client);
            mEditPrenomClient = findViewById(R.id.prenom_client);

            final Button button = findViewById(R.id.button_save);
            button.setOnClickListener(view -> {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditIdClient.getText()) || TextUtils.isEmpty(mEditNomClient.getText()) || TextUtils.isEmpty(mEditPrenomClient.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String idClient = mEditIdClient.getText().toString();
                    String nomClient = mEditNomClient.getText().toString();
                    String prenomClient = mEditPrenomClient.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY_IDCLIENT, idClient);
                    replyIntent.putExtra(EXTRA_REPLY_NOMCLIENT, nomClient);
                    replyIntent.putExtra(EXTRA_REPLY_PRENOMCLIENT, prenomClient);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            });
        }
}
