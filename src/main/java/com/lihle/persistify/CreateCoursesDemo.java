package com.lihle.persistify;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCoursesDemo {
    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try{
            //create the objects

            session.beginTransaction();



            //commit transaction
            session.getTransaction().commit();

            System.out.println(" Aaaanddd Done!");
        }
        finally{

            factory.close();
        }
    }
}
