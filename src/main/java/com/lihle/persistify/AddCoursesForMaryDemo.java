package com.lihle.persistify;

import com.lihle.persistify.Entity.Course;
import com.lihle.persistify.Entity.Review;
import com.lihle.persistify.Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class AddCoursesForMaryDemo {
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
            Student tempStudent = session.get(Student.class, theId);

            System.out.println("Loaded student: " + tempStudent);
            System.out.println("Courses: " + tempStudent.getCourses());

            Course tempCourse = new Course("Rubik's Cube - How to Speed Cube");
            Course tempCourse2 = new Course("Atari 2600 - Game Development");
            Course tempCourse3 = new Course("Java - The Complete Masterclass");


            tempCourse.addStudent(tempStudent);
            tempCourse2.addStudent(tempStudent);
            tempCourse3.addStudent(tempStudent);

            System.out.println("\nSaving the courses...");


             session.save(tempCourse);
             session.save(tempCourse2);
             session.save(tempCourse3);


            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally{

            factory.close();
        }
    }
}
