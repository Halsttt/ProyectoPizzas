package pizzeria.pizzeria;

import java.util.Scanner;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;


public class Registro {
	
	public static void registrar() {
		
		//Keyboard ATR
		Scanner scanner = new Scanner(System.in);
		System.out.println("Por favor, introduce tu nombre:");
        String name = scanner.next();
        System.out.println("Por favor, introduce tu contraseña:");
        String password = scanner.next();
        
        //CNX
        Cluster cluster = CouchbaseCluster.create("localhost");
        cluster.authenticate("Administrator", "Smx2123");
        Bucket bucket = cluster.openBucket("Usuarios");
        
        //GETTING ID (NAME) FROM BUCKET
        JsonDocument nameCheck = bucket.get("user::"+name);
        
        //CHECKING IF NAME AND PASSWORD != NULL / EMPTY
        if (name.equals("") && name == null || password.equals("") && password == null) {
        	System.out.println("Some field is empty");
        } else {
        
        		//CHECKING IF USER EXIST IN DOCUMENT
        		if (nameCheck == null) {
        			//BCrypt.hashpw(password, BCrypt.gensalt())); Encriptar
        			JsonObject usu = JsonObject.create()
        							.put("name", name)
        							.put("password", password);
            
        			//System.out.println(bucket.upsert(JsonDocument.create("user::"+name, usu)));
        			System.out.println("Usuario Creado correctamente!");
        		} else {
        			System.out.println("Este Usuario ya esta creado, intentalo de nuevo con otro nombre");
        		}
        }
        
        
       
        Boolean closed = bucket.close();
        
	}
}
