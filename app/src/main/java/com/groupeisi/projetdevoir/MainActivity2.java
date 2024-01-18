package com.groupeisi.projetdevoir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import kotlinx.coroutines.scheduling.Task;
import kotlinx.coroutines.scheduling.TaskContext;

public class MainActivity2 extends AppCompatActivity {

    private EditText nom,telephone,dateNaiss,pays,filiere;
    private Button envoyer;
    private Button retour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initCompnemt();
        nom.setText(getIntent().getStringExtra("nomR"));
        telephone.setText(getIntent().getStringExtra("telR"));
        dateNaiss.setText(getIntent().getStringExtra("dateR"));
        pays.setText(getIntent().getStringExtra("paysR"));
        filiere.setText(getIntent().getStringExtra("filR"));
        envoyer.setOnClickListener(v ->
        {
            String nomEnvoyer = nom.getText().toString();
            int telephone = 771327735;
            Intent callIntent = new Intent(Intent.ACTION_VIEW);
            callIntent.setData(Uri.parse("smsto"));
            callIntent.setType("vnd.android-dir/mms-sms");
            callIntent.putExtra("address", telephone);
            callIntent.putExtra("sms_body",nomEnvoyer);
            startActivity(callIntent);
        });
        retour.setOnClickListener(v ->
        {
            Intent intRetour = new Intent(MainActivity2.this, MainActivity.class);
            startActivity(intRetour);
        });


    }
    public void initCompnemt()
    {
        nom = findViewById(R.id.nomR);
        telephone = findViewById(R.id.telephoneR);
        dateNaiss = findViewById(R.id.dateNaissR);
        pays = findViewById(R.id.rpays);
        filiere = findViewById(R.id.filiereR);
        envoyer = findViewById(R.id.Envoyer);
        retour = findViewById(R.id.Retour);

    }
}