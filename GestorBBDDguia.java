/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BBDD;

import APP.Guia;
import APP.Tour;
import APP.UsuarioNoGuia;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Miguel
 */
public class GestorBBDDguia {
    //hazte un gestor para cada tabla y así todo mas ordenado
    Statement consulta;
    Conexion c = new Conexion();
    
    //alta
    public void altaGuia(Guia guia) throws SQLException {
        consulta = c.conectar().createStatement();
        
        String cadena = "insert into guias(dni, nombre, apellido1, apellido2, valoracion, id_ciudadResidencia, email, contraseña, idiomas) values ('"+ guia.getDni()+ "','"+guia.getNombre_guia()+"','"+ guia.getApellido_guia_1()+ "','"+guia.getApellido_guia_2()+ "',"+guia.getValoracion_guia()+",'"+ guia.getId_ciudadResidencia()+ "','"+guia.getEmail()+"','"+ guia.getContraseña()+ "','"+guia.getIdiomas()+"')";
        consulta.executeUpdate(cadena);

    }
    //elminar
    public void borrarGuia(int id){
        try {
            consulta = c.conectar().createStatement();
            String cadena = "delete from guias where id='"+id+"'";
            consulta.executeUpdate(cadena);
        } catch (SQLException ex) {
            System.out.println("Error en la inserción");
        }
    }

    //listar
    public ArrayList<Guia> listarGuias() throws SQLException {
        ResultSet rs;
        ArrayList<Guia> guias = new ArrayList();

        consulta = c.conectar().createStatement();
        String cadena = "SELECT g.id, g.dni, g.nombre, g.apellido1, g.apellido2, g.valoracion, g.id_ciudadResidencia, c.nombre AS nombre_ciudad\n" +
"FROM guias g\n" +
"JOIN ciudad c ON g.id_ciudadResidencia = c.id;";
        rs = consulta.executeQuery(cadena);
        
        while (rs.next()) {  
            Guia guia = new Guia();
            guia.setId(rs.getInt(1));
            guia.setDni(rs.getString(2));
            guia.setNombre_guia(rs.getString(3));
            guia.setApellido_guia_1(rs.getString(4));
            guia.setApellido_guia_2(rs.getString(5));
            guia.setValoracion_guia(rs.getInt(6));
            guia.setId_ciudadResidencia(rs.getInt(7));
            guia.setCiudad_residencia(rs.getString(8));
            guias.add(guia);
        }
    return guias;
    }

    
    
        //modificar
    public Guia consultarUnCliente(int codcliente) throws SQLException{
        Guia guia = new Guia();
        ResultSet rs=null;
            consulta = c.conectar().createStatement();
            String cadena = "select * from guias WHERE id='" + codcliente +"'";
            rs=consulta.executeQuery(cadena);
                while(rs.next()){
                    guia.setId(rs.getInt(1));
                    guia.setNombre_guia(rs.getString(3));
                    guia.setApellido_guia_1(rs.getString(4));
                    guia.setApellido_guia_2(rs.getString(5));
                    guia.setValoracion_guia(rs.getInt(6));
                    guia.setId_ciudadResidencia(rs.getInt(7));
                    guia.setEmail(rs.getString(8));
                    guia.setContraseña(rs.getString(9));
                    guia.setIdiomas(rs.getString(10));
                }
                return guia;
    }
        public void modificarGuia(Guia guia) throws SQLException{
        consulta = c.conectar().createStatement();
        String cadena = "update guias set dni='"+guia.getDni()+"', nombre='"+guia.getNombre_guia()+"', apellido1='"+guia.getApellido_guia_1()+"', apellido2='"+guia.getApellido_guia_2()+"'"+", valoracion="+guia.getValoracion_guia()+""+", ciudad_residencia='"+guia.getCiudad_residencia()+"'"+" where id="+guia.getId();
        System.out.println(cadena);
        consulta.executeUpdate(cadena);
    }
}
