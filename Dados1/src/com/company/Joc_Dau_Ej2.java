package com.company;

public class Joc_Dau_Ej2 {
    private Dau_Ej2 dau1;
    private Dau_Ej2 dau2;
    private Dau_Ej2 dau3;

    Joc_Dau_Ej2(){
       this.dau3=new Dau_Ej2();
       this.dau2=new Dau_Ej2();
       this.dau1=new Dau_Ej2();
    }

    public int[] jugar(){

        dau1.tirar();
        dau1.valor=dau1.retornarValor();
        dau2.tirar();
        dau2.valor=dau2.retornarValor();
        dau3.tirar();
        dau3.valor=dau3.retornarValor();
        dau1.imprimir(dau1.valor,1);
        dau2.imprimir(dau2.valor,2);
        dau3.imprimir(dau3.valor,3);

        System.out.println("Dau1: "+dau1.valor +" Dau2: "+ dau2.valor +" Dau3: "+dau3.valor);

        int[] partidas={0,0};

        if (dau1.valor == dau2.valor && dau2.valor ==dau3.valor && dau1==dau3){
            System.out.println("As ganado!!");
            partidas[0]= +1;
        }else {
            System.out.println("Lo siento has perdido");
            partidas[1]= +1;
        }



        return partidas;

    }

}
