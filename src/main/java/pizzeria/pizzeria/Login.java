package pizzeria.pizzeria;

import java.util.Scanner;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.JsonDocument;

public class Login {

	public static void login() {
		
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
        JsonDocument nameDoc = bucket.get("user::"+name);
        
        
        //System.out.println(nameDoc.content().getString("name"));
        //System.out.println(nameDoc.content().getString("password"));
        String passwordUser = null;
        try {
        if(nameDoc.content().getString("password") != null) {
        passwordUser = nameDoc.content().getString("password");
        }
        } catch(Exception e) {
        	System.out.println(e);
        }
        //System.out.println(name);
        //System.out.println(password);
        
        //CHECKING IF NAME AND PASSWORD != NULL / EMPTY
        if (name.equals("") && name == null || password.equals("") && password == null) {
        	System.out.println("Some field is empty");
        } else {
        
        	//CHECKING IF USER EXIST IN DOCUMENT
        	if (nameDoc == null) {
        		System.out.println("User doesn't exist.");
        	} else {
        		System.out.println("User Exist...");	
        	}
        	if(password.equals(passwordUser)) {
        		System.out.println("Login passed! "
        				+ "Welcome "+name+"!!");
        	} else {
        		System.out.println("Incorrect Password!");
        	}
        }
        
        Boolean closed = bucket.close();
		
        
		
	}
	
}
