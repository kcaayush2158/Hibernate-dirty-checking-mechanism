package com.application.client;

import com.application.entities.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;


public class Main {
    public static  void main(String[] args){
    Session session = null;
    try {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
                        session= sessionFactory.openSession();
                        createEmployee(session);
        }catch (Exception ex){
             ex.printStackTrace();
        }finally {
        if(session!=null){}
        session.close();
        }

    }

    public static void createEmployee(Session session)
    {
        session.beginTransaction();
       Integer id = (Integer) session.save(getEmployee());
       System.out.println("Employee is created with the id of :"+id);
       session.getTransaction().commit();
    }

    public static Employee getEmployee(){
        Employee employee = new Employee();
        employee.setEmployeeName("aayush kc");
        employee.setDoj(new Date());
        employee.setSalary(5000.00);
        employee.setEmail("aayushkc2158@gmail.com");
        return employee;

    }


}
