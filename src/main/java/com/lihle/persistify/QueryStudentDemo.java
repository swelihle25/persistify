package com.lihle.persistify;

import com.lihle.persistify.Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
            //use the session object to save Java object
            System.out.println("Creating new student object...");

            //create a student object
            Student tempStudent = new Student("Sphe", "Wallace", "sphewallace.com");

            //start a transaction
            session.beginTransaction();

            //save the student object
            System.out.println("Saving the student...");
            session.save(tempStudent);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally{
            factory.close();
        }
    }

}
