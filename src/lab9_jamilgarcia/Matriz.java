/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab9_jamilgarcia;

import java.util.Random;

/**
 *
 * @author JamilGarcía
 */
public class Matriz {

    static Random r = new Random();

    private int t;
    public int[][] matz;
    public int[] arr1;
    public int[] arr2;

    public Matriz() {

    }

    public Matriz(int t) {
        this.matz = new int[t][t];
        this.arr1 = new int[t];
        this.arr2 = new int[t];
        this.matz = Llenar(matz);
    }

    
    public int[][] Llenar(int[][] matz) {
        //System.out.println("Llenar");
        for (int i = 0; i < matz.length; i++) {
            for (int j = 0; j < matz.length; j++) {
                matz[i][j] = r.nextInt(9);
            }
        }
        Imprimir(matz);
        return matz;
    }

    public int[] SasonN() {
        int[] arr = new int[matz.length];
        for (int i = 0; i < matz.length; i++) {
            for (int j = 0; j < matz.length; j++) {
                if (i == j) {
                    arr[i] = matz[i][j];
                }
            }
        }
        System.out.println("Diagonal");
        ImprimirA(arr);
        return arr;
    }

    public int[] SasonI(int[][] matz) {
        int[] arr = new int[matz.length];
        for (int i = 0; i < matz.length; i++) {
            for (int j = 0; j < matz.length; j++) {
                if (i + j == matz.length-1) {
                    arr[i] = matz[i][j];
                }
            }
        }
        System.out.println("Inversa");
        ImprimirA(arr);
        return arr;
    }

    public void start() {
        arr1 = SasonN();
        arr2 = SasonI(matz);
        int Sarr1 = Suma(arr1);
        System.out.println("Suma Diagonal: " + Sarr1);
        int Sarr2 = Suma(arr2);
        System.out.println("Suma Inversa: " + Sarr2);
        if (Sarr1 > Sarr2) {
            System.out.println("Se Ordenara de manera ascendente");
            OrdenarA(matz);
            Imprimir(OrdenarA(matz));
        } else if (Sarr1 < Sarr2) {
            System.out.println("Se Ordenara de manera descendente");
            OrdenarD(matz);
            Imprimir(OrdenarD(matz));
        } else if (Sarr1 == Sarr2) {
            Imprimir(matz);
        }
    }

    public int Suma(int[] s) {
        int suma = 0;
        for (int i = 0; i < s.length; i++) {
            suma += s[i];
        }
        return suma;
    }

    public int[][] OrdenarA(int[][] matz) {
        int cont = 0;
        int[] arr = new int[matz.length * matz.length];
        for (int i = 0; i < matz.length; i++) {
            for (int j = 0; j < matz.length; j++) {
                arr[cont] = matz[i][j];
                cont++;
            }
        }
//        System.out.println("sout1");
//        ImprimirA(arr);
        sortArray(arr);
        cont = 0;
        for (int i = 0; i < matz.length; i++) {
            for (int j = 0; j < matz.length; j++) {
                matz[i][j] = arr[cont];
                cont++;
            }
        }
//        System.out.println("sout2");
//        ImprimirA(arr);
        return matz;
    }

    public int[] sortArray(int[] temporal) {
        boolean flag = true;
        while(flag){
            flag = false;
            for (int i = 0; i < temporal.length -1; i++) {
                if (temporal[i] > temporal[i+1]){
                    int temp = temporal[i];
                    temporal[i] = temporal[i +1];
                    temporal[i+1] = temp;
                    flag = true;
                }
            }
        }
//        System.out.println("Ordenado:");
//        ImprimirA(temporal);
        return temporal;
    
    }

    public int[][] OrdenarD(int[][] matz) {
        int cont = 0;
        int[] arr = new int[matz.length * matz.length];
        for (int i = 0; i < matz.length; i++) {
            for (int j = 0; j < matz.length; j++) {
                arr[cont] = matz[i][j];
                cont++;
            }
        }
//        System.out.println("sout1");
//        ImprimirA(arr);
        sortArray(arr);
        cont = (arr.length-1);
        for (int i = 0; i < matz.length; i++) {
            for (int j = 0; j < matz.length; j++) {
                matz[i][j] = arr[cont];
                cont--;
            }
        }
//        System.out.println("sout2");
//        ImprimirA(arr);
        return matz;
    }

    public void Imprimir(int[][] matz) {
        System.out.println("Salida: ");
        for (int i = 0; i < matz.length; i++) {
            for (int j = 0; j < matz.length; j++) {
                System.out.print("[" + matz[i][j] + "]");
            }
            System.out.println("");
        }
    }

    public void ImprimirA(int[] a) {
        System.out.println("Salida A:");
        for (int i = 0; i < a.length; i++) {
            System.out.print("[" + a[i] + "]");
        }
        System.out.println("");
    }
}
