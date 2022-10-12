package com.edfcompteur.controleur;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.edfcompteur.R;
import com.edfcompteur.dao.ClientListAdapter;

public class MainActivity extends AppCompatActivity {

    private ImageView mImageViewEDF, mImageViewIdentification, mImageViewClient, mImageViewTransfert, mImageViewSauvegarde;
    private TextView mEDF, mIdentification, mReleveCompteur, mImportDonnees, mSauvegarde;

    private static final int IDENTIFICATION_ACTIVITY_REQUEST_CODE = 42;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_releve_compteur);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final ClientListAdapter adapter = new ClientListAdapter(new ClientListAdapter.ClientDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));

//        mImageViewEDF = findViewById(R.id.imageViewEDF);
//        mImageViewIdentification = findViewById(R.id.imageViewIdentification);
//        mImageViewClient = findViewById(R.id.imageViewClient);
//        mImageViewTransfert = findViewById(R.id.imageViewTransfert);
//        mImageViewSauvegarde = findViewById(R.id.imageViewSauvegarde);
//        mEDF = findViewById(R.id.EDF);
//        mIdentification = findViewById(R.id.Identification);
//        mReleveCompteur = findViewById(R.id.ReleveCompteur);
//        mImportDonnees = findViewById(R.id.ImportDonnes);
//        mSauvegarde = findViewById(R.id.Sauvegarde);
//
////        View.OnClickListener imageIdentification = new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                switch(v.getId()) {
////                    case R.id.imageViewIdentification:
////                        Intent i = new Intent(MainActivity.this, Identification.class);
////                        startActivity(i, IDENTIFICATION_ACTIVITY_REQUEST_CODE);
////                        break;
////                }
////
////            }
////        };
//
//        mImageViewIdentification.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent Identification = new Intent(MainActivity.this, Identification.class);
//                startActivity(Identification);
//            }
//        });
//
//        mImageViewClient.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent ReleveCompteur = new Intent(MainActivity.this, com.edfcompteur.controleur.ReleveCompteur.class);
//                startActivity(ReleveCompteur);
//            }
//        });
    }


}