package com.example.appbancariaspring.Service;



import com.example.appbancariaspring.Entity.Cliente;
import com.example.appbancariaspring.Entity.CuentaBancaria;
import com.example.appbancariaspring.Repository.CuentaBancariaRepository;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.*;


public class CuentaBancariaService {



    public CuentaBancaria crearCuenta(Cliente cliente){
        String clave;
        String confirmClave;
        boolean claveConfirmada = false;
        CuentaBancaria cuenta = new CuentaBancaria();

        System.out.println("Ingrese el nombre de usuario: ");
        String usuario = librerias.Validaciones.validarIngresoCadenaAlfanumerica();

        do{

                System.out.println("Ingrese la constraseña: ");
                clave = librerias.Validaciones.validarIngresoCadenaAlfanumerica();
                System.out.println("Confirme la contraseña: ");
                confirmClave = librerias.Validaciones.validarIngresoCadenaAlfanumerica();
                if(!clave.equals(confirmClave)){
                    System.out.println("las contraseñas no coinciden");
                }else{
                    claveConfirmada = true;
                }

        }while(!claveConfirmada);

        cuenta.setCliente(cliente);
        cuenta.setClave(clave);
        cuenta.setUsuario(usuario);



        return cuenta;

    }



    public void ingresarACuenta( CuentaBancariaRepository cuentaBancariaRepository){
        boolean ingreso = false;

        System.out.println("");
        System.out.println("----------");
        System.out.println("");

        System.out.print("Usuario: ");
        String usuario = librerias.Validaciones.validarIngresoCadenaAlfanumerica();
        System.out.print("Contraseña: ");
        String clave = librerias.Validaciones.validarIngresoCadenaAlfanumerica();

        CuentaBancaria cuenta = encontrarEnBD(usuario, cuentaBancariaRepository);

        if(cuenta != null){
            if( !usuario.equals( cuenta.getUsuario() )  || !clave.equals( cuenta.getClave() ) ){
                System.out.println("clave o contraseña incorrecta, vulva a intentarlo");
                System.out.println("");
                System.out.println("----------");
                System.out.println("");
            }else{
                System.out.println("");
                System.out.println("BIENVENIDO "+ cuenta.getCliente().getNombre() + " " + cuenta.getCliente().getApellido());
                ingreso = true;
            }
        }else{
            System.out.println("usuario no encontrado");
        }

        if(ingreso){
            menuCuentas(cuenta, cuentaBancariaRepository);
        }

    }


    public void menuCuentas(CuentaBancaria cuenta, CuentaBancariaRepository cuentaBancariaRepository){
        boolean cerrarSesion = false;
        int opcionElegida;
        do{
            System.out.println("");
            System.out.println("¿Que desea realizar? ");
            System.out.println("1. Consultar Saldo");
            System.out.println("2. Ingresar Dinero");
            System.out.println("3. Retirar Dinero");
            System.out.println("4. Tranferencia");
            System.out.println("5. Consultar Datos de la cuenta");
            System.out.println("6. Cerrar Sesion");

            opcionElegida = librerias.Validaciones.validarIngresoNumeroEnero();

            switch(opcionElegida){
                case 1:
                    System.out.println("");
                    System.out.println("----------CONSULTAR SALDO----------");
                    System.out.println("");

                    consultarSaldo(cuenta);

                    System.out.println("");
                    System.out.println("----------FIN CONSULTAR SALDO----------");
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("");
                    System.out.println("----------INGRESAR DINERO----------");
                    System.out.println("");

                    System.out.print("¿Cuanto dinero deseas ingresar? ");
                    double dineroIngresar = librerias.Validaciones.validarIngresoNumeroDouble();
                    ingresarDinero(cuenta, dineroIngresar, cuentaBancariaRepository);

                    System.out.println("");
                    System.out.println("----------FIN INGRESAR DINERO----------");
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("");
                    System.out.println("----------RETIRAR DINERO----------");
                    System.out.println("");

                    System.out.print("¿Cuanto dinero desea retirar? ");
                    double dineroRetirar = librerias.Validaciones.validarIngresoNumeroDouble();
                    retirarDinero(cuenta, dineroRetirar, cuentaBancariaRepository);

                    System.out.println("");
                    System.out.println("----------FIN RETIRAR DINERO----------");
                    System.out.println("");
                    break;
                case 4:
                    System.out.println("");
                    System.out.println("----------TRANFERENCIA----------");
                    System.out.println("");

                    tranferencia(cuenta, cuentaBancariaRepository);

                    System.out.println("");
                    System.out.println("----------FIN TRANFERENCIA----------");
                    System.out.println("");
                    break;
                case 5:
                    System.out.println("");
                    System.out.println("----------CONSULTAR DATOS----------");
                    System.out.println("");

                    consultarDatosCuenta(cuenta, cuentaBancariaRepository);

                    System.out.println("");
                    System.out.println("----------CONSULTAR DATOS----------");
                    System.out.println("");
                    break;
                case 6:
                    cerrarSesion = true;
                    System.out.println("");
                    System.out.println("----------SESION CERRADA----------");
                    System.out.println("");
                    break;
                default:
                    System.out.println("");
                    break;
            }
        }while(!cerrarSesion);


    }


