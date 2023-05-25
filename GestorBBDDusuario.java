/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BBDD;

import APP.UsuarioNoGuia;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author DAM & DAW
 */
public class GestorBBDDusuario {
    Statement consulta;
    Conexion c = new Conexion();
    
    public void altaUsuario(UsuarioNoGuia user) throws SQLException {
        consulta = c.conectar().createStatement();
        
        String cadena = "insert into  usuarios_no_guias(dni, nombre, apellido1, apellido2, ciudad_residencia, email, contraseña, idiomas) values ('"+ user.getDni_user()+ "','"+user.getNombre_user()+"','"+ user.getApellido_user_1()+ "','"+user.getApellido_user_2()+ "','"+ user.getCiudad_residencia()+ "','"+user.getEmail()+"','"+ user.getContraseña()+ "','"+user.getIdiomas()+"')";
        consulta.executeUpdate(cadena);

    }
    
    //elminar
    public void borrarUsuario(int id){
        try {
            consulta = c.conectar().createStatement();
            String cadena = "delete from usuarios_no_guias where id='"+id+"'";
            consulta.executeUpdate(cadena);
        } catch (SQLException ex) {
            System.out.println("Error en la inserción");
        }
    }

    //listar
    public ArrayList<UsuarioNoGuia> listarUsuarios() throws SQLException {
        ResultSet rs;
        ArrayList<UsuarioNoGuia> usuarios = new ArrayList();

        consulta = c.conectar().createStatement();
        String cadena = "SELECT * FROM usuarios_no_guias";
        rs = consulta.executeQuery(cadena);
        
        while (rs.next()) {  
            UsuarioNoGuia usuario = new UsuarioNoGuia();
            usuario.setId(rs.getInt("id"));
            usuario.setDni_user(rs.getString("dni"));
            usuario.setNombre_user(rs.getString("nombre"));
            usuario.setApellido_user_1(rs.getString("apellido1"));
            usuario.setApellido_user_2(rs.getString("apellido2"));
            usuario.setCiudad_residencia(rs.getString("ciudad_residencia"));
            usuario.setEmail(rs.getString("email"));
            usuario.setContraseña(rs.getString("contraseña"));
            usuario.setIdiomas(rs.getString("idiomas"));
            
            usuarios.add(usuario);
        }
    return usuarios;
    }
        //modificar
    public UsuarioNoGuia consultarUnClienteNoGuia(int codusuario) throws SQLException{
        UsuarioNoGuia usuario = new UsuarioNoGuia();
        ResultSet rs=null;
            consulta = c.conectar().createStatement();
            String cadena = "select * from usuarios_no_guias WHERE id='" + codusuario +"'";
            rs=consulta.executeQuery(cadena);
                while(rs.next()){
                    usuario.setId(rs.getInt("id"));
                    usuario.setNombre_user(rs.getString("nombre"));
                    usuario.setApellido_user_1(rs.getString("apellido1"));
                    usuario.setApellido_user_2(rs.getString("apellido2"));
                    usuario.setCiudad_residencia(rs.getString("ciudad_residencia"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setContraseña(rs.getString("contraseña"));
                    usuario.setIdiomas(rs.getString("idiomas"));
                }
                return usuario;
    }
        public void modificarUsuario(UsuarioNoGuia usuario) throws SQLException{
        consulta = c.conectar().createStatement();
        String cadena = "update usuarios_no_guias set dni='"+usuario.getDni_user()+"', nombre='"+usuario.getNombre_user()+"', apellido1='"+usuario.getApellido_user_1()+"', apellido2='"+usuario.getApellido_user_2()+"'"+", ciudad_residencia='"+usuario.getCiudad_residencia()+"'"+" where id="+usuario.getId();
        consulta.executeUpdate(cadena);
    }
}


