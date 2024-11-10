package many_to_many_uni;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AddNewStudentToExistingBatch {
	public static void main(String[] args) {
		EntityManager em= Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction et =em.getTransaction();
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Batch Id");
		Batch b=em.find(Batch.class,sc.nextInt());
		if(b==null) {
			System.err.println("Invalid batch id");
			return;
		}
		List<Student> student = new ArrayList<Student>();
		
		boolean flag = true;
		while(flag) { 
			System.out.println("Do you want to add Student(Y/N)");
		char ch=sc.next().charAt(0);
		if(ch=='Y'||ch=='y') {
			Student s= new Student();
			System.out.println("Enter Name");
			s.setName(sc.next());
			System.out.println("Enter Email");
			s.setEmail(sc.next());
			
			student.add(s);
		}else 
			flag =false;
	}
		List<Student> os1=b.getStudent();
		os1.addAll(student);
		et.begin();
		for(Student s:student)
			em.persist(s);
		em.merge(b);
		et.commit();
	}
}
	
	

		
	
	
	
	

