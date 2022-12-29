package com.example.appbancariaspring.Service;

//import Entity.Cliente;

import com.example.appbancariaspring.Entity.Cliente;
import org.springframework.stereotype.Service;


public class ClienteService {


    public Cliente crearCliente(){
        Cliente cliente = new Cliente();

        System.out.println("");
        System.out.println("----------FORMULARIO----------");
        System.out.println("");

        System.out.print("Nombre: ");
        cliente.setNombre(librerias.Validaciones.validarIngresoCadena());
        System.out.print("Apellido: ");
        cliente.setApellido(librerias.Validaciones.validarIngresoCadena());
        System.out.print("DNI: ");
        cliente.setDocumento(librerias.Validaciones.validarIngresoNumeroEnero());
        System.out.print("Edad: ");
        cliente.setEdad(librerias.Validaciones.validarIngresoNumeroEnero());
        System.out.print("Email: ");
        cliente.setMail(librerias.Validaciones.validarIngresoCadenaAlfanumerica());
        System.out.print("Direccion: ");
        cliente.setDireccion(librerias.Validaciones.validarIngresoCadenaAlfanumerica());
        System.out.print("Nacionalidad: ");
        cliente.setNacionalidad(librerias.Validaciones.validarIngresoCadena());

        System.out.println("");
        System.out.println("----------FIN FORMULARIO----------");
        System.out.println("");

        return cliente;
    }



}
