package com.company;

import java.io.*;
import java.security.*;
import java.util.Scanner;

public class Ejercicio_1 {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream is = new FileInputStream("C:\\Users\\ismae\\.keystore");

        Scanner scanner=new Scanner(System.in);
    Cifrar c = new Cifrar();

    KeyPair Keys=c.randomGenerate(1024);
        System.out.println("Introduce un texto");
        String texto= scanner.nextLine();
        byte[] textoCifrado= c.encryptData(texto.getBytes() ,Keys.getPublic());

        System.out.println(new String(textoCifrado));
        byte[] textoDescifrado= c.decryptData(textoCifrado,Keys.getPrivate());
        System.out.println(new String(textoDescifrado));
        System.out.println("Formato de la clave privada:  "+ Keys.getPrivate().getFormat()+"\nFormato de la clave publica:  "+Keys.getPublic().getFormat());






    }
}
