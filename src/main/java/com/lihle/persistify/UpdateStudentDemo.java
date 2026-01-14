package com.lihle.persistify;

import com.lihle.persistify.Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class UpdateStudentDemo {
    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try{
            int studentId = 1;

            //get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            //retrieve student based on the id: primary key
            System.out.println("\nGetting student with id: " + studentId);

            Student myStudent = session.get(Student.class, studentId);
            session.delete(myStudent);

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");

            session = factory.getCurrentSession();
            session.beginTransaction();

            //update email for all students
            System.out.println("Updating email for all students...");

            session.createQuery("update Student set email='foo@gmail.com'")
                    .executeUpdate();








            session.getTransaction().commit();

        }
        finally{
            factory.close();
        }
    }
}
