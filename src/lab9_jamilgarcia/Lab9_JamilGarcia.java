package lab9_jamilgarcia;

import java.util.Scanner;

/**
 *
 * @author JamilGarcía
 */
public class Lab9_JamilGarcia {

    static Scanner jg = new Scanner(System.in);

    public static void main(String[] args) {
        //Figura FG = new Figura();
        //XO XO = new XO();
        Matriz MZ = new Matriz();
        char resp = 's';
        while (resp == 's') {

            System.out.println("**************************");
            System.out.println("___________Menu:__________");
            System.out.println("______1) Ejercicio 1______");
            System.out.println("______2) Ejercicio 2______");
            System.out.println("______3) Ejercicio 3______");
            System.out.println("________0) Salida_________");
            System.out.println("**************************");
            System.out.println();
            System.out.println("Ingrese la opcion que desea: ");
            int opcion = jg.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el tamaño de la matriz: ");
                    int tam = jg.nextInt();
                    Figura f = new Figura(tam);
                    f.cacularSuma();
                    break;

                case 2:
                    System.out.println("Ingrese el nombre del jugador 1: ");
                    String nombre1 = jg.nextLine();
                    nombre1 = jg.nextLine();
                    System.out.println("Ingrese el nombre del jugador 2: ");
                    String nombre2 = jg.nextLine();
                    nombre2 = jg.nextLine();
                    
                    XO X = new XO(nombre1, nombre2);
                    X.play();
                    if (X.play() == 1){
                        System.out.println("Ganó: "+ nombre1);
                    }else if (X.play() == 2){
                        System.out.println("Ganó: "+ nombre2);
                    }else{
                        System.out.println("Hubo un empate");
                    }
                    break;

                case 3:
                    System.out.println("Ingrese el tamaño de la matriz");
                    tam = jg.nextInt();
                    Matriz m = new Matriz(tam);
                    m.start(); 
                    break;

                case 0:
                    System.out.println("Gracias por usar el programa <3");
                    resp = 'n';
                    break;

                default:
                    System.out.println("Entrada Invalida");
            }
        }

    }
}
