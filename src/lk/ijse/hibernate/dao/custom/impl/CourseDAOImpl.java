package lk.ijse.hibernate.dao.custom.impl;

import lk.ijse.hibernate.dao.custom.CourseDAO;
import lk.ijse.hibernate.entity.Course;
import lk.ijse.hibernate.entity.Student;
import lk.ijse.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {
    @Override
    public boolean add(Course entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Course entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(entity);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String s) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        Course course = session.get(Course.class, s);

        session.delete(course);

        transaction.commit();
        return true;
    }

    @Override
    public Course find(String s) throws Exception {
        return null;
    }

    @Override
    public List<Course> getAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List<Course> list = null;

        Query course = session.createQuery("from Course");

        list= course.list();


        transaction.commit();
        session.close();

        return list;
    }

    @Override
    public List<String> getCourseName() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query course = session.createQuery("select code from Course");
        List<String> list = course.list();

        transaction.commit();
        session.close();
        return list;
    }

}
