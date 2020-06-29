package com.example.registrousuarios.Clientes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.registrousuarios.BD.ConexionBDHelper;
import com.example.registrousuarios.BD.Utiles_BD;

public class Clientes_AD {


    public static Cursor BuscarTodos(Context contexto) {

        ConexionBDHelper BDHelper = new ConexionBDHelper(contexto, Utiles_BD.BD_Nombre, null);
        SQLiteDatabase BaseDeDatos = BDHelper.getWritableDatabase();

        Cursor cursor = BaseDeDatos.rawQuery("SELECT * FROM " + Utiles_BD.TABLA_USUARIOS, null);

        return cursor;
    }


    public static Long InsertarUsuario(Context contexto, Integer TipoUsuario, String NombreApellido, String Contraseña, String Correo) {
        ConexionBDHelper BDHelper = new ConexionBDHelper(contexto, Utiles_BD.BD_Nombre, null);
        SQLiteDatabase BaseDeDatos = BDHelper.getWritableDatabase();


        ContentValues cv = new ContentValues();
        cv.put(Utiles_BD.COLUMNA_TIPOUSUARIO, TipoUsuario);
        cv.put(Utiles_BD.COLUMNA_NOMBREAPELLIDO, NombreApellido);
        cv.put(Utiles_BD.COLUMNA_CONTRASEÑA, Contraseña);
        cv.put(Utiles_BD.COLUMNA_CORREO, Correo);

        Long IdUsuario = BaseDeDatos.insert(Utiles_BD.TABLA_USUARIOS, null, cv);
        return IdUsuario;
    }

    public  static Long Corroborar(Context contexto, String Correo, String Contraseña) {
        ConexionBDHelper BDHelper = new ConexionBDHelper(contexto, Utiles_BD.BD_Nombre, null);
        SQLiteDatabase BaseDeDatos = BDHelper.getWritableDatabase();

        //Buscar la correo y contra por separado y verificar que los id de usuarios sean = 


        Cursor CBuscar = BaseDeDatos.rawQuery("Select " + Utiles_BD.COLUMNA_IDUSUARIO + " from " + Utiles_BD.TABLA_USUARIOS +
                " where " + Utiles_BD.COLUMNA_CORREO + " = '" + Correo + "' and " + Utiles_BD.COLUMNA_CONTRASEÑA + " = '" + Contraseña + "'", null);

        if (CBuscar.moveToFirst()) {
            Long IdUsuario = CBuscar.getLong(0);
            return IdUsuario;

        } else {
            return null;
        }
    }


}

