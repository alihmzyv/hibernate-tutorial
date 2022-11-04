package com.luv2code.services;

import com.luv2code.hibernate.demo.entity.Employee;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class EmployeeService {
    private Session session;

    public EmployeeService(Session session) {
        this.session = session;
    }

    public Long saveEmployee(Employee employee) {
        session.beginTransaction();
        Long idGen = (Long) session.save(employee);
        session.getTransaction().commit();
        return idGen;
    }

    public Optional<Employee> findById(Long id) {
        session.beginTransaction();
        Optional<Employee> employeeOpt = Optional.ofNullable(session.get(Employee.class, id));
        session.getTransaction().commit();
        return employeeOpt;
    }

    public List<Employee> findByCompany(String company) {
        session.beginTransaction();
        List<Employee> employeesFound = session
                .createQuery("from Employee emp where emp.company=?1")
                .setParameter(1, company)
                .getResultList();
        session.getTransaction().commit();
        return employeesFound;
    }
}
