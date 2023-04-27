package com.e.trabajo_integrador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author ELIO
 */
public class ConeccionServidor {

    
    String usuario = "root";
    String contraseña = "dev3737e";
    String database = "pronosticos_deportivos";
    String ip = "localhost";
    String puerto = "3306";
    String driver = "com.mysql.jdbc.Driver";
    String cadena = "jdbc:mysql://" + ip + ":" + puerto + "/" + database;
    Connection conectar = null;
    Statement stmt = null;
    ResultSet rsCon = null;

    public Connection Conectar() throws SQLException {
        try {
            //Driver
            Class.forName(driver);
            conectar = DriverManager.getConnection(cadena, usuario, contraseña);
            stmt = conectar.createStatement();
            rsCon = stmt.executeQuery("SELECT * FROM pronosticos");
            System.out.println("-------- CONECTADO --------");
        } catch(ClassNotFoundException | SQLException e) {
            System.out.println("No se conectó a la base de datos. ERROR");
            System.out.println(e);
        }
            
        return conectar;
        
        
    }
    
    
}
