package com.springapp.mvc;

import org.hibernate.Criteria;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Wajih Sid on 10/27/2015.
 */
@Repository
public class EmpDAO
{


    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void insert(Emp emp) {
        Session session = getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(emp);
        session.getTransaction().commit();

    }

    public List<Emp> selectAll() {
        Session session = getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Emp.class);
        List<Emp> employees = (List<Emp>) criteria.list();
        session.getTransaction().commit();
        return employees;
    }

}
