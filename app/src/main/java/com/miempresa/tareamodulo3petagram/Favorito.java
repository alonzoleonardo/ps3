package com.miempresa.tareamodulo3petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Favorito extends AppCompatActivity {

    private RecyclerView recyclerViewMascota;
    private ReciclerViewAdaptador adaptadorMascota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorito);

        recyclerViewMascota = findViewById(R.id.reciclerMascota);
        recyclerViewMascota.setLayoutManager(new LinearLayoutManager(this));

        adaptadorMascota = new ReciclerViewAdaptador(obtenerMascotas());
        recyclerViewMascota.setAdapter(adaptadorMascota);
    }

    public List<MascotaModelo> obtenerMascotas(){
        List<MascotaModelo> mascota = new ArrayList<>();

        mascota.add(new MascotaModelo("Tarzán", 3, R.drawable.ct4));
        mascota.add(new MascotaModelo("Spike", 5, R.drawable.ct6));
        mascota.add(new MascotaModelo("Sultán", 1, R.drawable.ct2));
        mascota.add(new MascotaModelo("Fido", 2, R.drawable.ct3));
        mascota.add(new MascotaModelo("Fiera", 0, R.drawable.ct1));
        mascota.add(new MascotaModelo("Beethoven", 4, R.drawable.ct5));

        return mascota;
    }
}