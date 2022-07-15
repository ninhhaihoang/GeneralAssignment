package fa.training.repository.impl;

import fa.training.model.Customer;
import fa.training.repository.CustomerRepository;

import fa.training.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public List<Customer> findAll() {
        Session session = null;
        List<Customer> customers = new ArrayList<>();

        try {
            session = HibernateUtils.getSessionFactory().openSession();

            String hql = "SELECT c FROM Customer c";
            customers = session.createQuery(hql, Customer.class).list();

            return customers;
        } catch (Exception e) {
            System.out.println("List All Customer Error");
            return customers;
        } finally {
            if (session != null)
                session.close();
        }
    }

    @Override
    public Customer findById(String id) {
        Session session = null;
        Customer customer;
        try {
            session = HibernateUtils.getSessionFactory().openSession();

            String hql = "FROM Customer WHERE Customer.customerCode = :id";
            customer = (Customer) session.createQuery(hql).setParameter("id", id).getSingleResult();

            return customer;
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
    public void save(Customer customer) {
        Session session = null;
        Transaction transaction;

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.saveOrUpdate(customer);

            transaction.commit();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (session != null)
                session.close();
        }
    }

    @Override
    public void saveAll(List<Customer> customers) {
        Session session = null;
        Transaction transaction;

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            for (int i = 0; i < customers.size(); i++) {
                session.save(customers.get(i));
            }
            transaction.commit();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (session != null)
                session.close();
        }
    }

    @Override
    public void delete(String id) {
        Customer customer= findById(id);
        Session session = null;
        Transaction transaction;

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.delete(customer);

            transaction.commit();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (session != null)
                session.close();
        }
    }
}
