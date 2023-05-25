/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BBDD;

import APP.Ciudad;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author DAM & DAW
 */
public class GestorBBDDciudad {
    Statement consulta;
    Conexion c = new Conexion();
    
    public void altaCiudad(Ciudad ciudad) throws SQLException {
        consulta = c.conectar().createStatement();
        
        String cadena = "insert into ciudad(nombre, pais) values ('"+ ciudad.getNombre()+"','"+ciudad.getPais()+"')";
        consulta.executeUpdate(cadena);
    }
    
        //listar
    public ArrayList<Ciudad> listarCiudad() throws SQLException {
        ResultSet rs;
        ArrayList<Ciudad> ciudades = new ArrayList();

        consulta = c.conectar().createStatement();
        String cadena = "SELECT * FROM ciudad";
        rs = consulta.executeQuery(cadena);
        
        while (rs.next()) {  
            Ciudad ciudad = new Ciudad();
            ciudad.setId(rs.getInt(1));
            ciudad.setNombre(rs.getString(2));
            ciudad.setPais(rs.getString(3));
            ciudades.add(ciudad);
          
        }
    return ciudades;
    }
    
    //elminar
    public void borrarCiudad(int id){
        try {
            consulta = c.conectar().createStatement();
            String cadena = "delete from ciudad where id='"+id+"'";
            consulta.executeUpdate(cadena);
        } catch (SQLException ex) {
            System.out.println("Error en la inserción");
        }
    }
    
    //modificar
    public Ciudad consultarUnaCiudad(int codciudad) throws SQLException{
        Ciudad ciudad = new Ciudad();
        ResultSet rs=null;
            consulta = c.conectar().createStatement();
            String cadena = "select * from ciudad WHERE id='" + codciudad +"'";
            rs=consulta.executeQuery(cadena);
                while(rs.next()){
                    ciudad.setId(rs.getInt("id"));
                    ciudad.setNombre(rs.getString("nombre"));
                    ciudad.setPais(rs.getString("pais"));
                }
                return ciudad;
    }
    
        public void modificarCiudad(Ciudad ciudad) throws SQLException{
        consulta = c.conectar().createStatement();
        String cadena = "update ciudad set nombre='"+ciudad.getNombre()+"', pais='"+ciudad.getPais()+"'"+" where id="+ciudad.getId();
        System.out.println(cadena);
        consulta.executeUpdate(cadena);
    }
}
