package fa.training.repository.impl;

import fa.training.model.Service;
import fa.training.repository.ServiceRepository;

import fa.training.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ServiceRepositoryImpl implements ServiceRepository {
    @Override
    public List<Service> findAll() {
        Session session = null;
        List<Service> services = new ArrayList<>();

        try {
            session = HibernateUtils.getSessionFactory().openSession();

            String hql = "SELECT Service FROM Service ";
            services = session.createQuery(hql, Service.class).list();

            return services;
        } catch (Exception e) {
            System.out.println("Error");
            return services;
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

            String hql = "FROM Service WHERE Service.serviceCode = :id";
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
