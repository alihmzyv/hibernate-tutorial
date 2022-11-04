package com;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory()) {
            Session currentSession = sessionFactory.getCurrentSession();
            currentSession.beginTransaction();
            Long id = 9L;
            Instructor tempInstructor = currentSession.get(Instructor.class, id);
            System.out.printf("Found instructor: %s\n", tempInstructor);
            if (tempInstructor != null) {
                System.out.println("Deleting: " + tempInstructor);
                currentSession.delete(tempInstructor);
            }
            currentSession.getTransaction().commit();
        }
    }
}
