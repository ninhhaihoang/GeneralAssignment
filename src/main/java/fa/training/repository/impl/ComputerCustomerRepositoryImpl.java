package fa.training.repository.impl;

import fa.training.model.ComputerCustomer;
import fa.training.model.ComputerCustomerKey;
import fa.training.model.Customer;
import fa.training.repository.ComputerCustomerRepository;

import fa.training.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ComputerCustomerRepositoryImpl implements ComputerCustomerRepository {
    @Override
    public List<ComputerCustomer> findAll() {
        Session session = null;
        List<ComputerCustomer> computerCustomers = new ArrayList<>();

        try {
            session = HibernateUtils.getSessionFactory().openSession();

            String hql = "SELECT ComputerCustomer FROM ComputerCustomer ";
            computerCustomers = session.createQuery(hql, ComputerCustomer.class).list();

            return computerCustomers;
        } catch (Exception e) {
            System.out.println("Error");
            return computerCustomers;
        } finally {
            if (session != null)
                session.close();
        }
    }

    @Override
    public ComputerCustomer findById(ComputerCustomerKey id) {
        Session session = null;
        ComputerCustomer computerCustomer;
        try {
            session = HibernateUtils.getSessionFactory().openSession();

            String hql = "FROM ComputerCustomer WHERE ComputerCustomer.id = :id";
            computerCustomer = (ComputerCustomer) session.createQuery(hql).setParameter("id", id).getSingleResult();

            return computerCustomer;
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
    public void save(ComputerCustomer computerCustomer) {
        Session session = null;
        Transaction transaction;

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.saveOrUpdate(computerCustomer);

            transaction.commit();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (session != null)
                session.close();
        }
    }

    @Override
    public void delete(ComputerCustomerKey id) {
        ComputerCustomer computerCustomer = findById(id);
        Session session = null;
        Transaction transaction;

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.delete(computerCustomer);

            transaction.commit();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (session != null)
                session.close();
        }
    }
}
