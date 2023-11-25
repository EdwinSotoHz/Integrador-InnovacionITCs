/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.itsoeh.decimalBinario;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Programa de Decimal a Binario 
 * @author karenxc
 */
public class decimalABinario {
 private static long numeroDecimal;

    public static void main(String[] args) {
        Scanner decimal = new Scanner(System.in);

            // Solicitud del número decimal
            System.out.println("Ingrese el número decimal entero positivo o negativo RANGO 64 bits [-1024, 1024]: ");
            String numeroD = decimal.nextLine();

            // Convierte la variable a un número de tipo long 
            numeroDecimal = Long.parseLong(numeroD);

            // Valida el rango solicitado
            if (numeroDecimal >= -1024 && numeroDecimal <= 1024) {
                if (numeroDecimal >= 0) {
                    // Impresión del número convertido en caso de ser positivo 
                    System.out.println("El número convertido a binario es: " + decimalABinario());
                } else {
                    //Impresión del número en caso de ser negativo 
                    System.out.println("Complemento a 1: " + complementoAUno());
                    System.out.println("Complemento a 2: " + complementoADos());
                }
            //Excepción en caso de no encontrase en el rango solicitado
            } else {
                 System.out.println("Error: Formato no válido" );
            }
        // Cerrar el scaneo 
        decimal.close(); 
        
    }

    public static String decimalABinario() {
        String binario = "";
        // Convetir decimal a valor absoluto 
        long numero = Math.abs(numeroDecimal);

        if (numero == 0) {
            return "0";
        }
        
        // Bucle para convertir a número decimal
        while (numero != 0) {
            long residuo = numero % 2;
            binario = residuo + binario;
            numero = numero / 2;
        }

        return binario;
    }

    public static String complementoAUno() {
        // Obtener la representación binaria del número absoluto
        String binario = decimalABinario();

        // Determinar la longitud de bits necesarios
        int longitudBits;
        if (numeroDecimal >= -128 && numeroDecimal <= 128) {
            longitudBits = 9;
        } else if ((numeroDecimal >= 129 && numeroDecimal <= 256) || (numeroDecimal >= -256 && numeroDecimal <= -129)) {
            longitudBits = 17;
        } else if ((numeroDecimal >= 257 && numeroDecimal <= 512) || (numeroDecimal >= -512 && numeroDecimal <= -257)) {
            longitudBits = 33;
        } else if ((numeroDecimal >= 513 && numeroDecimal <= 1024) || (numeroDecimal >= -1024 && numeroDecimal <= -513)) {
            longitudBits = 65;
        } else {
            return "Error";
        }

        // Añadir ceros a la izquierda según la longitud necesaria
        String bits = "0".repeat(Math.max(0, longitudBits - binario.length())) + binario;

        // Invertir cada bit guardandolo en complemento 
         StringBuilder complemento = new StringBuilder();
        for (int i = 0; i < bits.length(); i++) {
            char bit = bits.charAt(i);
            complemento.append((bit == '0') ? '1' : '0');
        }

        return complemento.toString();
    }

    public static String complementoADos() {
        // Obtener la representación del complemento a uno
        String binario = complementoAUno();

        // Agregar 1 al resultado para obtener la representación de complemento a 2
        //Declarar el resultado en BigInterger para numeros de 65 bits
        BigInteger resultado = new BigInteger(binario, 2).add(BigInteger.ONE);
        return resultado.toString(2);
    }
}