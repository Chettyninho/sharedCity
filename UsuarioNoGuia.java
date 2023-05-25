/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package APP;

/**
 *
 * @author Miguel
 */
public class UsuarioNoGuia {
    //piensa si con un solo usuario es suficiente , es decir si GUIA en verdad vale para los dos usuarios
    int id;
    String dni_user;
    String nombre_user;
    String apellido_user_1;
    String apellido_user_2;
    String ciudad_residencia;
    private String email;
    private String contraseña;
    String idiomas;

    public UsuarioNoGuia() {
    }

    public UsuarioNoGuia(int id, String dni_user, String nombre_user, String apellido_user_1, String apellido_user_2, String ciudad_residencia, String email, String contraseña, String idiomas) {
        this.id = id;
        this.dni_user = dni_user;
        this.nombre_user = nombre_user;
        this.apellido_user_1 = apellido_user_1;
        this.apellido_user_2 = apellido_user_2;
        this.ciudad_residencia = ciudad_residencia;
        this.email = email;
        this.contraseña = contraseña;
        this.idiomas = idiomas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni_user() {
        return dni_user;
    }

    public void setDni_user(String dni_user) {
        this.dni_user = dni_user;
    }

    public String getNombre_user() {
        return nombre_user;
    }

    public void setNombre_user(String nombre_user) {
        this.nombre_user = nombre_user;
    }

    public String getApellido_user_1() {
        return apellido_user_1;
    }

    public void setApellido_user_1(String apellido_user_1) {
        this.apellido_user_1 = apellido_user_1;
    }

    public String getApellido_user_2() {
        return apellido_user_2;
    }

    public void setApellido_user_2(String apellido_user_2) {
        this.apellido_user_2 = apellido_user_2;
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
