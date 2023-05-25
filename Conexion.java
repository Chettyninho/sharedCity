/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Miguel
 */
public class Conexion {
    String url = "jdbc:mysql://localhost:3306/sharedCity2";
    String user = "root";
    String pass = "a12345678";
    Connection c;
    
    
   public Connection conectar(){
    try{
        c  = DriverManager.getConnection(url, user,pass);
           
        System.out.println("conectado");
    }catch(SQLException ex){
        System.out.println("Error en la conexxion"+ex);
    }
return c;
}
}
