package com.luv2code;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentQueriesDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml") //knows how to connect to db
                .addAnnotatedClass(Student.class) //knows how to save Student instances to db (column names, id, table name etc.)
                .buildSessionFactory();
        try (sessionFactory;
             Session session = sessionFactory.getCurrentSession()) {
            //save 3 students
//            Student std = new Student("Ali", "Hamzayev", "alihmzyv@gmail.com");
//            Student std2 = new Student("Namig", "Hasanov", "namig@gmail.com");
//            Student std3 = new Student("Namig", "Hasanov", "namig@gmail.com");
//            System.out.println("Transaction began");
//            session.beginTransaction();
//            session.save(std2);
//            session.save(std3);
//            session.save(std);
//            System.out.println("Saved !");
//            session.getTransaction().commit();
//            System.out.println("Transaction committed");
            //retrieve a student
//            session.beginTransaction();
//            Student std4 = new Student("Karam", "Huseynov", "karam@gmail.com");
//            session.save(std4);
//            std4 = session.get(Student.class, std4.getId());
//            //line below can produce null pointer exception, if student with id not found
//            System.out.println(std4 == null ? String.format("Student with id = %d NOT FOUND\n", std4.getId()) : std4);
            //retrieve all students
//            session.beginTransaction();
//            //notice you refer to java class in query, not to database table
//            List<Student> allStudents = (List<Student>) session
//                    .createQuery("from Student")
//                    .getResultList();
//            System.out.println("All students:");
//            allStudents.forEach(System.out::println);
            //retrive students with name Namig
//            System.out.println("Students with name = Namig");
//            List<Student> namigStudents = (List<Student>) session
//                    .createQuery("from Student s where s.firstName = ?1")
//                    .setParameter(1, "Namig")
//                    .getResultList();
//            System.out.println(namigStudents);
//            session.getTransaction().commit();
            //update query
//            session.beginTransaction();
//            session.createQuery("update Student std set std.email=?1")
//                    .setParameter(1, "luv2code@gmail.com")
//                    .executeUpdate();
//            session.getTransaction().commit();
//            session.beginTransaction();
//            session.createQuery("from Student")
//                    .getResultList()//although the student objects are "Object", toString is overrided from Object, thus works
//                    .forEach(System.out::println);
//            session.getTransaction().commit();
            //delete students with name Namig
            session.beginTransaction();
            session.createQuery("delete Student std where std.firstName=?1")
                    .setParameter(1, "Namig")
                    .executeUpdate();
            session.getTransaction().commit();
        }
    }
}
