package com.luv2code;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LoadInstructor {
    public static void main(String[] args) {
//        InstructorDetail detail = new InstructorDetail("youtube.com/alihmzyv", "coding");
//        Instructor instructor = new Instructor("Ali", "Hamzayev", "alihmzyv@gmail.com", detail);
        try (SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory()) {
            Session currentSession = sessionFactory.getCurrentSession();
            currentSession.beginTransaction();
            System.out.println("Starting..");
            InstructorDetail detail = currentSession.get(InstructorDetail.class, 9);
            System.out.println("Detail: " + detail);
            Instructor instructor = detail.getInstructor();
            System.out.println("Instructor: " + instructor);
            currentSession.getTransaction().commit();
        }
    }
}
