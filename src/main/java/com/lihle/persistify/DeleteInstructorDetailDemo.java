package com.lihle.persistify;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteInstructorDetailDemo {
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

            //get instructor detail object
            int theId = 3;
            InstructorDetail tempInstructorDetail =
                    session.get(InstructorDetail.class, theId);
            System.out.println("tempInstructorDetail: " +
                    tempInstructorDetail);

            //print the associated instructor
            System.out.println("the associated instructor: " +
                    tempInstructorDetail.getInstructor());

            //delete the instructor detail
            System.out.println("Deleting tempInstructorDetail: " +
                    tempInstructorDetail);

            //Remove associated object reference
            tempInstructorDetail.getInstructor().setInstructorDetail(null);



            session.delete(tempInstructorDetail);
            //commit transaction
            session.getTransaction().commit();
            System.out.println(" Aaaanddd Done!");
        }
        finally{
            factory.close();
        }
    }
}
