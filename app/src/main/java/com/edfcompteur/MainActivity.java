package com.edfcompteur;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private ImageView mImageViewEDF, mImageViewIdentification, mImageViewClient, mImageViewTransfert, mImageViewSauvegarde;
    private TextView mEDF, mIdentification, mReleveCompteur, mImportDonnees, mSauvegarde;

    private static final int IDENTIFICATION_ACTIVITY_REQUEST_CODE = 42;

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

        View.OnClickListener imageIdentification = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()) {
                    case R.id.imageViewIdentification:
                        Intent i = new Intent(MainActivity.this, Identification.class);
                        startActivity(i, IDENTIFICATION_ACTIVITY_REQUEST_CODE);
                        break;
                }

            }
        };

        mImageViewIdentification.setOnClickListener(imageIdentification);

    }

    private void startActivity(Intent i, int identificationActivityRequestCode) {
    }
}