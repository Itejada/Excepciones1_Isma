package com.company;

import java.util.Scanner;

public class Ejercicio_2 {
    public static void main(String[] args) {
Scanner scanner= new Scanner(System.in);
        String op;

        int[] partidas={0,0};
        do {
          System.out.println("Quieres jugar ? S|N");
          op = scanner.nextLine().toUpperCase();
          Joc_Dau_Ej2 partida = new Joc_Dau_Ej2();
          int[] par=partida.jugar();

         partidas[0]= (partidas[0] +par[0]);
            partidas[1]= (partidas[1] +par[1]);
            System.out.println(" en total has jugado "+ (partidas[0] + partidas[1])+" partidas\n ganadas: "+partidas[0]+"\n perdidas: "+partidas[1]);


        }while (op.equals("S"));
    }
}
