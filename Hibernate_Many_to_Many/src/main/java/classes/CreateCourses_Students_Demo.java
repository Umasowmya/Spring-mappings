package classes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourses_Students_Demo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = (SessionFactory) new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            // start a transaction
            session.beginTransaction();

            // create a course
            Course tempCourse = new Course("Rubix cube in 10 seconds");


            // create the students
            Student tempStudent1 = new Student("Sam", "Winchester", "sam@gmail.com");

            // add students to the course
            tempCourse.addStudent(tempStudent1);


            session.save(tempCourse);

            session.save(tempStudent1);


            System.out.println("Saved students: " + tempCourse.getStudents());


            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {

            // add clean up code
            session.close();

            factory.close();
        }
    }

}




