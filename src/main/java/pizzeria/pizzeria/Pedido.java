package pizzeria.pizzeria;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;
import com.couchbase.client.java.query.N1qlParams;
import com.couchbase.client.java.query.N1qlQuery;
import com.couchbase.client.java.query.N1qlQueryResult;
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
	        
	    JsonDocument count = bucketPedidos.get("id");
	        
	    //Keyboard ATR
	    Scanner scanner = new Scanner(System.in);
	  	System.out.println("Por favor, introduce la Pizza que quieres:");
		String pizzaPedida = scanner.next();
		
		System.out.println("Cuantas :"+pizzaPedida+" quiere?");
		int numPedida = scanner.nextInt();
		
		int number = 0;
		int resultNumber = number++;
		
		//INSERT SOON
		JsonObject pedido = JsonObject.create()
				.put("id", resultNumber)
        		.put("name", pizzaPedida)
        		//.put("fecha", times)
        		//.put("Hora", hora + min)
        		.put("num", numPedida);
        		
        		
        
		bucketPedidos.upsert(JsonDocument.create("pedido::"+pizzaPedida, pedido));
	        
	}
}
