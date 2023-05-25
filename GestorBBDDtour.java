/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BBDD;

import APP.Ciudad;
import APP.PuntoInteres;
import APP.Tour;
import APP.Visita;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author DAM & DAW
 */
public class GestorBBDDtour {
    Tour tour = new Tour();
    Statement consulta;
    Conexion c = new Conexion();
    
    public void altaTour(Tour tour) throws SQLException {
        consulta = c.conectar().createStatement();
        
        String cadena = "insert into  tours( nombre_tour, id_ciudad, id_guia) values ('"+tour.getNombre_tour()+"',"+tour.getId_ciudad()+","+tour.getId_guia()+")";
        //String cadena2 = "insert into  visitas(id_guia, nombre_tour, precio_persona, numero_asistentes, fecha, duracion, localizaciones) values ("+visita.getId_guia()+",'"+visita.getNombre_tour()+"',"+visita.getPrecio_persona()+","+visita.getNumero_asistentes()+",'"+visita.getFecha()+"',"+visita.getDuracion()+",'"+visita.getLocalizaciones()+"')";
        System.out.println(cadena);
        consulta.executeUpdate(cadena);
        //consulta.executeUpdate(cadena2);
    }

    public Object consultarUnaCiudad(int id) throws SQLException {
       Ciudad ciudad = new Ciudad();
        ResultSet rs;
            consulta = c.conectar().createStatement();
            String cadena = "select id from ciudad WHERE id='" + id +"'";
            rs=consulta.executeQuery(cadena);
                while(rs.next()){
                    tour.setId_ciudad(rs.getInt("id"));
                }
                return ciudad;
    }

    public void addPointRuta(int puntoId, String localizacion) throws SQLException {
        
        consulta = c.conectar().createStatement();

        String cadena = "insert into  tours_puntos_interes(id_tours, id_puntoInteres, localizacion) values ("+this.obtenerUltimoID()+","+puntoId+",'"+localizacion+"')";
        System.out.println(puntoId);
        System.out.println(localizacion);
        consulta.executeUpdate(cadena);    
    }

    public int consultarGuia(int id) throws SQLException {
    ResultSet rs;
    consulta = c.conectar().createStatement();
    String cadena = "SELECT id from guias WHERE ID = "+id+"";
    rs = consulta.executeQuery(cadena);
    int id_guia=0;
    while (rs.next()){
    id_guia=rs.getInt(1);
    }
    return id_guia;
    }
    
    public ArrayList<Tour> listarTours() throws SQLException{
        ArrayList<Tour> tours = new ArrayList<>();
        
        ResultSet rs;
            consulta = c.conectar().createStatement();
            String cadena = """
                            SELECT tours.id, tours.nombre_tour, guias.nombre as nombre_guia
                            FROM tours
                            INNER JOIN guias ON tours.id_guia = guias.id""";
            rs = consulta.executeQuery(cadena);
            if(rs==null){
                System.out.println("error");
            }else{
                while (rs.next()){
                Tour tourConsulta = new Tour();
                tourConsulta.setId(rs.getInt(1));
                tourConsulta.setNombre_tour(rs.getString(2));
                tourConsulta.setNombre_guia(rs.getString(3));
                tours.add(tourConsulta);
                }
            }
                return tours;
    }
    
    private int obtenerUltimoID() throws SQLException {
        int ultimoID = 0;

            consulta = c.conectar().createStatement();
            // crear la consulta para obtener el último ID
            String cadena = "SELECT id FROM tours ORDER BY id DESC LIMIT 1";

            ResultSet rs;
            rs = consulta.executeQuery(cadena);

            // obtener el valor del último ID
            if (rs.next()) {
                ultimoID = rs.getInt(1);
            
        }

        return ultimoID;
    }
    
    public String mostrarMapaRuta(int id) throws SQLException{
        System.out.println(id);
    return this.obtenerCoordenadas(id);
    }
    //hay que implementar estas dos funciones mostrar y obtewnwer
    private String obtenerCoordenadas(int id) throws SQLException {
        String cadenaDePuntos = "";
        System.out.println("es el "+id);
            consulta = c.conectar().createStatement();
            // crear la consulta para obtener el último ID
            String cadena = "SELECT localizacion FROM tours_puntos_interes WHERE id_tours ="+id+"";

            ResultSet rs;
            rs = consulta.executeQuery(cadena);

            // obtener el valor del último ID
            while (rs.next()) {
                cadenaDePuntos += rs.getString(1); 
        }

        return cadenaDePuntos;
    }
}




