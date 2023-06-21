package com.ejercicio2_ajimenez;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.ejercicio2_ajimenez.Configuracion.SQLiteConexion;
import com.ejercicio2_ajimenez.Configuracion.Transacciones;
import com.ejercicio2_ajimenez.Modelos.Personas;

import java.util.ArrayList;

public class ListaRegistros extends AppCompatActivity {

    SQLiteConexion conexion;
    ListView listpersonas;
    ArrayList<Personas> lista;
    ArrayList<String> ArregloPersonas;

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        setContentView(R.layout.lista_registros);

        conexion = new SQLiteConexion(this, Transacciones.NameDatabase, null, 1);
        listpersonas = (ListView) findViewById(R.id.listpersonas);

        ObtenerTabla();

        ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ArregloPersonas);
        listpersonas.setAdapter(adp);

        listpersonas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Obtener el elemento seleccionado en la lista
                String selectedItem = (String) adapterView.getItemAtPosition(i);

                // Realizar alguna acción con el elemento seleccionado
                Toast.makeText(getApplicationContext(), "Seleccionaste: " + selectedItem, Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void ObtenerTabla()
    {
        SQLiteDatabase db = conexion.getReadableDatabase();
        Personas person = null;
        lista = new ArrayList<Personas>();

        // Cursor de Base de Datos
        Cursor cursor = db.rawQuery(Transacciones.SelectTablePersona,null);

        // recorremos el cursor
        while(cursor.moveToNext())
        {
            person = new Personas();
            person.setId(cursor.getInt(0));
            person.setNombres(cursor.getString(1));
            person.setApellidos(cursor.getString(2));
            person.setEdad(cursor.getInt(3));
            person.setCorreo(cursor.getString(4));

            lista.add(person);
        }
        cursor.close();

        fillList();
    }

    private void fillList()
    {
        ArregloPersonas = new ArrayList<String>();

        for(int i=0; i < lista.size(); i++)
        {
            ArregloPersonas.add(lista.get(i).getId() + " - "
                    +lista.get(i).getNombres() + " - "
                    +lista.get(i).getApellidos());
        }
    }
}


