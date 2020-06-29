package com.example.registrousuarios.BD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ConexionBDHelper extends SQLiteOpenHelper {

    private static int version_actual = 11;

    public ConexionBDHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public ConexionBDHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory, version_actual);

    }

        @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL(Utiles_BD.CREAR_TABLA_USUARIOS);
            db.execSQL(Utiles_BD.CREAR_TABLA_LOCALES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+ Utiles_BD.TABLA_USUARIOS);
        db.execSQL("DROP TABLE IF EXISTS "+ Utiles_BD.TABLA_LOCALES);
        onCreate(db);
    }
}
