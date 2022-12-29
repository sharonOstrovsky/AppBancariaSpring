package com.example.appbancariaspring.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="Cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;
    private String nombre;
    private String apellido;
    private int documento;
    private int edad;
    private String mail;
    private String direccion;
    private String nacionalidad;

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, int documento, int edad, String mail, String direccion, String nacionalidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.edad = edad;
        this.mail = mail;
        this.direccion = direccion;
        this.nacionalidad = nacionalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "Nombre= " + nombre + "\n" +
                "Apellido= " + apellido + "\n" +
                "Documento= " + documento + "\n" +
                "Edad= " + edad + "\n" +
                "Mail= " + mail + "\n" +
                "Direccion= " + direccion + "\n" +
                "Nacionalidad= " + nacionalidad + "\n" +
                '}';
    }
}
