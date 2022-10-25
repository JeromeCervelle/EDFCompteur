package com.edfcompteur.controleur;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.edfcompteur.R;
import com.edfcompteur.dao.ClientListAdapter;
import com.edfcompteur.view.ClientViewModel;
import com.edfcompteur.model.Client;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private ImageView mImageViewEDF, mImageViewIdentification, mImageViewClient, mImageViewTransfert, mImageViewSauvegarde;
    private TextView mEDF, mIdentification, mReleveCompteur, mImportDonnees, mSauvegarde;

    private static final int IDENTIFICATION_ACTIVITY_REQUEST_CODE = 42;
    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;


    private ClientViewModel mClientViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageViewEDF = findViewById(R.id.imageViewEDF);
        mImageViewIdentification = findViewById(R.id.imageViewIdentification);
        mImageViewClient = findViewById(R.id.imageViewClient);
        mImageViewTransfert = findViewById(R.id.imageViewTransfert);
        mImageViewSauvegarde = findViewById(R.id.imageViewSauvegarde);
        mEDF = findViewById(R.id.EDF);
        mIdentification = findViewById(R.id.Identification);
        mReleveCompteur = findViewById(R.id.ReleveCompteur);
        mImportDonnees = findViewById(R.id.ImportDonnes);
        mSauvegarde = findViewById(R.id.Sauvegarde);

       mImageViewIdentification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Identification = new Intent(MainActivity.this, Identification.class);
                startActivity(Identification);
            }
        });

        mImageViewClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ReleveCompteur = new Intent(MainActivity.this, com.edfcompteur.controleur.ReleveCompteur.class);
                startActivity(ReleveCompteur);
            }
        });

    }
}