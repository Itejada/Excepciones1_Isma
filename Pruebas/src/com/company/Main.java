package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ClientAccountException {
        Client client= new Client("a","a","1a");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vienvenido al ejercicio de Excepciones\n *-*-*-*-*-*-*");

        System.out.println("Inserte el nombre");
        client.setNom(scanner.nextLine());

        System.out.println("Inserte el apellido");
        client.setCognoms(scanner.nextLine());

        System.out.println("Inserte el DNI");
        client.setDNI(scanner.nextLine());

    }
}
