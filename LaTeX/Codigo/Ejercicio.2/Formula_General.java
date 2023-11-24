package com.itsoeh.recta;

import java.util.Scanner;

/**
 *
 * @author José María Ortiz Escamilla
 */
public class Formula_General {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner in= new Scanner(System.in);
        
        //Solicitar los coeficientes para la formula general.
        System.out.println("""
                           "Ingresa los puntos a, b, c.
                           Separadas por una coma(a, b, c): 
                           """);
        
        //divide una cadena en un arreglo de cadenas.
        String [] datos=in.nextLine().split(",");
        
        
        //Cierre de escaneo.
        in.close();
        
        //normalizar Valores de a, b, c a numeros enteros.
        int a= Integer.parseInt(datos[0].trim());
        int b= Integer.parseInt(datos[1].trim());
        int c= Integer.parseInt(datos[2].trim());
        
        //Calcula la discriminante
        double discriminante=(Math.pow(b, 2)-(4*(a*c)));
        
        // se determina si existe unan soliucion en los numeros reales
        if (discriminante>=0) {
            //Se realizan las operaciones de las raizes.
            double x1=(-b+Math.sqrt(discriminante))/(2*a);
            double x2=(-b-Math.sqrt(discriminante))/(2*a);
            
            //Se imprimen las raizes.
            System.out.println("La raiz x1 es igual a " + x1);
            System.out.println("La raiz x1 es igual a " + x2);
            
            //Se determina si existe solo una solucion.
        }else if(discriminante==0){
            
            //Se realiza la operacion.
            double x=(-b/(2*a));
            
            //Se imprime el valor de x.
            System.out.println("La raiz es igual a " + x);
            
            //En caso de no cumplirse ninguna condicion.
        }else{
            
            //Se indica que el numero esta en los numeros complejos.
            System.out.println("Esta dentro de los numeros complejos");
        }
        
        
    }
    
}
