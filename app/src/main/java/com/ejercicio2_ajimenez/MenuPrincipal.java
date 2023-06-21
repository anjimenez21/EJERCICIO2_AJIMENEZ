package com.ejercicio2_ajimenez;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MenuPrincipal extends AppCompatActivity {
    Button btncreate, btnlists, btncombo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_principal);

        btncreate = (Button) findViewById(R.id.btnCrear);
        btnlists = (Button) findViewById(R.id.btnLista);

        btncreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CrearRegistro.class);
                startActivity(intent);
            }
        });

        btnlists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListaRegistros.class);
                startActivity(intent);
            }
        });

    }
}
