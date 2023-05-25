/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package APP;

import java.sql.Date;

/**
 *
 * @author Miguel
 */
public class Visita {
    int id;
    int id_guia;
    String nombre_tour;
    Double precio_persona;
    int numero_asistentes;
    Date fecha;
    String duracion;
    String localizaciones;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_guia() {
        return id_guia;
    }

    public void setId_guia(int id_guia) {
        this.id_guia = id_guia;
    }

    public String getNombre_tour() {
        return nombre_tour;
    }

    public void setNombre_tour(String nombre_tour) {
        this.nombre_tour = nombre_tour;
    }

    public Double getPrecio_persona() {
        return precio_persona;
    }

    public void setPrecio_persona(Double precio_persona) {
        this.precio_persona = precio_persona;
    }

    public int getNumero_asistentes() {
        return numero_asistentes;
    }

    public void setNumero_asistentes(int numero_asistentes) {
        this.numero_asistentes = numero_asistentes;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getLocalizaciones() {
        return localizaciones;
    }

    public void setLocalizaciones(String localizaciones) {
        this.localizaciones = localizaciones;
    }

    public Visita(int id, int id_guia, String nombre_tour, Double precio_persona, int numero_asistentes, Date fecha, String duracion, String localizaciones) {
        this.id = id;
        this.id_guia = id_guia;
        this.nombre_tour = nombre_tour;
        this.precio_persona = precio_persona;
        this.numero_asistentes = numero_asistentes;
        this.fecha = fecha;
        this.duracion = duracion;
        this.localizaciones = localizaciones;
    }

    public Visita() {
    }
    
       
}
