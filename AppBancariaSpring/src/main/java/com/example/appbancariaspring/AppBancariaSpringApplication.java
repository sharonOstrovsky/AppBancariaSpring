package com.example.appbancariaspring;

import com.example.appbancariaspring.Entity.Banco;
import com.example.appbancariaspring.Service.BancoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AppBancariaSpringApplication {


    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(AppBancariaSpringApplication.class, args);
        //BancoService bancoService = (BancoService) context.getBean("bancoService");
/*
       ClienteRepository repository = context.getBean(ClienteRepository.class);
        CuentaBancariaRepository repositorycuenta = context.getBean(CuentaBancariaRepository.class);
       Cliente cliente = new Cliente("sharon", "ostrovsky", 39915620, 26, "sharon@gmail.com", "calle 1234", "Argentina");

       repository.save(cliente);
        System.out.println("Encontrar");
        System.out.println("Total de clientes es : "+ repository.count());
        System.out.println("------------------");
        System.out.println(repository.findAll());

        CuentaBancaria cuenta1 = new CuentaBancaria("sharon", "sharon", cliente, null, 100000);
        repositorycuenta.save(cuenta1);
        System.out.println(repositorycuenta.findAll());
*/
        BancoService bancoService = new BancoService();
        bancoService.inicializarRepositorios(context);
        Banco bancoPreArmado = bancoService.crearBancoPreArmado();
        bancoService.menu(bancoPreArmado);

        //System.out.println("Encontrar");
        //System.out.println("Total de bancos es : "+ bancoRepository.count());
        //System.out.println("------------------");
       // bancoService.menu(bancoPreArmado);
        //BancoService servicoBanco = new BancoService();


        //bancoService.crearBanco();
    }

}

