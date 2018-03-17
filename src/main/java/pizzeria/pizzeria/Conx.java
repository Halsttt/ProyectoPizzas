package pizzeria.pizzeria;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;

public class Conx {

	public static Bucket cnx(String username,String passwd) {
		Cluster cluster = CouchbaseCluster.create("localhost");
        cluster.authenticate(username, passwd);
        Bucket bucket = cluster.openBucket("Usuarios");
        return bucket;
	}
}
