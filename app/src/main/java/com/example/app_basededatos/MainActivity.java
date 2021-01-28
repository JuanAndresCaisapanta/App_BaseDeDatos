package com.example.app_basededatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private EditText et_codigo;
    private EditText et_nombre;
    private EditText et_apellido;
    private EditText et_telefono;
    private EditText et_correo;
    private Button btn_agregar;
    private Button btn_buscar;
    private Button btn_modificar;
    private Button btn_eliminar;
    private Button btn_limpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_codigo = findViewById(R.id.et_codigo);
        et_nombre = findViewById(R.id.et_nombre);
        et_apellido = findViewById(R.id.et_apellido);
        et_telefono = findViewById(R.id.et_telefono);
        et_correo = findViewById(R.id.et_correo);

        btn_agregar = findViewById(R.id.btn_agregar);
        btn_buscar = findViewById(R.id.btn_buscar);
        btn_modificar = findViewById(R.id.btn_modificar);
        btn_eliminar = findViewById(R.id.btn_eliminar);
        btn_limpiar = findViewById(R.id.btn_limpiar);
    }
    public void clicagregar(View view) {
        PersistirDatos persistirdatos = new PersistirDatos(this, "OCTAVODB", null, 1);
        SQLiteDatabase database = persistirdatos.getWritableDatabase();
        String nombre = et_nombre.getText().toString();
        String apellido = et_apellido.getText().toString();
        String telefono = et_telefono.getText().toString();
        String correo = et_correo.getText().toString();
        ContentValues fila = new ContentValues();
        fila.put("Nombre",nombre);
        fila.put("Apellido",apellido);
        fila.put("Telefono",telefono);
        fila.put("Correo",correo);


        long cantidad = database.insert("Contactos", null, fila);
        if(cantidad >0){
            Toast.makeText(this, "Contacto Agregado", Toast.LENGTH_LONG).show();
            limpiarcontroles();
        }else{
            Toast.makeText(this, "El contacto no se pudo ingresar", Toast.LENGTH_LONG).show();
        }
        database.close();

    }

    private void limpiarcontroles() {
        et_nombre.setText("");
        et_apellido.setText("");
        et_correo.setText("");
        et_telefono.setText("");
    }

    public void clicbuscar(View view){
        PersistirDatos persistirdatos = new PersistirDatos(this, "OCTAVODB", null, 1);
        SQLiteDatabase database = persistirdatos.getReadableDatabase();
        String codigo = et_codigo.getText().toString();
        Cursor cursor = database.rawQuery("SELECT Nombre, Apellido,Telefono, Correo " +
                "FROM Contactos WHERE Codigo="+codigo,null);
        if(cursor.moveToFirst()){
        et_nombre.setText(cursor.getString(0));
            et_apellido.setText(cursor.getString(1));
            et_telefono.setText(cursor.getString(2));
            et_correo.setText(cursor.getString(3));
        }else{
            Toast.makeText(this, "El contacto no existe", Toast.LENGTH_LONG).show();
        }
        database.close();
    }
    public void clicmodificar(View view){
        PersistirDatos persistirdatos = new PersistirDatos(this, "OCTAVODB", null, 1);
        SQLiteDatabase database = persistirdatos.getWritableDatabase();
        String nombre = et_nombre.getText().toString();
        String apellido = et_apellido.getText().toString();
        String telefono = et_telefono.getText().toString();
        String correo = et_correo.getText().toString();
        String codigo= et_codigo.getText().toString();
        ContentValues fila = new ContentValues();
        fila.put("Nombre",nombre);
        fila.put("Apellido",apellido);
        fila.put("Telefono",telefono);
        fila.put("Correo",correo);
        fila.put("Codigo",codigo);
        int cantidad = database.update("Contactos", fila,"Codigo="+codigo,null);
        if(cantidad >0){
            Toast.makeText(this, "Contacto Actualizado", Toast.LENGTH_LONG).show();
            limpiarcontroles();
        }else{
            Toast.makeText(this, "El contacto no se pudo actualizar", Toast.LENGTH_LONG).show();
        }
        database.close();


    }
    public void cliceliminar(View view){
        PersistirDatos persistirdatos = new PersistirDatos(this, "OCTAVODB", null, 1);
        SQLiteDatabase database = persistirdatos.getWritableDatabase();

        String codigo= et_codigo.getText().toString();


        int cantidad = database.delete("Contactos","Codigo="+codigo,null);
        if(cantidad >0){
            Toast.makeText(this, "Contacto Eliminar", Toast.LENGTH_LONG).show();
            limpiarcontroles();
        }else{
            Toast.makeText(this, "El contacto no se pudo eliminar", Toast.LENGTH_LONG).show();
        }
        database.close();
    }
    public void cliclimpiar(View view){
       limpiarcontroles();
    }
    public void cliclmostrarcontactos(View view){
        Intent intent = new Intent(this, ListaContactosActivity.class);
        startActivity(intent);
    }
}