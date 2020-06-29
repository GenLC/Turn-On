package com.example.registrousuarios.BD;

public class Utiles_BD {

    //Nombre bd
    public static final String BD_Nombre="BD_TURNON";
    //tablas
    public static final  String TABLA_USUARIOS = "Usuarios";
    public static final  String TABLA_LOCALES = "Locales";
    //Campos Usuarios
    public static final String  COLUMNA_IDUSUARIO="IdUsuario";
    public static final String  COLUMNA_TIPOUSUARIO="TipoUsuario"; // 100 para cliente 101 para local
    public static final String  COLUMNA_NOMBREAPELLIDO="NombreApellido";
    public static final String  COLUMNA_CONTRASEÑA="Contrasena";
    public static final String  COLUMNA_CORREO="Correo";
    //Campos Local
    public static final String  COLUMNA_IDLOCAL="IdLocal";
    //public static final String  COLUMNA_IDUSUARIO="IdUsuario";
    public static final String  COLUMNA_NOMBRELOCAL="NombreLocal";
    public static final String  COLUMNA_RUBRO="Rubro";



    // CREAR TABLA USUARIOS
    public static final String CREAR_TABLA_USUARIOS="CREATE TABLE "+TABLA_USUARIOS+" ("+ COLUMNA_IDUSUARIO +" INTEGER PRIMARY KEY AUTOINCREMENT,"+COLUMNA_TIPOUSUARIO +" TEXT,"+COLUMNA_NOMBREAPELLIDO+" TEXT,"+COLUMNA_CONTRASEÑA+" TEXT,"+COLUMNA_CORREO+" TEXT"+")";

    // CREAR TABLA LOCALES
    public static final String CREAR_TABLA_LOCALES="CREATE TABLE "+TABLA_LOCALES+" ("+ COLUMNA_IDLOCAL +" INTEGER PRIMARY KEY AUTOINCREMENT,"+COLUMNA_IDUSUARIO +" TEXT,"+COLUMNA_NOMBRELOCAL+" TEXT,"+COLUMNA_RUBRO+" TEXT"+")";



}
