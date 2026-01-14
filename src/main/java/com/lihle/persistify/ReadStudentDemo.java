package com.lihle.persistify;

import com.lihle.persistify.Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class ReadStudentDemo {
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
            Student tempStudent = new Student("Daffy", "Duck", "daffyduck.com");

            //start a transaction
            session.beginTransaction();

            //save the student object
            System.out.println("Saving the student...");
            System.out.println(tempStudent);
            session.save(tempStudent);

            //commit transaction
            session.getTransaction().commit();

            //MY NEW CODE

            //find out the student's id: primary key
            System.out.println("Saved student. Generated id: " + tempStudent.getId());

            //get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            //retrieve student based on the id: primary key
            System.out.println("\nGetting student with id: " + tempStudent.getId());

            Student myStudent = session.get(Student.class, tempStudent.getId());

            System.out.println("Get complete: " + myStudent);

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done!");


        }
        finally{
            factory.close();
        }
    }
}
