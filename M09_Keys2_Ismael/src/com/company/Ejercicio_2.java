package com.company;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.*;
import java.security.*;
import java.security.cert.*;
import java.security.cert.Certificate;
import java.util.Enumeration;
import java.util.Scanner;

import static com.company.Cifrar.keygenKeyGeneration;

public class Ejercicio_2 {


    //TODO |  te lo dejare todo ordenado para que te sea más facil de corregir

    public static void main(String[] args) throws IOException, KeyStoreException, CertificateException, NoSuchAlgorithmException, UnrecoverableEntryException {
        Cifrar c = new Cifrar();
//        Scanner scanner = new Scanner(System.in);
//        FileInputStream is = new FileInputStream("C:\\Users\\ismae\\.keystore");
//        /** Es importante especificar el tipo de tu key store (asegurate de que coinciden) */
//        KeyStore ks = KeyStore.getInstance("JCEKS");
//        String password = "usuari";
//        char[] passwd = password.toCharArray();
//        ks.load(is, passwd);
//        String alias = "mykey";
//
//        /* **************** Primera parte (Prints) **********************************/
//        /** Para obtener el tipo */
//        System.out.println("->Tipo keystore: " + ks.getType());
//        /** Para obtener el tamaño */
//        System.out.println("->Tamaño keystore: " + ks.size());
//        /** Para obtener los alias*/
//        Enumeration<String> enumeration= ks.aliases();
//        System.out.println("->Alias: ");
//        /** Mientras haya elementos en enumeration sera true */
//        while(enumeration.hasMoreElements()){
//                    /** Siguiente elemento en enummeration*/
//            System.out.println("\t ··> "+enumeration.nextElement());
//        }
//        /** Para obtener los certidicados*/
//           System.out.println("->Certificado: "+ ks.getCertificate(alias));
//        /** Para obtener algoritmo*/
//        System.out.println("->Algoritmo: " + ks.getKey(alias, passwd).getAlgorithm());
//
//        /* ******************** Segunda parte (setEntry)************************ */
//        KeyStore.ProtectionParameter protParam = new KeyStore.PasswordProtection(passwd);
//
//        SecretKey sKey = keygenKeyGeneration(128);
//        KeyStore.SecretKeyEntry skEntry = new KeyStore.SecretKeyEntry(sKey);
//        /** Creamos una nueva key para el keystore*/
//        System.out.println("introduce el nombre de la nueva key");
//        ks.setEntry(scanner.nextLine(), skEntry, protParam);
//        try (FileOutputStream fos = new FileOutputStream("C:\\Users\\ismae\\.keystore")) {
//          ks.store(fos, passwd);
//        }
//
//        /* *************** Tercera parte (.cer) ******************************* */
//
//        FileInputStream fis = new FileInputStream("C:\\Users\\ismae\\jordi.cer");
//        BufferedInputStream bis = new BufferedInputStream(fis);
//
//        CertificateFactory cf = CertificateFactory.getInstance("X.509");
//        /**Mientras este obtenible  */
//        while (bis.available() > 0) {
//            Certificate cert = cf.generateCertificate(bis);
//            PublicKey publicKey = cert.getPublicKey();
//            System.out.println(publicKey);
//        }
//
//        /* ***************** Cuarta parte (Extraer pKey) ********************* */
//
//        Certificate cert = ks.getCertificate("asimetrica");
//
//        System.out.println(cert.getPublicKey());

//        /* ****************** 4.2 encryptWrappedData ************************* */

        KeyPair keyPair= c.randomGenerate(1024);
        byte[] data="hola".getBytes();
        byte[][] datacript= encryptWrappedData(data,keyPair.getPublic());
        System.out.println(datacript);
        System.out.println(new String(decryptWrappedData(datacript, keyPair.getPrivate())));






    }


public static byte[][] encryptWrappedData(byte[] data, PublicKey pub) {
            byte[][] encWrappedData = new byte[2][];
            try {
             /** Genera una key simetrica  del tamaño 128 bits*/
                KeyGenerator kgen = KeyGenerator.getInstance("AES");
                kgen.init(128);
             /** Crear una Secret key*/
                SecretKey sKey = kgen.generateKey();
             /** Crea el cifrado de tipo AES */
                Cipher cipher = Cipher.getInstance("AES");
             /** Inicializa el encriptado con la secret key*/
                cipher.init(Cipher.ENCRYPT_MODE, sKey);
             /** Encripta los datos*/
                byte[] encMsg = cipher.doFinal(data);
             /** Defines el tipo de cifrado(y el cifrado en bloque ECB) junto al pading*/
                cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
             /** Encripta la Publickey*/
                cipher.init(Cipher.WRAP_MODE, pub);
             /** En la primera posicion del Array va el mensage y en la segunda la key encriptada*/
                byte[] encKey = cipher.wrap(sKey);
                encWrappedData[0] = encMsg;
                encWrappedData[1] = encKey;
            } catch (Exception  ex) {
                System.err.println("Ha succeït un error xifrant: " + ex);
            }
            return encWrappedData;
        }

    public static byte[] decryptWrappedData ( byte[][] datacript, PrivateKey priv){//Aqui recibiremos el texto encriptado y nuestra private key
        byte[] decMsg = null;
        try {
            Cipher cipher;

            cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

            cipher.init(Cipher.UNWRAP_MODE, priv);
            SecretKey decKey = (SecretKey) cipher.unwrap(datacript[1], "AES", Cipher.SECRET_KEY);
            cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, decKey);
            decMsg = cipher.doFinal(datacript[0]);

        } catch (Exception ex) {
            System.err.println("Ha succeït un error xifrant: " + ex);
        }
        return decMsg;
    }


}
