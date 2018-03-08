package pizzeria.pizzeria;

import java.util.InputMismatchException;
import java.util.Scanner;
 
public class Menu {
 
    public static void main(String[] args) {
 
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        
        while (!salir) {
 
            System.out.println("1. Dar de alta a los clientes.");
            System.out.println("2. Dar de alta facturas de los clientes.");
            System.out.println("3. Consultar un cliente y obtener todas sus facturas.");
            System.out.println("4. Consultar todas las facturas que aún no se han pagado.");
            System.out.println("5. Salir del programa.");
 
            try {
 
                System.out.println("Escribe una de las siguientes opciones.");
                opcion = scanner.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("Por favor, introduce el nombre del cliente al que quieres dar de alta:");
                        break;
                    case 2:
                        System.out.println("Por favor, introduce la fecha de la factura:");
                        break;
                    case 3:
                        System.out.println("Escribe el nombre del cliente:");
                        
                        
                        
                        
                        
                        break;
                    case 4:
                        System.out.println("Has seleccionado la opcion 4");
                        
                        
                        
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Sólo números entre 1 y 5, por favor.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Tienes que insertar un número.");
                scanner.next();
            }
        }
 
    }
 
}