package com.luv2code;

import com.luv2code.hibernate.demo.entity.Employee;
import com.luv2code.services.EmployeeService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmployeeApp {
    public static void main(String[] args) {
        try (SessionFactory sessionFac = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
             Session session = sessionFac.getCurrentSession()) {
            EmployeeService employeeService = new EmployeeService(session);
            Employee employee = new Employee("Ali", "Hamzayev", "abb");
            Employee employee1 = new Employee("Hasan", "Hasanov", "crocusoft");
//            employeeService.saveEmployee(employee);
//            employeeService.saveEmployee(employee1);
            employeeService.findByCompany("abb").forEach(System.out::println);
        }
    }
}
