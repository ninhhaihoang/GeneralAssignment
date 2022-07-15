package fa.training.repository.impl;

import fa.training.model.ComputerCustomer;
import fa.training.model.ServiceCustomer;
import fa.training.model.ServiceCustomerKey;
import fa.training.repository.ServiceCustomerRepository;

import fa.training.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ServiceCustomerRepositoryImpl implements ServiceCustomerRepository {
    @Override
    public List<ServiceCustomer> findAll() {
        Session session = null;
        List<ServiceCustomer> serviceCustomers = new ArrayList<>();

        try {
            session = HibernateUtils.getSessionFactory().openSession();

            String hql = "SELECT m FROM ServiceCustomer m ";
            serviceCustomers = session.createQuery(hql, ServiceCustomer.class).list();

            return serviceCustomers;
        } catch (Exception e) {
            System.out.println("Error");
            return serviceCustomers;
        } finally {
            if (session != null)
                session.close();
        }
    }

    @Override
    public ServiceCustomer findById(ServiceCustomerKey id) {
        Session session = null;
        ServiceCustomer serviceCustomer;
        try {
            session = HibernateUtils.getSessionFactory().openSession();

            String hql = "FROM ServiceCustomer WHERE ServiceCustomer.id = :id";
            serviceCustomer = (ServiceCustomer) session.createQuery(hql).setParameter("id", id).getSingleResult();

            return serviceCustomer;
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
            return null;
        } finally {
            if (session != null)
                session.close();
        }
    }

    @Override
    public void save(ServiceCustomer serviceCustomer) {
        Session session = null;
        Transaction transaction;

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.saveOrUpdate(serviceCustomer);

            transaction.commit();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (session != null)
                session.close();
        }
    }

    @Override
    public void delete(ServiceCustomerKey id) {
        ServiceCustomer serviceCustomer = findById(id);
        Session session = null;
        Transaction transaction;

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.delete(serviceCustomer);

            transaction.commit();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (session != null)
                session.close();
        }
    }
}
