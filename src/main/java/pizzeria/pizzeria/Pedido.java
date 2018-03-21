package pizzeria.pizzeria;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;
import com.couchbase.client.java.query.N1qlParams;
import com.couchbase.client.java.query.N1qlQuery;
import com.couchbase.client.java.query.N1qlQueryRow;

public class Pedido {

	public static void pedir() {
		//CNX
		Cluster cluster = CouchbaseCluster.create("localhost");
		cluster.authenticate("Administrator", "Smx2123");
		Bucket bucketPizzas = cluster.openBucket("Pizzas");
		Bucket bucketPedidos = cluster.openBucket("Pedidos");
		
		//Select id's de Pizzas
		N1qlParams params = N1qlParams.build().adhoc(false);
	    N1qlQuery pizzas = 
	    		N1qlQuery.simple(
	    		"SELECT META(Pizzas).id\r\n" + 
	    		"FROM Pizzas\r\n" + 
	    		"ORDER BY META(Pizzas).id;", params);
	        
	        for (N1qlQueryRow row : bucketPizzas.query(pizzas)) {
	            System.out.println(row);
	        }
	        
	    //Keyboard ATR
	    Scanner scanner = new Scanner(System.in);
	  	System.out.println("Por favor, introduce la Pizza que quieres:");
		String pizzaPedida = scanner.next();
		
		System.out.println("Cuantas "+pizzaPedida+" quiere?");
		int numPedida = scanner.nextInt();
		
		Number n = new Number();
		System.out.println(n);
		String nString = String.valueOf(n);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate time = LocalDate.now();
		 
		String timeString = String.valueOf(time);
		
		int hr=Time.valueOf(LocalTime.now()).getHours();
		int minutes=Time.valueOf(LocalTime.now()).getMinutes();
		
		//CHECKING IF NAME AND PASSWORD != NULL / EMPTY
        if (pizzaPedida.equals("") && pizzaPedida == null || numPedida == 0) {
        	System.out.println("Error: La pizza no puede ser null o el numero 0.");
        } else {
		//INSERT DEMAND
		JsonObject pedido = JsonObject.create()
				.put("id", nString)
        		.put("name", pizzaPedida)
        		.put("fecha", timeString)
        		.put("Hora", hr+":"+minutes)
        		.put("num", numPedida);
        		
		bucketPedidos.upsert(JsonDocument.create(nString+"::"+pizzaPedida, pedido));
		System.out.println("Pedido Creado Correctamente!");
        }
        Boolean closed = bucketPizzas.close();
		Boolean closedd = bucketPedidos.close();
	}
}
