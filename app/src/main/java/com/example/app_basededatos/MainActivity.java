package com.example.app_basededatos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
    public void clicagregar(View view){

    }
    public void clicbuscar(View view){

    }
    public void clicmodificar(View view){

    }
    public void cliceliminar(View view){

    }
    public void cliclimpiar(View view){

    }
}