package com.edfcompteur.controleur;

import android.content.Intent;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.edfcompteur.R;

public class AjouterUnCompteur extends AppCompatActivity {

    public static final String EXTRA_REPLY_ID_COMPTEUR = "a";
    public static final String EXTRA_REPLY_ADRESSE_COMPTEUR = "b";
    public static final String EXTRA_REPLY_ID_CLIENT_COMPTEUR = "c";

    private EditText mEditIdCompteur;
    private EditText mEditAdresseCompteur;
    private EditText mEditIdClientCompteur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_un_compteur);

            Bundle extras = getIntent().getExtras();
        System.out.println(extras.getString("idClientCompteur"));

            mEditIdCompteur = findViewById(R.id.id_compteur);
            mEditAdresseCompteur = findViewById(R.id.adresseCompteur);
            mEditIdClientCompteur = findViewById(R.id.idClientCompteur);

            mEditIdClientCompteur.setText(extras.getString("ID_CLIENT"));

            final Button button = findViewById(R.id.button_save_compteur);
            button.setOnClickListener(view -> {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditAdresseCompteur.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String adresseCompteur = mEditAdresseCompteur.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY_ADRESSE_COMPTEUR, adresseCompteur);
                    replyIntent.putExtra(EXTRA_REPLY_ID_CLIENT_COMPTEUR, extras.getString("idClientCompteur"));
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            });
        }
    }