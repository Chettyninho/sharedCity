/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BBDD;

import APP.PuntoInteres;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author DAM & DAW
 */
public class GestorBBDDPuntosInteres {
    Statement consulta;
    Conexion c = new Conexion();
    
    public void altaPuntoInteres(PuntoInteres pi) throws SQLException {
        consulta = c.conectar().createStatement();
        
        String cadena = "insert into  puntos_de_interes (nombre, localizacion, id_ciudad) values ('"+pi.getNombre()+"','"+pi.getLocalizacion()+"',"+pi.getId_ciudad()+")";
        //String cadena2 = "insert into  visitas(id_guia, nombre_tour, precio_persona, numero_asistentes, fecha, duracion, localizaciones) values ("+visita.getId_guia()+",'"+visita.getNombre_tour()+"',"+visita.getPrecio_persona()+","+visita.getNumero_asistentes()+",'"+visita.getFecha()+"',"+visita.getDuracion()+",'"+visita.getLocalizaciones()+"')";
        
        consulta.executeUpdate(cadena);
//        consulta.executeUpdate(cadena2);
    }

    public ArrayList<PuntoInteres> obtenerPuntosDeInteres() throws SQLException {
    ResultSet rs;
    ArrayList<PuntoInteres> puntosInteres = new ArrayList<>();

    consulta = c.conectar().createStatement();
    String cadena = """
                    SELECT puntos_de_interes.id, puntos_de_interes.nombre, puntos_de_interes.localizacion, ciudad.nombre
                    FROM puntos_de_interes
                    INNER JOIN ciudad ON puntos_de_interes.id_ciudad = ciudad.id;""";
    rs = consulta.executeQuery(cadena);
if(rs==null){
    System.out.println("error");
}else{
    while (rs.next()){
        PuntoInteres pi = new PuntoInteres();
        pi.setId(rs.getInt(1));
        pi.setNombre(rs.getString(2));
        pi.setLocalizacion(rs.getString(3));
        pi.setNombre_ciudad(rs.getString(4));
        puntosInteres.add(pi);
    }}
    return puntosInteres;
}

}
