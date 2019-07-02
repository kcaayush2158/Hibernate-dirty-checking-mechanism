package com.application.client;

import com.application.entities.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DirtyCheckingClientTest {
    public static void main(String[] args) {
        Session session = null;
        try {
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            SessionFactory sessionFactory = configuration.buildSessionFactory();
            session= sessionFactory.openSession();
            Employee employee = session.get(Employee.class, 1);
            if(employee != null){
                session.beginTransaction();
                employee.setSalary(55000.00);

               // session.update(employee);
                session.getTransaction().commit();
                //employee.setEmployeeName("Martin Bingel2");
            }else{
                System.out.println("Employeedoesn't exist with provided Id..");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(session != null){
                session.close();
            }
        }
    }
}
