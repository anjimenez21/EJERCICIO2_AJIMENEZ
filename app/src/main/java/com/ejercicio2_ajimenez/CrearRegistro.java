package com.ejercicio2_ajimenez;
import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.ejercicio2_ajimenez.Configuracion.SQLiteConexion;
import com.ejercicio2_ajimenez.Configuracion.Transacciones;



public class CrearRegistro extends AppCompatActivity
{
    EditText nombres, apellidos, edad, correo;
    Button btnagregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.crear_registro);
        nombres = findViewById(R.id.codigo);
        apellidos = findViewById(R.id.apellidos);
        edad = findViewById(R.id.edad);
        correo = findViewById(R.id.correo);
        btnagregar = findViewById(R.id.btnagregar);

        btnagregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddPerson();
            }
        });
    }

    private void AddPerson()
    {
        SQLiteConexion conexion = new SQLiteConexion(this, Transacciones.NameDatabase,null,1);
        SQLiteDatabase db = conexion.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(Transacciones.nombres, nombres.getText().toString());
        valores.put(Transacciones.apellidos, apellidos.getText().toString());
        valores.put(Transacciones.edad, edad.getText().toString());
        valores.put(Transacciones.correo, correo.getText().toString());

        Long result = db.insert(Transacciones.tablaPersonas, Transacciones.id, valores);
        Toast.makeText(getApplicationContext(), "Registro ingresado : " + result,Toast.LENGTH_LONG ).show();

        db.close();

        CleanScreen();

    }

    private void CleanScreen()
    {
        nombres.setText("");
        apellidos.setText("");
        edad.setText("");
        correo.setText("");
    }

}
