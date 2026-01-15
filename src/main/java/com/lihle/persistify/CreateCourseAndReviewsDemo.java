package com.lihle.persistify;

import com.lihle.persistify.Entity.Course;
import com.lihle.persistify.Entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCourseAndReviewsDemo {
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

            Course tempCourse = new Course("Rubik's Cube - How to Speed Cube");

            tempCourse.addReview(new Review("Great course... loved it!"));
            tempCourse.addReview(new Review("Cool course, job well done!"));
            tempCourse.addReview(new Review("What a dumb course, you are an idiot!"));


            System.out.println("Saving the course...");
            System.out.println(tempCourse);
            System.out.println(tempCourse.getReviews());

            session.save(tempCourse);





            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally{

            factory.close();
        }
    }
}
