package com.lihle.persistify;

import com.lihle.persistify.Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateDemo {
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
                    new Instructor("Lihle", "Wallace", "smunqawallace.com");

            InstructorDetail tempInstructorDetail =
                    new InstructorDetail("https://www.youtube.com", "Coding");


            //associate the objects

            tempInstructor.setInstructorDetail(tempInstructorDetail);

            session.beginTransaction();

            //save instructor
            // Note: this will also save the details object
            // because of CascadeType.ALL
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
