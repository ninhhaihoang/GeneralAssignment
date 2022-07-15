package fa.training.repository.impl;

import fa.training.model.Computer;
import fa.training.repository.ComputerRepository;
import fa.training.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ComputerRepositoryImpl implements ComputerRepository {
    @Override
    public List<Computer> findAll() {
        Session session = null;
        List<Computer> computers = new ArrayList<>();

        try {
            session = HibernateUtils.getSessionFactory().openSession();

            String hql = "SELECT c FROM Computer c";
            computers = session.createQuery(hql, Computer.class).list();

            return computers;
        } catch (Exception e) {
            System.out.println("Error");
            return computers;
        } finally {
            if (session != null)
                session.close();
        }
    }

    @Override
    public Computer findById(String id) {
        Session session = null;
        Computer computer;
        try {
            session = HibernateUtils.getSessionFactory().openSession();

            String hql = "FROM Computer c WHERE c.computerCode = :id";
            computer = (Computer) session.createQuery(hql).setParameter("id", id).getSingleResult();

            return computer;
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
    public void save(Computer computer) {
        Session session = null;
        Transaction transaction;

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.saveOrUpdate(computer);

            transaction.commit();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (session != null)
                session.close();
        }
    }

    @Override
    public void saveAll(List<Computer> computers) {
        Session session = null;
        Transaction transaction;

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            for (int i = 0; i < computers.size(); i++) {
                session.save(computers.get(i));
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
        Computer computer = findById(id);
        Session session = null;
        Transaction transaction;

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.delete(computer);

            transaction.commit();
//			System.out.println(affectedRows + " rows executed");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (session != null)
                session.close();
        }
    }
}
