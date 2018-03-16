package pizzeria.pizzeria;

import java.util.Scanner;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonArray;
import com.couchbase.client.java.document.json.JsonObject;

public class Registro {
	
	public static void registrar() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Por favor, introduce tu nombre:");
        String name = scanner.next();
        System.out.println("Por favor, introduce tu contraseña:");
        String password = scanner.next();
        
        Cluster cluster = CouchbaseCluster.create("localhost");
        cluster.authenticate("Administrator", "Smx2123");
        Bucket bucket = cluster.openBucket("dbTienda");
        JsonObject usu = JsonObject.create()
                .put("name", name)
                .put("password", password);
        
        System.out.println(bucket.upsert(JsonDocument.create(name, usu)));
       
        Boolean closed = bucket.close();
        
	}
}
