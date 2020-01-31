package lab9_jamilgarcia;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author JamilGarcía
 */
public class XO {

    static Random r = new Random();
    static Scanner jg = new Scanner(System.in);

    private int tam;
    private char[][] matz;
    private String nombre1;
    private String nombre2;
    private boolean Validacion;
    private String CoorJ1;
    private String CoorJ2;

    public XO() {
        tam = 3;
    }

    public XO(String nombre1, String nombre2) {
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.matz = new char[tam][tam];
        matz = Llenar(matz);
        Validacion = true;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public char[][] Llenar(char[][] matz) {
        //System.out.println("Llenar");
        for (int i = 0; i < matz.length; i++) {
            for (int j = 0; j < matz.length; j++) {
                matz[i][j] = ' ';
            }
        }
        Imprimir(matz);
        return matz;
    }

    public void Imprimir(char[][] matz) {
        System.out.println("Salida: ");
        for (int i = 0; i < matz.length; i++) {
            for (int j = 0; j < matz.length; j++) {
                System.out.print("[" + matz[i][j] + "]");
            }
            System.out.println("");
        }
    }

    public int play() {
        int[] temp1 = new int [9];
        int[] temp2 = new int [9];
        while (Validacion == true) {
            int cont = 0;
            System.out.println("Turno de " + nombre1);
            System.out.println("Ingrese las coordenadas: ");
            CoorJ1 = jg.next();
            int[] Coor = SacarCoor(CoorJ1);
            cont++;
            temp1 = Coor;
            Imprimir(MovimientoJ1(Coor));
            System.out.println("Turno de " + nombre2);
            System.out.println("Ingrese las coordenadas: ");
            CoorJ2 = jg.next();
            Coor = SacarCoor(CoorJ2);
            cont++;
            temp2 = Coor;
            Imprimir(MovimientoJ2(Coor));
            Validacion = Ganar(matz,temp1,temp2);
            if (cont > 9){
            System.out.println("Salida de emergencia: Oprima 1 para salir, si no Oprima 2");
            int SalidaE = jg.nextInt();
                if (SalidaE == 1) {
                    Validacion = false;
                }
            }
        }
        return 3;
    }

    public boolean Ganar (char[][] m, int[] temp1, int[] temp2){
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                //if (m[i][j] ==)
            }
        }
        return false;
    }
    public char[][] MovimientoJ1(int[] Coor){
        for (int i = 0; i < Coor.length; i++) {
            matz[Coor[1]][Coor[2]] = 'X';
        }
        return matz;
    }
    
    public char[][] MovimientoJ2(int[] Coor){
        for (int i = 0; i < Coor.length; i++) {
            matz[Coor[1]][Coor[2]] = 'X';
        }
        return matz;
    }
    
    public int[] SacarCoor(String c) {
        char h;
        boolean r = false;
        int[] e = new int[2];
        int con = 0;
        for (int i = 0; i < c.length(); i++) {
            h = c.charAt(i);
            if (i == 0 && h == '(') {
                r = true;
            }
            if (r == true && h != ',') {
                for (int j = i; h == ','; j++) {
                    e[1] += h;
                    con++;
                    h = c.charAt(j);
                }
                for (int j = con; h == ')' && j < c.length(); j++) {
                    e[2] += h;
                    h = c.charAt(j);
                }
            } else if (r == true && h == ',') {
                r = false;
            }
        }
        if (r == true){
            return e;
        }else{
            return e;
        }
    }
}
