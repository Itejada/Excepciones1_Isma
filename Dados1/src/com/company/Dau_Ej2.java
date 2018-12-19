package com.company;

public class Dau_Ej2 {
    int valor;


    public void tirar(){
        valor= (int) (Math.random() * 6) + 1;

}
    public String imprimir(int cara, int numDado){

        String lineaImpresion="El "+numDado+" dado ha salido: "+cara;

        return lineaImpresion;
    }
    public int retornarValor(){
        return valor;
    }

}
