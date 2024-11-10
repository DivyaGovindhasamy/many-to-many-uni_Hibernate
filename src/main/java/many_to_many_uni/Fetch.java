package many_to_many_uni;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Fetch {
	public static void main(String[] args) {
		EntityManager em=Persistence.createEntityManagerFactory("dev").createEntityManager();
		
		Batch b=em.find(Batch.class,1);
		System.out.println(b);
	}
}
