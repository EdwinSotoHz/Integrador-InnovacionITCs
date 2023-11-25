package integradorpruebas;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Edwin Salvador Soto Hernández
 */

public class GenerarExpresionBooleana {
    public static int[][] llenarTabla(int[][] tabla, int numBits, String[] salidas) {
        //Datos
        int[] salidasInt = new int[salidas.length];
        for (int i = 0; i < salidasInt.length; i++) {
            salidasInt[i] = Integer.parseInt(salidas[i])-1;
        }
        Arrays.sort(salidasInt);
        
        //Llenar las combinaciones
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < numBits; j++) {
                int division = i / ((int) Math.pow(2, j));
                int valorPosicion = division % 2;
                tabla[i][(numBits)-1-j] = (valorPosicion == 0)   ?   1 : 0 ;
            }
        }
        // LLenar las salidas de la tabla
        for (int i = 0; i < tabla.length; i++) {
            if (Arrays.binarySearch(salidasInt, i) >= 0) {
                tabla[i][numBits] = 1;
            } else {
                tabla[i][numBits] = 0;
            }
        }
        return tabla;
    }
    
    public static void imprimirTabla(int[][] tablaDeVerdad){
        //Datos
        int filas = tablaDeVerdad.length;
        int columnas = tablaDeVerdad[1].length;
        String preposiciones= "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        String[] colores = {
            "\u001B[31m", // rojo
            "\u001B[34m", // azul
            "\u001B[32m", // verde
            "\u001B[35m", // morado
            "\u001B[33m", // amarillo
            "\u001B[36m", // cian
        };
        
        //Imprimir la tabla
        System.out.println("\nLa tabla de verdad es:");
        // Encabezados
        System.out.print("     ");
        for (int i = 0; i <= columnas-1; i++) {
            if (i == columnas-1) {
                System.out.print(colores[i] + "Salida");
            }else{
                System.out.print(colores[i] + preposiciones.charAt(i) + "  ");
            }
        }
        System.out.println();
        //Combinaciones de la tabla
        for (int i = 0; i < filas; i++) {
            if (i<9) {
                System.out.print(" ");
            }
            System.out.print(i+1+"| ");
            for (int j = 0; j <= columnas-1; j++) {
                System.out.print(" " +colores[j] + tablaDeVerdad[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static String generarExpresionBooleana(String[] salidas, int[][] tablaDeVerdad){
        //Datos
        int filas = tablaDeVerdad.length;
        int columnas = tablaDeVerdad[1].length;
        String expresion = "";
        String preposiciones= "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        
        //Obtener las filas con salidas de valor 1 en una matriz auxiliar
        String[][] salidasUno = new String[salidas.length][filas-1];
        int indice = 0;
        for (int i = 0; i < filas; i++) {
            if (tablaDeVerdad[i][columnas-1] == 1) {
                for (int j = 0; j < columnas-1; j++) {
                    salidasUno[indice][j] = Integer.toString(tablaDeVerdad[i][j]);
                }
                indice++;
            }
        }
        
        //Cambiar valores por la letra correspondiente
        for (String[] salidasUno1 : salidasUno) {
            for (int j = 0; j < columnas-1; j++) {
                if ("0".equals(salidasUno1[j])) {
                    salidasUno1[j] = "¬"+preposiciones.charAt(j);
                } else {
                    salidasUno1[j] = ""+preposiciones.charAt(j);
                }
            }
        }
        //Concatear arreglo en una cadena
        for (int i = 0; i < salidasUno.length; i++) {
            for (int j = 0; j < columnas-1; j++) {
                expresion += salidasUno[i][j];
            }
            if (i != salidasUno.length-1) {
                expresion += " + ";
            }
        }
        return expresion;
    }
    
    public static void main(String[] args) {
        //Entrada de datos cantidad de bits 
        Scanner entradaDatos = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de bits: ");
        int numBits = entradaDatos.nextInt();
        
        entradaDatos.nextLine();
        
        //Entrada de salidas con valor 1
        int numSalidas = (int)Math.pow(2, numBits);
        int[][] tabla = new int[numSalidas][numBits+1];
        System.out.print("Ingrese las salidas que son 1 sepadados por comas ("+1+"-"+numSalidas+"): ");
        String[] salidas = entradaDatos.nextLine().replaceAll("[^,0-9]", "").split(",");
        entradaDatos.close();//cerrar captura de datos
        
        /*PROCESOS*/
        tabla = llenarTabla(tabla, numBits,salidas);//Llenar tabla
        
        imprimirTabla(tabla);//imprimimos la tabla generada
        
        System.out.println("\nExpresión booleana: ");
        String expresion = generarExpresionBooleana(salidas, tabla);//Generar expresion booleana
        System.out.println(expresion+"\n");//Mostrar la expresion
    }
    
}
