package classes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = (SessionFactory) new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            // start a transaction
            session.beginTransaction();


            Instructor tempInstructor = session.get(Instructor.class,1);

            Course tempCourse1 = new Course("Java");

            Course tempCourse2 = new Course("DBMS");

            tempInstructor.add(tempCourse1);
            tempInstructor.add(tempCourse2);

            tempCourse1.setInstructor(tempInstructor);
            tempCourse2.setInstructor(tempInstructor);

            session.save(tempCourse1);
            session.save(tempCourse2);

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




