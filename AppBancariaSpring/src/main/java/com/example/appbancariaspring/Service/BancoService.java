package com.example.appbancariaspring.Service;


import com.example.appbancariaspring.Entity.Banco;
import com.example.appbancariaspring.Entity.Cliente;
import com.example.appbancariaspring.Entity.CuentaBancaria;
import com.example.appbancariaspring.Repository.ClienteRepository;
import com.example.appbancariaspring.Repository.CuentaBancariaRepository;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.Random;


public class BancoService {

    private CuentaBancariaService cuentaServicio;
    private ClienteService clienteServicio;
    private CuentaBancariaRepository cuentaBancariaRepository;
    private ClienteRepository clienteRepository;
    private ApplicationContext context;



    public BancoService() {
        this.clienteServicio = new ClienteService();
        this.cuentaServicio = new CuentaBancariaService();

    }

    public void inicializarRepositorios(ApplicationContext context){
        this.context = context;
        clienteRepository = context.getBean(ClienteRepository.class);
        cuentaBancariaRepository = context.getBean(CuentaBancariaRepository.class);
    }

    public Banco crearBanco(){

        Banco banco = new Banco();
        ArrayList<CuentaBancaria> cuentas = new ArrayList<>();

        while(cuentas.size() != 10){
            Cliente cliente = clienteServicio.crearCliente();
         //   clienteRepository.save(cliente);
            if(esMayorEdad(cliente)){
                CuentaBancaria cuenta = cuentaServicio.crearCuenta(cliente);
                cuenta.setTarjeta(otorgarNumTarjeta());
          //      cuentaBancariaRepository.save(cuenta);
               // tarjetaRepository.save(cuenta.getTarjeta());
                cuentas.add(cuenta);
            }
        }

        banco.setCuentas(cuentas);

        return banco;
    }

    public Banco crearBancoPreArmado(){
        Banco banco = new Banco();
        ArrayList<CuentaBancaria> cuentas = new ArrayList<>();

        Cliente cliente1 = new Cliente("Sharon","Ostrovsky", 39915620, 26,"sharonostro@gmail.com","Boyaca 1853", "Argentina" );
        clienteRepository.save(cliente1);
        Cliente cliente2 = new Cliente("Carlos", "Garcia", 18348704, 56, "carlosgrcia@gmail.com", "calle 123", "Argentina");
        clienteRepository.save(cliente2);
        Cliente cliente3 = new Cliente("Federico", "Lillo", 384789546, 21, "federico@gmail.com", "calle 4563", "Argentina");
        clienteRepository.save(cliente3);
        Cliente cliente4 = new Cliente("Matias", "Perez", 35684567, 29, "matias@hotmail.com", "calle 475", "Argentina" );
        clienteRepository.save(cliente4);
        Cliente cliente5 = new Cliente("Gaston", "Prieto", 27364528, 35, "gaston@gmail.com", "calle 987", "Argentina");
        clienteRepository.save(cliente5);
        Cliente cliente6 = new Cliente("Patricia", "Dascal", 18098700, 57, "patriciadascal@hotmail.com", "calle 534", "Argentina");
        clienteRepository.save(cliente6);
        Cliente cliente7 = new Cliente("Aylen", "Hasman", 40394283, 25, "aylen@gmail.com", "calle 324", "Argentina");
        clienteRepository.save(cliente7);
        Cliente cliente8 = new Cliente("Alex", "Harazski", 43233454,23,"alex@gmail.com", "calle 533", "Argentina" );
        clienteRepository.save(cliente8);
        Cliente cliente9 = new Cliente("Nicolas", "Garbiero", 20348563, 34, "nicolas@hotmail.com", "calle 434", "Argentina");
        clienteRepository.save(cliente9);
        Cliente cliente10 = new Cliente("Alejandra", "Flons", 17345436, 65, "alejandra@hotmail.com", "calle 333", "Argentina");
        clienteRepository.save(cliente10);

        CuentaBancaria cuenta1 = new CuentaBancaria("sharon", "sharon", cliente1, "1111111111111111", 100000);
        cuentaBancariaRepository.save(cuenta1);
        CuentaBancaria cuenta2 = new CuentaBancaria("carlos", "carlos", cliente2, "2222222222222222", 150000);
        cuentaBancariaRepository.save(cuenta2);
        CuentaBancaria cuenta3 = new CuentaBancaria("federico", "federico", cliente3, "3333333333333333", 300000 );
        cuentaBancariaRepository.save(cuenta3);
        CuentaBancaria cuenta4 = new CuentaBancaria("m", "m", cliente4, "4444444444444444", 20000);
        cuentaBancariaRepository.save(cuenta4);
        CuentaBancaria cuenta5 = new CuentaBancaria("g", "g", cliente5, "5555555555555555", 150000);
        cuentaBancariaRepository.save(cuenta5);
        CuentaBancaria cuenta6 = new CuentaBancaria("p", "p", cliente6, "6666666666666666", 50000);
        cuentaBancariaRepository.save(cuenta6);
        CuentaBancaria cuenta7 = new CuentaBancaria("aylen", "aylen", cliente7, "7777777777777777", 40000);
        cuentaBancariaRepository.save(cuenta7);
        CuentaBancaria cuenta8 = new CuentaBancaria("alex","alex", cliente8, "8888888888888888", 60000 );
        cuentaBancariaRepository.save(cuenta8);
        CuentaBancaria cuenta9 = new CuentaBancaria("n", "n", cliente9, "9999999999999999", 70000);
        cuentaBancariaRepository.save(cuenta9);
        CuentaBancaria cuenta10 = new CuentaBancaria("a", "a", cliente10, "1010101010101010", 10000);
        cuentaBancariaRepository.save(cuenta10);

        cuentas.add(cuenta1);
        cuentas.add(cuenta2);
        cuentas.add(cuenta3);
        cuentas.add(cuenta4);
        cuentas.add(cuenta5);
        cuentas.add(cuenta6);
        cuentas.add(cuenta7);
        cuentas.add(cuenta8);
        cuentas.add(cuenta9);
        cuentas.add(cuenta10);

        banco.setCuentas(cuentas);



        return banco;

    }


