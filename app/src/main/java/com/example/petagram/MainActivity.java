package com.example.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView listaMascotas;
    ArrayList<Mascota> mascotas;
    public static ArrayList<Mascota> favoritos;

    public static Button btnFavoritos;
    public static int cantidad_favoritos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFavoritos = (Button) findViewById(R.id.btnFavoritos);
        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicalizarMascotas();
        inicializarAdaptador();



    }

    public void irSegundaActividad(View v){
        Intent i = new Intent(this,Main2Activity.class);
        startActivity(i);
    }

    public void inicializarAdaptador(){
        AdaptadorMascota adaptador = new AdaptadorMascota(mascotas,this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicalizarMascotas(){
        mascotas = new ArrayList<Mascota>();
        favoritos = new ArrayList<>();

        mascotas.add(new Mascota(R.drawable.perro1,"Pupy",0));
        mascotas.add(new Mascota(R.drawable.perro2,"Coco",0));
        mascotas.add(new Mascota(R.drawable.perro3,"Rambo",0));
        mascotas.add(new Mascota(R.drawable.perro4,"Lolo",0));
        mascotas.add(new Mascota(R.drawable.perro5,"Pepe",0));

    }
}
