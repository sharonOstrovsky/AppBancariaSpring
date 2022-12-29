package com.example.appbancariaspring.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="CuentaBancaria")
public class CuentaBancaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cuenta;
    private String usuario;
    private String clave;
    @OneToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    private String tarjeta;
    private double saldo;


    public CuentaBancaria() {
        this.saldo = 0;
    }

    public CuentaBancaria(String usuario, String clave, Cliente cliente, String tarjeta, double saldo) {
        this.usuario = usuario;
        this.clave = clave;
        this.cliente = cliente;
        this.tarjeta = tarjeta;
        this.saldo = saldo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "usuario='" + usuario + '\'' +
                ", clave='" + clave + '\'' +
                ", cliente=" + cliente +
                ", tarjeta=" + tarjeta +
                ", saldo=" + saldo +
                '}';
    }
}
