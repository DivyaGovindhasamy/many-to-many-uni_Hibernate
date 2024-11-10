package many_to_many_uni;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CreatBatchAndMapOldStudent {

public static void main(String[] args) {

EntityManager em = Persistence.createEntityManagerFactory("dev").createEntityManager();
EntityTransaction et = em.getTransaction();
// Student s16 = em.find(Student.class, 16);
// Student s17 = em.find(Student.class, 17);

Student s1=new Student(0, "Jeevitha", "jeevitha@gmail.com");
Student s2=new Student(0, "Chitra", "chitra@gmail.com");
List<Student> students = new ArrayList<Student>();
students.add(s1);
students.add(s2);
Batch b = new Batch(0,"Social Science","AQWSER43",students);
et.begin();
em.persist(b);
em.persist(s1);
em.persist(s2);
et.commit();
System.out.println("Done...");
}

}

