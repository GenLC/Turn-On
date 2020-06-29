package com.example.registrousuarios.Locales;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.registrousuarios.BD.ConexionBDHelper;
import com.example.registrousuarios.BD.Utiles_BD;

public class Locales_AD {


    public static Cursor BuscarTodos(Context contexto) {

        ConexionBDHelper BDHelper = new ConexionBDHelper(contexto, Utiles_BD.BD_Nombre, null);
        SQLiteDatabase BaseDeDatos = BDHelper.getWritableDatabase();

        Cursor cursor = BaseDeDatos.rawQuery("SELECT * FROM "+Utiles_BD.TABLA_LOCALES, null);

        return cursor;
    }

    public static Long InsertarLocal(Context contexto, Long IdUsuario, String NombreLocal,String Rubro) {
        ConexionBDHelper BDHelper = new ConexionBDHelper(contexto, Utiles_BD.BD_Nombre, null);
        SQLiteDatabase BaseDeDatos = BDHelper.getWritableDatabase();


        ContentValues cv = new ContentValues();
        cv.put(Utiles_BD.COLUMNA_IDUSUARIO, IdUsuario);
        cv.put(Utiles_BD.COLUMNA_NOMBRELOCAL, NombreLocal);
        cv.put(Utiles_BD.COLUMNA_RUBRO, Rubro);


        Long IdLocal = BaseDeDatos.insert(Utiles_BD.TABLA_LOCALES, null, cv);
        return IdLocal;

    }

    public static Long  BuscarLocal(Context contexto, Long IdUsuario) {
        ConexionBDHelper BDHelper = new ConexionBDHelper(contexto, Utiles_BD.BD_Nombre, null);
        SQLiteDatabase BaseDeDatos = BDHelper.getWritableDatabase();


        Cursor CBuscarLocal = BaseDeDatos.rawQuery("Select " + Utiles_BD.COLUMNA_IDLOCAL + " from " + Utiles_BD.TABLA_LOCALES +
                " where " + Utiles_BD.COLUMNA_IDUSUARIO + " = '" + IdUsuario + "'", null);

        if (CBuscarLocal.moveToFirst()) {
            Long IdLocal = CBuscarLocal.getLong(0);
            return  IdLocal;

        } else {
            return null;
        }

        }
}
