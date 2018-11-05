//package com.company;
//
//import java.util.Objects;
//
//public class Lapiz implements Comparable<Lapiz> {
//
//    private int color;
//    private float gruix;
//
//
//    public Lapiz(int _color, float _gruix){
//        gruix=_gruix;
//    }
// //   public Lapiz(){
////        color=2;
////        gruix=0.5f;
////    }
////    public Lapiz(){
////        color=2;
////        gruix=0.6f;
////    }
//
//    public int getColor() {
//        return color;
//    }
//
//    public void setColor(int color) {
//        this.color = color;
//    }
//
//    public float getGruix() {
//        return gruix;
//    }
//
//    public void setGruix(float gruix) {
//        this.gruix = gruix;
//    }
//
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Lapiz lapiz = (Lapiz) o;
//        return color == lapiz.color;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(color);
//    }
//
//
//    @Override
//    public int compareTo(Lapiz o) {
//        if (this.gruix > o.gruix) return 1;
//        else if(this.gruix < o.gruix) return -1;
//        return 0;
//    }
//}
