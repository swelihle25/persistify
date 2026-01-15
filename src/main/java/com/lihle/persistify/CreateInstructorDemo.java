package com.lihle.persistify;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateInstructorDemo {
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
            Instructor tempInstructor =
                    new Instructor("Susan", "Public", "susanpublic.com");

            InstructorDetail tempInstructorDetail =
                    new InstructorDetail("https://www.youtube.com", "Video Games");


            //associate the objects

            tempInstructor.setInstructorDetail(tempInstructorDetail);

            session.beginTransaction();


            System.out.println("Saving instructor: " + tempInstructor);
            session.save(tempInstructor);

            //commit transaction
            session.getTransaction().commit();

            System.out.println(" Aaaanddd Done!");
        }
        finally{

            factory.close();
        }
    }
}
