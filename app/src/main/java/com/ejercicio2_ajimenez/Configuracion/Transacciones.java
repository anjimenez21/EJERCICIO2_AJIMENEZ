package com.ejercicio2_ajimenez.Configuracion;

public class Transacciones
{
    public static final String NameDatabase = "DB";

    public static final  String tablaPersonas = "personas";
    public static final String id = "id";
    public static final String nombres = "nombres";
    public static final String apellidos = "apellidos";
    public static final String edad = "edad";
    public static final String correo = "correo";

    public static final String CreateTablePersona = "CREATE TABLE PERSONAS"+
            "( id INTEGER PRIMARY KEY AUTOINCREMENT, nombres TEXT, apellidos TEXT, edad INTEGER, "+
            "correo TEXT )";

    public static final String DROPTablePersonas = "DROP TABLE IF EXISTS personas";

    // DML
    public static final String SelectTablePersona = "SELECT * FROM " + Transacciones.tablaPersonas;


}
