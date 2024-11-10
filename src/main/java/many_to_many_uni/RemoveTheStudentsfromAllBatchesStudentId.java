package many_to_many_uni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class RemoveTheStudentsfromAllBatchesStudentId {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EntityManager em = Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction et = em.getTransaction();
		System.out.println("Enter the student Id");
		int sid=sc.nextInt();
		Student std=em.find(Student.class,sid);
		if(std==null)
		{
			System.out.println("Invalid student Id");
			return;
		}
		List<Batch> b1=em.createQuery("from Batch").getResultList();
		for(Batch b:b1) {
			List<Student> s1=b.getStudent();
			if(s1.contains(std))
			{
				s1.remove(std);
			}
			b.setStudent(s1);
			et.begin();
			em.merge(b);
			et.commit();
		}
		System.out.println("Done");
	}
	
}
