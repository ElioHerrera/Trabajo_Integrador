package com.e.trabajo_integrador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConeccionServidor {
 
    //Variables para indicar ruta
    String usuario = "root";
    String contraseña = "dev3737e";
    String database = "pronosticos_deportivos";
    String ip = "localhost";
    String puerto = "3306";
    String driver = "com.mysql.jdbc.Driver";
    String cadena = "jdbc:mysql://" + ip + ":" + puerto + "/" + database;
    
    //Objetos de conección
    Connection conectar = null;
    Statement statement = null;
    ResultSet resultadoSELEC = null;

    //Metodo conección a DB
    public Connection Conectar() throws SQLException {
        try {
            //Coneccion
            Class.forName(driver);
            conectar = DriverManager.getConnection(cadena, usuario, contraseña);
            statement = conectar.createStatement();
            resultadoSELEC = statement.executeQuery("SELECT * FROM pronosticos");
            System.out.println("-------- CONECTADO --------");
        } catch(ClassNotFoundException | SQLException e) {
            System.out.println("No se conectó a la base de datos. ERROR");
            System.out.println(e);
        }
       return conectar; 
    }
}