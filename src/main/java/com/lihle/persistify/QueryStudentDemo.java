package com.lihle.persistify;

import com.lihle.persistify.Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try{
            //start a transaction
            session.beginTransaction();

           // query students
            List<Student> theStudents = session.createQuery("from Student").list();

            //display the students
            for (Student tempStudent : theStudents){
                System.out.println(tempStudent);
            }
            //query students: lastName='Doe'
            theStudents = session.createQuery("from Student s where s.lastName='Doe'").list();
            displayStudents(theStudents);

            //query students: lastName='Doe' OR firstName='Daffy'
            theStudents = session.createQuery("from Student s where s.lastName='Doe' OR " +
                    "s.firstName='Daffy'").list();
            displayStudents(theStudents);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally{
            factory.close();
        }
    }

    private static void displayStudents(List<Student> theStudents) {
    }

}
