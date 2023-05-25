/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BBDD;

import APP.Ciudad;
import APP.Guia;
import APP.PuntoInteres;
import APP.Tour;
import APP.UsuarioNoGuia;
import APP.Visita;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miguel
 */
public class FachadaBBDD {
GestorBBDDguia gebd = new GestorBBDDguia();
GestorBBDDusuario gebduser = new GestorBBDDusuario();
GestorBBDDtour gebdtour = new GestorBBDDtour();
GestorBBDDciudad gebdciudad = new GestorBBDDciudad();
GestorBBDDPuntosInteres gepi = new GestorBBDDPuntosInteres();
    public void altaGuia(Guia guia) {
    try {
        gebd.altaGuia(guia);
    } catch (SQLException ex) {
        Logger.getLogger(FachadaBBDD.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    //borrar no l puedo pasar?
    public void listarGuias() throws SQLException {
        gebd.listarGuias();
    }
    
    public void modificarGuia(Guia guia) throws SQLException{
        gebd.modificarGuia(guia);
    }
    
    public void eliminarGuia(int id){
        gebd.borrarGuia(id);
    }
    
////////////////////////////////////////////////////////////////////////////////
    
    
    
    public void altaUsuario(UsuarioNoGuia user) {
    try {
        gebduser.altaUsuario(user);
    } catch (SQLException ex) {
        Logger.getLogger(FachadaBBDD.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    public void eliminarUsuario(int id){
        gebduser.borrarUsuario(id);
    }
    
    public void modificarusuario(UsuarioNoGuia user) throws SQLException{
        gebduser.modificarUsuario(user);
    }
/////////////////////////////////////////////////////////////////////////////////

    public void altaCiudad(Ciudad ciudad) {
    try {
        gebdciudad.altaCiudad(ciudad);
    } catch (SQLException ex) {
        Logger.getLogger(FachadaBBDD.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    public void eliminarCiudad(int id){
        gebdciudad.borrarCiudad(id);
    }
    
    public void modificarCiudad(Ciudad ciudad) throws SQLException{
        gebdciudad.modificarCiudad(ciudad);
    }
    
/////////////////////////////////////////////////////////////////////////////////
    public void altaTour(Tour tour) throws SQLException {
        gebdtour.altaTour(tour);
    }
    /////////////////////////////////////////
    
    public void altaPuntoInteres(PuntoInteres pi) throws SQLException {
        gepi.altaPuntoInteres(pi);
    }
    
    public void añadirPint(int puntoId, String localizacion){
    try {
        gebdtour.addPointRuta(puntoId, localizacion);
    } catch (SQLException ex) {
        Logger.getLogger(FachadaBBDD.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
}
