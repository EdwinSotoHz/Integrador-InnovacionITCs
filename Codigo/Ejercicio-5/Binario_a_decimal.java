package com.mycompany.binario_a_decimal;
import java.util.Scanner;

/**
 *
 * @author usuario
 */ 
public class Binario_a_decimal {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.println("ALGORITMO PARA CONVERTIR UN NÚMERO BINARIO A DECIMAL");
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Ingresa el número binario correspondiente: ");
        String nbinario = in.nextLine();
        in.close();
        
        System.out.println("------------------------------------------------------------------------");
        
        if (nbinario.contains("-")) {
            nbinario = nbinario.replace("-", "");
        }
        if (nbinario.matches("[01]+")) {
            int num = binAdecimal(nbinario);
            System.out.println("Número decimal: " + num);
        }else{
            System.out.println("Carácter de tipo inválido");
        } 
    }  
    
    public static int binAdecimal(String binario) {
        int n = binario.length();
        int decimal = 0;
       
        for (int i = 0; i < n; i++) {
            int bit = Character.getNumericValue(binario.charAt(i));
            decimal += bit * Math.pow(2, n - 1 - i);
        }

        return decimal;
    }
}
