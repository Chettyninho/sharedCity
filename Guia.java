/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package APP;

/**
 *
 * @author Miguel
 */
public class Guia {
    int id;
    String dni;
    String nombre_guia;
    String apellido_guia_1;
    String apellido_guia_2;
    int valoracion_guia;
    int id_ciudadResidencia;
    String ciudad_residencia;
    private String email;
    private String contraseña;
    String idiomas;

    public Guia() {
    }

    public Guia(int id, String dni, String nombre_guia, String apellido_guia_1, String apellido_guia_2, int valoracion_guia, int id_ciudadResidencia, String ciudad_residencia, String email, String contraseña, String idiomas) {
        this.id = id;
        this.dni = dni;
        this.nombre_guia = nombre_guia;
        this.apellido_guia_1 = apellido_guia_1;
        this.apellido_guia_2 = apellido_guia_2;
        this.valoracion_guia = valoracion_guia;
        this.id_ciudadResidencia = id_ciudadResidencia;
        this.ciudad_residencia = ciudad_residencia;
        this.email = email;
        this.contraseña = contraseña;
        this.idiomas = idiomas;
    }

    public int getId_ciudadResidencia() {
        return id_ciudadResidencia;
    }

    public void setId_ciudadResidencia(int id_ciudadResidencia) {
        this.id_ciudadResidencia = id_ciudadResidencia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre_guia() {
        return nombre_guia;
    }

    public void setNombre_guia(String nombre_guia) {
        this.nombre_guia = nombre_guia;
    }

    public String getApellido_guia_1() {
        return apellido_guia_1;
    }

    public void setApellido_guia_1(String apellido_guia_1) {
        this.apellido_guia_1 = apellido_guia_1;
    }

    public String getApellido_guia_2() {
        return apellido_guia_2;
    }

    public void setApellido_guia_2(String apellido_guia_2) {
        this.apellido_guia_2 = apellido_guia_2;
    }

    public int getValoracion_guia() {
        return valoracion_guia;
    }

    public void setValoracion_guia(int valoracion_guia) {
        this.valoracion_guia = valoracion_guia;
    }

    public String getCiudad_residencia() {
        return ciudad_residencia;
    }

    public void setCiudad_residencia(String ciudad_residencia) {
        this.ciudad_residencia = ciudad_residencia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }
    
    
    
}
