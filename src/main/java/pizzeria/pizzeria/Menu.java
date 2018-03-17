package pizzeria.pizzeria;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.query.N1qlParams;
import com.couchbase.client.java.query.N1qlQuery;
import com.couchbase.client.java.query.N1qlQueryRow;
 
public class Menu {
 
    public static void main(String[] args) {
 
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        
     // Initialize the Connection
        
        //Bucket bucket = cluster.openBucket("dbTienda");
        
        while (!salir) {
 
            System.out.println("1. Crear Usuario");
            System.out.println("2. Login");
            System.out.println("3. Pedir Pizza");
            System.out.println("4. Modificar Pedido");
            System.out.println("5. Eliminar Pedido");
            System.out.println("6. Exit");
 
            try {
 
                System.out.println("Escribe una de las siguientes opciones:");
                opcion = scanner.nextInt();
 
                switch (opcion) {
                    case 1:     
                    	Registro.registrar();         
                        break;
                    case 2: 
                    	Login.login();
                        break;
				case 3:
                        System.out.println("Elige las pizza a pedir:");
                        //TODO CONSULTA -> Diferentes pizzas AND Insert in Pedido.
                        Pedido.pedir();
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