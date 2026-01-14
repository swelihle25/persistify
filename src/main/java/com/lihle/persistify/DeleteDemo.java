package com.lihle.persistify;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteDemo {
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
            session.beginTransaction();


            //get instructor by primary key / id
            int theId = 1;
            Instructor tempInstructor =
                    session.get(Instructor.class, theId);
            System.out.println("Found instructor: " + tempInstructor);

            //delete the instructor
            if(tempInstructor != null){
                System.out.println("Deleting: " + tempInstructor);
                session.delete(tempInstructor);
            }

            //commit transaction
            session.getTransaction().commit();
            System.out.println(" Aaaanddd Done!");
        }
        finally{
            factory.close();
        }
    }
}
