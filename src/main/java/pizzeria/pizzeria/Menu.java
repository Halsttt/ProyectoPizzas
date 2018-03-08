package pizzeria.pizzeria;

import java.util.InputMismatchException;
import java.util.Scanner;
 
public class Menu {
 
    public static void main(String[] args) {
 
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        
        while (!salir) {
 
            System.out.println("1. Crear Usuario");
            System.out.println("2. Login");
            System.out.println("3. Pedir Pizza");
            System.out.println("4. Modificar Pedido");
            System.out.println("5. Eliminar Pedido");
 
            try {
 
                System.out.println("Escribe una de las siguientes opciones.");
                opcion = scanner.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("Por favor, introduce tu nombre:");
                        String name = scanner.next();
                        System.out.println("Por favor, introduce tu contraseña:");
                        String password = scanner.next();
                        
                        //Insert Usuario (Comprobar que no exista ya)
                        break;
                    case 2:
                    	
                    	while(true) { 
                    	System.out.println("Por favor, introduce tu nombre:");
                        String name1 = scanner.next();
                        System.out.println("Por favor, introduce tu contraseña:");
                        String password1 = scanner.next();
                        	
                        //TODO CONSULTA -> Comprobar si existe el usuario BREAK if not bucle again.
                        //break;
                    	}
                        
				case 3:
                        System.out.println("A continuación le mostramos nuestras diferentes pizzas: (Escriba el nombre de la que quiere)");
                        //TODO CONSULTA -> Diferentes pizzas AND Insert in Pedido.
                        break;
                    case 4:
                        System.out.println("Elige el pedido que quieres modificar: ");
                      //TODO CONSULTA -> Diferentes pedidos AND Update in Pedido correspondiente.
                        
                        
                        break;
                    case 5:
                    	System.out.println("Elige el pedido que quieres eliminar: ");
                        //TODO CONSULTA -> Diferentes pedidos AND Delete in Pedido correspondiente.
                        break;
                    case 6:
                        salir = true;
                        break;
                    default:
                        System.out.println("Sólo números entre 1 y 6, por favor.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Tienes que insertar un número.");
                scanner.next();
            }
        }
 
    }
 
}