    public void menu(Banco banco){

        boolean salirDelMenuBanco = false;

        System.out.println("");
        System.out.println("----------BIENVENIDO/A AL BANCO----------");
        System.out.println("");

            do{
                System.out.println("MENU BANCO");
                System.out.println("1. Ingresar a cuenta");
                System.out.println("2. Registrar cuenta nueva");
                System.out.println("3. Salir del banco");
                System.out.print("Elija una opcion:");
                int opcion = librerias.Validaciones.validarIngresoNumeroEnero();

                switch (opcion){
                    case 1:
                        cuentaServicio.ingresarACuenta(cuentaBancariaRepository);
                        break;
                    case 2:
                        registrarse(banco);
                        break;
                    case 3:
                        salirDelMenuBanco = true;
                        break;
                    default:
                        System.out.println("opcion no valida");
                }
            }while(!salirDelMenuBanco);
        System.out.println("");
        System.out.println("----------VUELVA PRONTO----------");
        System.out.println("");

    }


    private void registrarse(Banco banco){
        System.out.println("");
        System.out.println("----------REGISTRARSE----------");
        System.out.println("");

        ArrayList<CuentaBancaria> cuentasAux = new ArrayList<>();
        Cliente cliente = clienteServicio.crearCliente();

        if(!esMayorEdad(cliente)){
            System.out.println("Lo siento, debe ser mayor de edad para crear una cuenta");
        }else{
            CuentaBancaria cuenta = cuentaServicio.crearCuenta(cliente);
            cuenta.setTarjeta(otorgarNumTarjeta());
            clienteRepository.save(cliente);
            cuentaBancariaRepository.save(cuenta);
            cuentasAux = banco.getCuentas();
            cuentasAux.add(cuenta);
            banco.setCuentas(cuentasAux);
        }


        System.out.println("");
        System.out.println("----------CUENTA REGISTRADA----------");
        System.out.println("");
    }


    private boolean esMayorEdad(Cliente cliente){
        int edad = cliente.getEdad();
        return edad >= 18;
    }




    public String crearNumeroTarjeta(){
        int numeros;
        Random numRandom = new Random();
        String resultado = "";
        String aux;

        for(int i=0; i<16; i++){

            numeros = numRandom.nextInt(9);
            //3413123123123123
            aux = String.valueOf(numeros);
            resultado = resultado + aux;
        }
        return resultado;
    }

    public String otorgarNumTarjeta(){
        ArrayList<CuentaBancaria> listaUsuarios = new ArrayList<>();
        listaUsuarios.addAll(cuentaBancariaRepository.findAll());
        String numeroNuevo;
        boolean validador;
        do{
            numeroNuevo = crearNumeroTarjeta();
            validador = false;
            for (CuentaBancaria user: listaUsuarios) {
                if(user.getTarjeta().equals(numeroNuevo)){
                    validador = true;
                    break;
                }
            }
        }while(validador);
        return numeroNuevo;
    }
}


