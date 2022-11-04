package com.luv2code;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {
        InstructorDetail detail = new InstructorDetail("youtube.com/alihmzyv", "coding");
        try (SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory()) {
            Session currentSession = sessionFactory.getCurrentSession();
            currentSession.beginTransaction();
//            currentSession.save(instructor);
            currentSession.getTransaction().commit();
        }
    }
}
