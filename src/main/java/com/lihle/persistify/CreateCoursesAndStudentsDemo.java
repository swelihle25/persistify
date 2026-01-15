package com.lihle.persistify;

import com.lihle.persistify.Entity.Course;
import com.lihle.persistify.Entity.Review;
import com.lihle.persistify.Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCoursesAndStudentsDemo {
    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)


                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try{
            session.beginTransaction();

            Course tempCourse = new Course("Pacman - How to Score One Million Points");



            session.save(tempCourse);
            System.out.println("Saved the course: " + tempCourse);

            Student tempStudent = new Student("John", "Doe", "john@doe.com");
            Student tempStudent2 = new Student("Mary", "Public", "mary@public.com");


            tempCourse.addStudent(tempStudent);
            tempCourse.addStudent(tempStudent2);
            System.out.println("Saving  students: " + tempCourse.getStudents());


            session.save(tempStudent);
            session.save(tempStudent2);
            System.out.println("Saved the students: " + tempStudent + " " + tempStudent2);






            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally{

            factory.close();
        }
    }
}