    private void consultarSaldo(CuentaBancaria cuenta){
        String nombre = cuenta.getCliente().getNombre();
        String apellido = cuenta.getCliente().getApellido();
        double saldo = cuenta.getSaldo();

        System.out.println("Cuenta " + nombre + " " + apellido);
        System.out.println("Saldo: " + saldo);
    }


    private void retirarDinero(CuentaBancaria cuenta, double dinero, CuentaBancariaRepository cuentaBancariaRepository){
        double saldo = cuenta.getSaldo();
        double nuevoSaldo;
        if(saldo >= dinero){
            nuevoSaldo = saldo - dinero;
            cuenta.setSaldo(nuevoSaldo);
            cuentaBancariaRepository.save(cuenta);
        }else{
            System.out.println("Saldo insuficiente");
        }
    }


    private void ingresarDinero(CuentaBancaria cuenta, double dinero, CuentaBancariaRepository cuentaBancariaRepository){
        double saldo = cuenta.getSaldo();
        double nuevoSaldo = saldo + dinero;
        cuenta.setSaldo(nuevoSaldo);

        cuentaBancariaRepository.save(cuenta);
    }


    private void tranferencia(CuentaBancaria cuenta, CuentaBancariaRepository cuentaBancariaRepository){
        double saldo = cuenta.getSaldo();
        double nuevoSaldo;

        System.out.print("Ingrese el nombre de usuario al que desea transferir: ");
        String usuarioATrasferir = librerias.Validaciones.validarIngresoCadenaAlfanumerica();
        //CuentaBancaria cuentaATrasferir = encontrarCuentaPorUsuario(cuentas, usuarioATrasferir);
        CuentaBancaria cuentaATrasferir = encontrarEnBD(usuarioATrasferir, cuentaBancariaRepository);
        System.out.println("Su saldo actual es: " + saldo);
        System.out.println("¿Cuanto dinero quiere enviar?");
        double dinero = librerias.Validaciones.validarIngresoNumeroDouble();

        if(saldo < dinero){
            System.out.println("saldo insuficiente");
        }else{
            ingresarDinero(cuentaATrasferir, dinero, cuentaBancariaRepository);
            retirarDinero(cuenta, dinero, cuentaBancariaRepository);

            nuevoSaldo = cuenta.getSaldo();

            System.out.println("");
            System.out.println("TRANSFERENCIA REALIZADA");
            System.out.println("Su saldo actual es: " + nuevoSaldo);
            System.out.println("");
        }

    }

    private void consultarDatosCuenta(CuentaBancaria cuenta, CuentaBancariaRepository cuentaBancariaRepository){
        String nombre = cuenta.getCliente().getNombre();
        String apellido = cuenta.getCliente().getApellido();
        String tarjeta = cuenta.getTarjeta();
        double saldo = cuenta.getSaldo();
        System.out.println("Titular: " + nombre + apellido);
        System.out.println("Numero de Tarjeta: " + tarjeta);
        System.out.println("Saldo: " + saldo);
    }


    private CuentaBancaria encontrarCuentaPorUsuario(ArrayList<CuentaBancaria> cuentas,String usuarioBuscado){
        String usuarioCliente;
        for (CuentaBancaria clientes : cuentas) {
            usuarioCliente = clientes.getUsuario();
            if(usuarioCliente.equalsIgnoreCase(usuarioBuscado)){
                return clientes;
            }
        }
        return null;

    }

    private CuentaBancaria encontrarEnBD(String usuarioBuscado, CuentaBancariaRepository cuentaBancariaRepository){
        List<CuentaBancaria> cuentas = cuentaBancariaRepository.findAll();
        String usuarioCliente;
        for (CuentaBancaria clientes : cuentas) {
            usuarioCliente = clientes.getUsuario();
            if(usuarioCliente.equalsIgnoreCase(usuarioBuscado)){
                return clientes;
            }
        }
        return null;
    }




}
