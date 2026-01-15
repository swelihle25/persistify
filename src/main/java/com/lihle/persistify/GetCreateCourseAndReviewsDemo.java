package com.lihle.persistify;

import com.lihle.persistify.Entity.Course;
import com.lihle.persistify.Entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class GetCreateCourseAndReviewsDemo {
    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)

                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try{
            session.beginTransaction();

            int theId = 2;
            Course tempCourse = session.get(Course.class, theId);

            
            System.out.println(tempCourse);
            System.out.println(tempCourse.getReviews());


            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally{

            factory.close();
        }
    }
}
