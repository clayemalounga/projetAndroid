package com.groupeisi.projetdevoir;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private EditText nom,telephone,dateNaiss;
    private Spinner pays,filiere;
    private  String[] formesP;
     String fil,val;
    private  String[] formesF;
    private Button enregistrer,annuler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initCompnemt();

        //Rcupere le pays
        enregistrer.setOnClickListener(v ->
        {
            String Nonrecup = nom.getText().toString();
            String Teleph = telephone.getText().toString();
            String date = dateNaiss.getText().toString();
            pays.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                    val = formesP[position];

                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
            filiere.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                    fil = formesF[position];

                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }

            });
            // demarrons l'activite
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            intent.putExtra("nomR",Nonrecup);
            intent.putExtra("telR",Teleph);
            intent.putExtra("dateR",date);
            intent.putExtra("paysR",val);
            intent.putExtra("filR",fil);
            startActivity(intent);
        });
        //
        annuler.setOnClickListener(v ->
        {
            finish();
        });



    }
    public void initCompnemt()
    {
        nom = findViewById(R.id.nom);
        telephone = findViewById(R.id.telephone);
        dateNaiss = findViewById(R.id.dateNaiss);
        pays = findViewById(R.id.paysOr);
        filiere = findViewById(R.id.filiere);
        enregistrer = findViewById(R.id.valider);
        annuler = findViewById(R.id.annuler);
        formesP = new String[]{"Gabom","Senegal","Congo"};
        formesF = new String[]{"Reseau","Gl","Electricite"};
        //Addaptateur pour les pays
        ArrayAdapter<String> spinneradapt = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,formesP);
        spinneradapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pays.setAdapter(spinneradapt);

        //Adaptateur pour les filieres
        ArrayAdapter<String> spinneradapt2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,formesF);
        spinneradapt2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        filiere.setAdapter(spinneradapt);
    }


}