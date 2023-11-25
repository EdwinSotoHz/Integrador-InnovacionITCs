package integradorpruebas;

import java.util.Scanner;

/**
 * @author Edwin Salvador Soto Hernández
 */
public class RectaPendiente {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.println("Ingresa los valores de \"x\" y \"y\" del punto 1 separado por una coma (x,y):");
        String[] puntoA = (in.nextLine()).split(",");
        System.out.println("Ingresa los valores de \"x\" y \"y\" del punto 2 separado por una coma (x,y):");
        String[] puntoB = (in.nextLine()).split(",");
        
        in.close();
        
        int x1 = Integer.parseInt(puntoA[0].trim());
        int y1 = Integer.parseInt(puntoA[1].trim());
        int x2 = Integer.parseInt(puntoB[0].trim());
        int y2 = Integer.parseInt(puntoB[1].trim());
        
        if (x2 - x1 == 0) {
            System.out.println("Error: La pendiente es indefinida (división por cero).");
        } else {
            Double m = (double) (y2 - y1) / (x2 - x1);
            Double b = y1 - m * x1;
            Double angulo = Math.atan(m);
            Double anguloGrados = angulo * (180/Math.PI);

            System.out.println("\nf(x) = "+m+"x + "+b);
            System.out.println("θ = "+angulo+"°");
        }
    }
}
