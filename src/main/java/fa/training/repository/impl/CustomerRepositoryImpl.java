package fa.training.repository.impl;

import fa.training.model.Customer;
import fa.training.repository.CustomerRepository;
import fa.training.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerRepositoryImpl implements CustomerRepository {
    private final Integer PAGE_SIZE = 5;

    @Override
    public Map<String, Object> findAll(int pageNumber) {
        Session session = null;
//        Transaction transaction;
        List<Customer> customers = new ArrayList<>();

        try {
            session = HibernateUtils.getSessionFactory().openSession();

            // calculate number of pages
            String countQ = "Select count (c.customerCode) from Customer c";
            Query countQuery = session.createQuery(countQ);
            int lastPageNumber = 1;
            Long countResults = (Long) countQuery.getSingleResult();
            if (countResults % PAGE_SIZE == 0) {
                lastPageNumber = (int) (countResults / PAGE_SIZE);
            }
            if (countResults % PAGE_SIZE != 0) {
                lastPageNumber = (int) (countResults / PAGE_SIZE) + 1;
            }
//            lastPageNumber = (int) (Math.ceil(countResults / PAGE_SIZE));
            System.out.println(lastPageNumber);

            TypedQuery<Customer> query = session.createQuery("FROM Customer c ORDER BY c.customerCode");
            query.setFirstResult((pageNumber - 1) * PAGE_SIZE);
            query.setMaxResults(PAGE_SIZE);
            List<Customer> customerList = query.getResultList();

            Map<String, Object> response = new HashMap<>();
            response.put("customers", customerList);
            response.put("totalPages", lastPageNumber);
//            response.put("totalItems", PAGE_SIZE);

            return response;
        } catch (Exception e) {
            System.out.println("List All Customer Error");
            return null;
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

            String hql = "FROM Customer c WHERE c.customerCode = :id";
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
        Customer customer = findById(id);
        System.out.println("customer in delete repo: " + customer);
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
