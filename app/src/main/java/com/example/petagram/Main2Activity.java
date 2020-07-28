package com.example.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

public class Main2Activity extends AppCompatActivity {

    private RecyclerView listaFavoritos;
    private Button btnAtras;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaFavoritos = (RecyclerView) findViewById(R.id.rvMascotasFavoritas);
        btnAtras = (Button) findViewById(R.id.btnAtras);

        LinearLayoutManager llm2 = new LinearLayoutManager(this);
        llm2.setOrientation(LinearLayoutManager.VERTICAL);

        listaFavoritos.setLayoutManager(llm2);
        inicializarAdaptador();

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this,MainActivity.class);
                startActivity(i);
                //finish();
            }
        });
    }

    public void inicializarAdaptador(){
        AdaptadorMascota adaptador = new AdaptadorMascota(MainActivity.favoritos,this);
        listaFavoritos.setAdapter(adaptador);
    }
}
