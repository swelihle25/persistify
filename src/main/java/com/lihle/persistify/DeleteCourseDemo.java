package com.lihle.persistify;

import com.lihle.persistify.Entity.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteCourseDemo {
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

            int theId = 1 ;
            Course tempCourse = session.get(Course.class, theId);
            System.out.println("Loaded course: " + tempCourse);

            session.delete(tempCourse);


            //commit transaction
            session.getTransaction().commit();

            System.out.println(" Aaaanddd Done!");
        }
        finally{

            factory.close();
        }
    }
}
