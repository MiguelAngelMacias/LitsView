package com.example.litsview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String[] datos = new String[]{"Alojamiento", "Esparcimiento", "Compras", "Transporte", "Viajes"};
        ArrayAdapter<String> adapter = new
                ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, datos);
        Spinner cbListaCategorias = findViewById(R.id.spinner);
        cbListaCategorias.setAdapter(adapter);
        cbListaCategorias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = adapter.getItem(position);
                Toast.makeText(MainActivity.this, selectedItem, Toast.LENGTH_SHORT).show();
                String[] datos2 = new String[]{"Hoteles", "Cafeteria", "Comida rapida", "Agencia de viajes"};
                ArrayAdapter<String> adapter2 = new
                        ArrayAdapter<String>(getApplicationContext(),
                        android.R.layout.simple_spinner_item, datos2);
                Spinner cbListaCategorias = findViewById(R.id.cbSubCategorias);
                cbListaCategorias.setAdapter(adapter2);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}