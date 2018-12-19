package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static javafx.beans.binding.Bindings.when;
import static javafx.scene.input.KeyCode.*;

public class Ejercicio1 {

    public static void main(String[] args) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("d/MM/yyy");
        Persona p1 = new Persona("Arya", Persona.Genere.DONA, LocalDate.parse("25/12/2002",format) );
        Persona p2 = new Persona("Tyrion", Persona.Genere.HOME, LocalDate.parse("12/10/1980",format));
        Persona p3 = new Persona("Cersei", Persona.Genere.DONA, LocalDate.parse("10/01/1984",format));
        Persona p4 = new Persona("Eddard", Persona.Genere.HOME, LocalDate.parse("24/04/1974",format));
        Persona p5 = new Persona("Sansa", Persona.Genere.DONA, LocalDate.parse("24/04/1992",format));
        Persona p6 = new Persona("Jaime", Persona.Genere.HOME, LocalDate.parse("24/04/1979",format));
        Persona p7 = new Persona("Khal", Persona.Genere.HOME, LocalDate.parse("10/08/1979",format));
        Persona p8 = new Persona("Daenerys", Persona.Genere.DONA, LocalDate.parse("12/11/1992",format));

        Persona[] lpers = {p1,p2,p3,p4,p5,p6,p7,p8};
        List<Persona> llista_persones;
        llista_persones = new ArrayList<>(Arrays.asList(lpers));
        Map<Integer,Integer> mapPersones = new HashMap<>();
/***/
        // 1 - Canviar a lambda
        System.out.println("\n1-2");
//        Collections.sort(llista_persones, new Comparator<Persona>() {
//
//            @Override
//            public int compare(Persona o1, Persona o2) {
//                if(o1.getNom().charAt(0) >= o2.getNom().charAt(0)) return 1;
//                else return -1;
//            }
//        });
        Collections.sort(llista_persones,(Persona o1, Persona o2)-> {
            if(o1.getNom().charAt(0) >= o2.getNom().charAt(0)) return 1;
            else return -1;
        } );
/***/

        // 2 - Canviar a Lambda
        System.out.println("\n2-3");

//        for(Persona p: llista_persones) {
//            System.out.println(p);
//        }
        llista_persones.forEach(persona -> System.out.println(persona));

/***/
        // 3 - Canvia a classe anònima
        System.out.println("\n3-4");
//        //ordenació alfabètica inversa del nom
//        llista_persones.sort((o1,o2) -> o2.getNom().compareTo(o1.getNom()));


        Collections.sort(llista_persones, new Comparator<Persona>() {

            @Override
            public int compare(Persona o1, Persona o2) {
                if(o1.getNom().charAt(0) >= o2.getNom().charAt(0)) return 1;
                else return -1;
            }
        });

/***/

        // 4 - Canvia per una crida al mètode, per referència, que hagis creat tu
        System.out.println("\n4-5");

//        for(Persona p: llista_persones) {
//            System.out.println(p);
//        };
        llista_persones.forEach(System.out::println);

/***/

        // 5 - Omplir map. Canviar per un forEach amb lambda
        for(Persona per : llista_persones) {
            mapPersones.put(per.getAge(),1);
        }
        llista_persones.forEach( per -> mapPersones.put(per.getAge(),1));

        // 6 - Canvia per un recorregut forEach amb lambda
//        System.out.println("\n5");
//        for(Map.Entry entry : mapPersones.entrySet()) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }

        mapPersones.forEach((k,v) -> System.out.println(k + " : " + v));


        /* 7 -  Esbrina com s'utilitzen els mètodes de map següents
                map.putIfAbsent
                map.computeIfAbsent
                map.computeIfPresent
             per tal d'afegir correctament la feqrëncia d'edat de les persones.

             Si vols fes-ho primer sense els mètodes anomenats i sense lambdes
             i després amb els mètodes i amb lambdes
*/
        /**llista_persones.forEach(K -> default V computeIfPresent(K key,
                BiFunction<? super K,? super V,? extends V> remappingFunction)) );*/

        /**llista_persones.forEach((k,v) -> if ((v).containsKey(elemento)) m.put(elemento, m.get(elemento) + 1));*/
/*             Exemple de sortida:
                34 anys -> 1
                38 anys -> 1
                39 anys -> 2
                26 anys -> 2
                44 anys -> 1
                15 anys -> 1

         */

        // 8 - llistat de persones DONA amb lambda

        // 9 - Llistat dels dos HOMES més joves

        // 10- Esborrar del llistat les persones entre 30 i 40 anys (amb lambda) "(removeIf() )"
        mapPersones.forEach((k,v) ->llista_persones.replaceAll(per -> {
             per.setNom(null) &&( per.setDataNaixament(LocalDate.parse("01/01/0001", format)));
            return per;
        });
    }


}