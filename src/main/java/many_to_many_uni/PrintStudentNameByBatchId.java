package many_to_many_uni;


import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class PrintStudentNameByBatchId {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		EntityManager em= Persistence.createEntityManagerFactory("dev").createEntityManager();
		System.out.println("Enter Batch Id");
		int bId=sc.nextInt();
		Batch b = em.find(Batch.class, bId);
		
		List<Student> s1 = b.getStudent();
		List<Batch> b1= em.createQuery("from Batch").getResultList();
		
		for(Batch bb:b1) {
			List<Student> ss1 =bb.getStudent();
			if(ss1.containsAll(s1)) {
				System.out.println(bb.getName());
			}
		}
	}
}
