package com.miempresa.tareamodulo3petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewMascota;
    private ReciclerViewAdaptador adaptadorMascota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.action_bar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("Petagram inicio");

        recyclerViewMascota = findViewById(R.id.reciclerMascota);
        recyclerViewMascota.setLayoutManager(new LinearLayoutManager(this));

        adaptadorMascota = new ReciclerViewAdaptador(obtenerMascotas());
        recyclerViewMascota.setAdapter(adaptadorMascota);
    }

    public List<MascotaModelo> obtenerMascotas(){
        List<MascotaModelo> mascota = new ArrayList<>();
        mascota.add(new MascotaModelo("Fiera", 0, R.drawable.ct1));
        mascota.add(new MascotaModelo("Sultán", 1, R.drawable.ct2));
        mascota.add(new MascotaModelo("Fido", 2, R.drawable.ct3));
        mascota.add(new MascotaModelo("Tarzán", 3, R.drawable.ct4));
        mascota.add(new MascotaModelo("Beethoven", 4, R.drawable.ct5));
        mascota.add(new MascotaModelo("Spike", 5, R.drawable.ct6));

        return mascota;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.toString().equals("favorito")){
            Intent intent = new Intent(this, Favorito.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}