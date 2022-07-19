package fa.training.repository.impl;

import fa.training.model.Computer;
import fa.training.model.Service;
import fa.training.repository.ServiceRepository;

import fa.training.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceRepositoryImpl implements ServiceRepository {
    private final Integer PAGE_SIZE = 5;

    @Override
    public Map<String, Object> findAll(int pageNumber) {
        Session session = null;
        try {
            session = HibernateUtils.getSessionFactory().openSession();

            // calculate number of pages
            String countQ = "Select count (s.serviceCode) from Service s";
            Query countQuery = session.createQuery(countQ);
            int lastPageNumber = 1;
            Long countResults = (Long) countQuery.getSingleResult();
            if (countResults % PAGE_SIZE == 0) {
                lastPageNumber = (int) (countResults / PAGE_SIZE);
            }
            if (countResults % PAGE_SIZE != 0) {
                lastPageNumber = (int) (countResults / PAGE_SIZE) + 1;
            }

            TypedQuery<Service> query = session.createQuery("FROM Service s ORDER BY s.serviceCode");
            query.setFirstResult((pageNumber - 1) * PAGE_SIZE); // offset
            query.setMaxResults(PAGE_SIZE); // limit
            List<Service> serviceList = query.getResultList();

            Map<String, Object> response = new HashMap<>();
            response.put("services", serviceList);
            response.put("totalPages", lastPageNumber);

            return response;
        } catch (Exception e) {
            System.out.println("List All Services Error");
            return null;
        } finally {
            if (session != null)
                session.close();
        }
    }

    @Override
    public Service findById(String id) {
        Session session = null;
        Service service;
        try {
            session = HibernateUtils.getSessionFactory().openSession();

            String hql = "FROM Service s WHERE s.serviceCode = :id";
            service = (Service) session.createQuery(hql).setParameter("id", id).getSingleResult();

            return service;
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
    public void save(Service service) {
        Session session = null;
        Transaction transaction;

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.saveOrUpdate(service);

            transaction.commit();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (session != null)
                session.close();
        }
    }

    @Override
    public void saveAll(List<Service> services) {
        Session session = null;
        Transaction transaction;

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            for (int i = 0; i < services.size(); i++) {
                session.save(services.get(i));
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
        Service service = findById(id);
        Session session = null;
        Transaction transaction;

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.delete(service);

            transaction.commit();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (session != null)
                session.close();
        }
    }
}
