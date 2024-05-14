package ChessKing;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ChessKing {

    public static void main(String[] args) {
/*
Having an 8x8 char array simulate the move of a chess king.
You must show where it is at all times
My advice is to use a menu
*/      final char VACIO= 'X';
        final char REY = 'O';

        char [][] matriz= new char [8][8];
    
        rellenarMatriz(matriz, VACIO);
        
        int posActualReyX = 0, posAntiguaReyX = 0;
        int posActualReyY = 0, posAntiguaReyY = 0;
        
        matriz[posActualReyX][posActualReyY]= REY;

        Scanner sc = new Scanner (System.in);
        boolean salir = false;
        int opcion; //Guardamos la opcion del usuario
    
        /*
            00 01 02
            10 11 12
            20 21 22
        */
        while (!salir){
            
            mostrarMatriz(matriz);
            
            System.out.println("¿Dónde quires moverte?");
            System.out.println("1. Mover arriba");
            System.out.println("2. Mover arriba-derecha");
            System.out.println("3. Mover derecha");
            System.out.println("4. Mover abajo - derecha");
            System.out.println("5. Mover abajo");
            System.out.println("6. Mover abajo-izquierda");
            System.out.println("7. Mover izquierda");
            System.out.println("8. Mover arriba-izquierda");
            System.out.println("9. Salir");
            
    
            try {
                System.out.println("Escribe una de las opciones");
                opcion = sc.nextInt();

                posAntiguaReyX = posActualReyX;
                posAntiguaReyY = posActualReyY;

                switch (opcion) {
                    case 1:
                        posActualReyX--;
                        break;

                    case 2:
                        posActualReyX--;
                        posActualReyY++;
                        break;

                    case 3:
                        posActualReyY++;
                        break;

                    case 4:
                        posActualReyX++;
                        posActualReyY++;
                        break;

                    case 5:
                        posActualReyX++;
                        break;

                    case 6:
                        posActualReyX++;
                        posActualReyY--;
                        break;

                    case 7:
                        posActualReyY--;
                        break;

                    case 8:
                        posActualReyX--;
                        posActualReyY--;
                        break;

                    case 9:

                        break;
                    default:
                        System.out.println("Solo numeros entre 1 y 9");
                }
                if (estaLimiteMatriz (matriz.length, matriz[0].length, posActualReyX, posActualReyY)){
                 
                matriz[posAntiguaReyX][posAntiguaReyY]= VACIO;
                matriz[posActualReyX][posActualReyY]= REY;
                
                   
                }else{
                    System.out.println("Te sales del tablero");
                    posActualReyX = posAntiguaReyX;
                    posActualReyY = posAntiguaReyY;
                }
                
            }catch (InputMismatchException e) {
                System.out.println("Debes insertar un numero");
                sc.next();
            }
        }
    }
    public static void mostrarMatriz(char[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("");
        }
    }
    public static void rellenarMatriz(char[][] matriz, char simbolo){
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[0].length; j++) {
                    matriz[i][j] = 'X';
                }
            }
    } 
    
    public static boolean estaLimiteMatriz(int longitudFilas, int longitudColumnas, int x, int y) {
    
        return x>= 0 && x< longitudFilas && y>=0 && y <longitudColumnas;//Acá 0 es la primera columna del array
    }

}