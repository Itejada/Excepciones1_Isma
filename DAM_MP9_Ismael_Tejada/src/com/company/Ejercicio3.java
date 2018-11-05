package com.company;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\Users\\ismae\\OneDrive\\Escritorio\\textamagat");
        byte[] textenbytes = Files.readAllBytes(path);
//        FileReader textAmagat= new FileReader("C:\\Users\\ismae\\OneDrive\\Escritorio\\textamagat");
//        BufferedReader bufferedReader= new BufferedReader(textAmagat);
        Scanner scanner = new Scanner(System.in);
//        String text = bufferedReader.readLine();
//         byte[] datas= text.getBytes("UTF8");
        System.out.println(textenbytes);
        String[] contraseñas=dropearContraseña();

        int contador=0;
        boolean repetir= false;
        do {
            repetir=false;
            SecretKey pass2 = passwordKeyGeneration(contraseñas[contador], 128);

            byte[] decriptada = decryptData(pass2, textenbytes);

            try {
                System.out.println(new String(decriptada));
            } catch (Exception IO) {
                System.out.println("contraseña incorrecta");
                repetir=true;
                contador+=1;
            }
        }while (repetir);
        System.out.println("\n\n\nLa contraseña es: " +contraseñas[contador]);

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

    public static String[] dropearContraseña() throws IOException {
        File file = new File("C:\\Users\\ismae\\OneDrive\\Escritorio\\documento.txt");
        FileReader fileReader=new FileReader("C:\\Users\\ismae\\OneDrive\\Escritorio\\documento.txt");
        BufferedReader buff= new BufferedReader(fileReader);

        String[] contraseñas= new String[(int)file.length()];

        for (int i = 0; i <(int)file.length(); i++) {
            contraseñas[i]=buff.readLine();
        }


        return contraseñas;
    }

}