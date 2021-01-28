package com.example.app_basededatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class PersistirDatos extends SQLiteOpenHelper {

    private final String SQL_CREATE_TABLE_CONTACTOS="CREATE TABLE Contactos(Codigo INTEGER PRIMARY KEY AUTOINCREMENT, Nombre TEXT, Apellido TEXT, Telefono TEXT, Correo TEXT)";

    public PersistirDatos(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_CONTACTOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Contactos");
        db.execSQL(SQL_CREATE_TABLE_CONTACTOS);
    }
}
