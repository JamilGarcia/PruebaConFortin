package lab9_jamilgarcia;

import java.util.Random;

/**
 *
 * @author JamilGarcía
 */
public class Figura {

    static Random r = new Random();

    public int t;
    private int[][] matz;
    private int sumaf;
    private int suma;

    public Figura() {

    }

    public Figura(int t) {
        this.matz = new int[t][t];
        this.matz = Llenar(matz);
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

    public int[][] Llenar(int[][] matz) {
        //System.out.println("Llenar");
        for (int i = 0; i < matz.length; i++) {
            for (int j = 0; j < matz.length; j++) {
                matz[i][j] = r.nextInt(8);
            }
        }
        Imprimir(matz);
        return matz;
    }

    public void cacularSuma() {
        sumaf = Sason();
        System.out.println("Suma: " + sumaf);
    }

    public int Sason() {
        int cont = 0;
        for (int i = 0; i < matz.length; i++) {
            for (int j = 0; j < matz.length; j++) {
                if (i == 0) {
                    if (j == 0 || j == (matz.length - 1) / 2 || j == matz.length - 1) {
                        suma += matz[i][j];
                    }
                } else if (i == matz.length - 1) {
                    if (j == 0 || j == (matz.length - 1) / 2 || j == matz.length - 1) {
                        suma += matz[i][j];
                    }
                } else if (i == (matz.length - 1) / 2) {
                    if (j == (matz.length - 1) / 2) {
                        cont--;
                        suma += matz[i][j];
                    }
                } else {
//                    System.out.println("entro con i) " + i);
//                    System.out.println(((matz.length - 1) / 2) - cont);
                    if (j == ((matz.length - 1) / 2) - cont) {
//                        System.out.println("i) " + i);
//                        System.out.println("j) " + j);
//                        System.out.println("[" + matz[i][j] + "]");

                        suma += matz[i][j];
                        matz[i][j] = 9;
                    }
                    if (j == ((matz.length - 1) / 2) + cont) {
//                        System.out.println("i) " + i);
//                        System.out.println("j) " + j);
//
//                        System.out.println("[" + matz[i][j] + "]");
                        suma += matz[i][j];
                        matz[i][j] = 9;
                    }
                }
            }
            if (i < (matz.length / 2)) {
                cont++;
//                System.out.println("suma de cont " + cont);
            } else if (i > (matz.length / 2)) {
                cont--;
//                System.out.println("resta de cont " + cont);
            }

        }
        
        //Imprimir(matz);
        return suma;
    }
}
