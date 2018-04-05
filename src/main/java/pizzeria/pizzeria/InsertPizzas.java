package pizzeria.pizzeria;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonArray;
import com.couchbase.client.java.document.json.JsonObject;

public class InsertPizzas {

	public static void main(String[] args) {

		// Initialize the Connection
        Cluster cluster = CouchbaseCluster.create("localhost");
        cluster.authenticate("Administrator", "Smx2123");
        Bucket bucket = cluster.openBucket("Pizzas");
        
        JsonObject pizzaQueso = JsonObject.create()
        		.put("name", "Queso")
        		.put("ingredientes", JsonArray.from("tomate", "queso","carne","arroz"));
        
        bucket.upsert(JsonDocument.create("pizzaQueso", pizzaQueso));
        System.out.println(bucket.upsert(JsonDocument.create("pizzaQueso", pizzaQueso)));
        
        JsonObject pizzaAtun = JsonObject.create()
        		.put("name", "Atun")
        		.put("ingredientes", JsonArray.from("tomate", "queso","carne","atun"));
        
        bucket.upsert(JsonDocument.create("pizzaAtun", pizzaAtun));
        System.out.println(bucket.upsert(JsonDocument.create("pizzaAtun", pizzaAtun)));
        
        JsonObject pizzaChocolate = JsonObject.create()
        		.put("name", "Chocolate")
        		.put("ingredientes", JsonArray.from("chocolate", "chocolate","chocolate"));
        
        bucket.upsert(JsonDocument.create("pizzaChocolate", pizzaChocolate));
        System.out.println( bucket.upsert(JsonDocument.create("pizzaChocolate", pizzaChocolate)));
        
        JsonObject pizzaIberica = JsonObject.create()
        		.put("name", "Iberica")
        		.put("ingredientes", JsonArray.from("tomate", "Jamon"));
        
        bucket.upsert(JsonDocument.create("pizzaChocolate", pizzaIberica));
        System.out.println(bucket.upsert(JsonDocument.create("pizzaChocolate", pizzaIberica)));
        
        JsonObject pizza = JsonObject.create()
        		.put("name", "Valenciana")
        		.put("ingredientes", JsonArray.from("tomate", "queso","carne","arroz"));
        
        bucket.upsert(JsonDocument.create("pizzaValenciana", pizza));
        System.out.println(bucket.upsert(JsonDocument.create("pizzaValenciana", pizza)));
		

	}

}
