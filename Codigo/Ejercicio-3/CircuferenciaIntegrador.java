/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javaaplicationintegrador;
import java.util.Scanner;

/**
 * El siguiente problema dice;
 * Dada una circurencia con centro en el punto C con coordenadas (x1, y1)
 * y radio r, evaluar un punto T con coordenadas (x2, y2) esta dentro del aerea
 * de la circuferencia.
 * @author Lizbeth de Jesus Bernal Franco 
 */
public class CircuferenciaIntegrador {
 
    public static void main(String[] args) {
        // Obtener las coordenadas del centro y el radio de la circunferencia
        Scanner datC = new Scanner(System.in);
        System.out.print("""
                         Ingrese las coordenadas del punto C 
                         seperadas por una coma (x1, y1):
                         """);
        String[] puntoC = (datC.nextLine()).split(",");
        
        System.out.print("Ingrese el radio de la circunferencia: ");
        float r = datC.nextFloat();
        datC.nextLine();

        // Obtener las coordenadas del punto a verificar
        System.out.print("""
                         Ingrese las coordenadas del punto T
                         seperadas por una coma (x2, y2): 
                         """);
        String[] puntoT = (datC.nextLine()).split(",");
        datC.close();
        
        int x1 = Integer.parseInt(puntoC[0].trim());
        int y1 = Integer.parseInt(puntoC[1].trim());
        
        int x2 = Integer.parseInt(puntoT[0].trim());
        int y2 = Integer.parseInt(puntoT[1].trim());

        // Calcular la distancia entre el centro y el punto
        float distancia = (float)Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        // Verificar si el punto está dentro del área de la circunferencia
        if (distancia > r) {
           System.out.println("El punto T("+x2+","+y2+") esta fuera de la circunferencia");
        }else if (distancia == r) {
            System.out.println("El punto T("+x2+","+y2+") esta en el borde de la circunferencia");
        }else if (distancia < r){
            System.out.println("El punto T("+x2+","+y2+") esta dentro de la circunferencia");
        }
    } 
}
    
    
    
    
    
   
    

