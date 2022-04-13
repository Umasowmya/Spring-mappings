package classes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {

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

            System.out.println("uma   instructor object "+tempInstructor);

            System.out.println("sowmya    courses of instructor object "+tempInstructor.getCourses());

            // commit transaction
            session.getTransaction().commit();

            session.close();

            System.out.println("\n\n session is closed\n\n");

            System.out.println("sowmya    courses of instructor object "+tempInstructor.getCourses());

            System.out.println("Done!");
        }


        finally {

            // add clean up code
            session.close();

            factory.close();
        }
    }

}




