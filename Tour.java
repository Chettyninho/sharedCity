/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package APP;

/**
 *
 * @author Miguel
 */
public class Tour {
    int id;
    String nombre_tour;
    int id_ciudad;
    int id_guia;
    String nombre_guia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_tour() {
        return nombre_tour;
    }

    public void setNombre_tour(String nombre_tour) {
        this.nombre_tour = nombre_tour;
    }

    public int getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(int id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    public int getId_guia() {
        return id_guia;
    }

    public void setId_guia(int id_guia) {
        this.id_guia = id_guia;
    }

    public String getNombre_guia() {
        return nombre_guia;
    }

    public void setNombre_guia(String nombre_guia) {
        this.nombre_guia = nombre_guia;
    }

    public Tour() {
    }

    public Tour(int id, String nombre_tour, int id_ciudad, int id_guia, String nombre_guia) {
        this.id = id;
        this.nombre_tour = nombre_tour;
        this.id_ciudad = id_ciudad;
        this.id_guia = id_guia;
        this.nombre_guia = nombre_guia;
    }

}