package com.company;

import java.util.Scanner;

public class Ejercicio_1 {
    public static void main(String[] args) {

        int[] dados= new int[11];
        int d1,d2;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Cuantas veces deseas tirar?");
        int tiradas= scanner.nextInt();
        for (int i = 0; i <  tiradas ; i++) {
            d1 = (int) (Math.random() * 6) + 1;
            d2 = (int) (Math.random() * 6) + 1;
            dados[d1+d2-2]+=1;
        }
        for (int i = 0; i < dados.length; i++) {
            System.out.println((i+2)+" ha salido "+dados[i]+" veces");
        }

    }
}
