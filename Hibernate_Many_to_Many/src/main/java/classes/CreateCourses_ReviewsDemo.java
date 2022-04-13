package classes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourses_ReviewsDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = (SessionFactory) new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            // start a transaction
            session.beginTransaction();

            Course c = new Course("Spirng");

            Review re = new Review("Loved it");
            Review re1 = new Review("Not Bad");
            Review re2 = new Review("Worthless");

            c.add(re);
            c.add(re1);
            c.add(re2);

            System.out.println("saving course");
            session.save(c);

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




