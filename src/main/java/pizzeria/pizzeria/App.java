package pizzeria.pizzeria;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonArray;
import com.couchbase.client.java.document.json.JsonObject;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       	
    	 // Initialize the Connection
        Cluster cluster = CouchbaseCluster.create("localhost");
        cluster.authenticate("Administrator", "Smx2123");
        Bucket bucket = cluster.openBucket("dbTienda");
        
        JsonObject arthur = JsonObject.create()
                .put("name", "Arthur")
                .put("email", "kingarthur@couchbase.com")
                .put("interests", JsonArray.from("Holy Grail", "African Swallows"));
        
        bucket.upsert(JsonDocument.create("u:king_arthur", arthur));

    	
    }
}
