package com.company;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String text = "Ejercicio2";
        byte[] datas= text.getBytes();

        System.out.print("Introduce la contraseña para cifrar: ");
        SecretKey pass=passwordKeyGeneration(scanner.nextLine(),128);
        byte[] encriptada= encryptData(pass,datas);
        System.out.println(new String(encriptada));

        boolean repetir= false;
        do {
            repetir=false;
            System.out.print("Para desencriptar introduzca contraseña: ");
            SecretKey pass2 = passwordKeyGeneration(scanner.nextLine(), 128);

            byte[] decriptada = decryptData(pass2, encriptada);

            try {
                System.out.println(new String(decriptada));
            } catch (Exception IO) {
                System.out.println("contraseña incorrecta");
                repetir=true;
            }
        }while (repetir);
    }


    public static byte[] encryptData(SecretKey sKey, byte[] data) {
        byte[] encryptedData = null;
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, sKey);
            encryptedData =  cipher.doFinal(data);
        } catch (Exception  ex) {
            System.err.println("Error xifrant les dades: " + ex);
        }
        return encryptedData;
    }


    public static byte[] decryptData(SecretKey sKey, byte[] data) {
        byte[] decryptedData = null;
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, sKey);
            decryptedData =  cipher.doFinal(data);
        } catch (Exception  ex) {
            System.err.println("Error al descifrar: " + ex);
        }
        return decryptedData;
    }

    // **************************************************************************** //
    public static SecretKey passwordKeyGeneration(String text, int keySize) {
        SecretKey sKey = null;
        if ((keySize == 128) || (keySize == 192) || (keySize == 256)) {
            try {
                byte[] data = text.getBytes("UTF-8");
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte[] hash = md.digest(data);
                byte[] key = Arrays.copyOf(hash, keySize / 8);
                sKey = new SecretKeySpec(key, "AES");
            } catch (Exception ex) {
                System.err.println("Error generant la clau:" + ex);
            }
        }
        return sKey;
    }

}