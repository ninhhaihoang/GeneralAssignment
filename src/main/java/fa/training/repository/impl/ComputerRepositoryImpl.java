package fa.training.repository.impl;

import fa.training.model.Computer;
import fa.training.repository.ComputerRepository;
import fa.training.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComputerRepositoryImpl implements ComputerRepository {
    private final Integer PAGE_SIZE = 5;

    @Override
    public Map<String, Object> findAll(int pageNumber) {
        Session session = null;
        try {
            session = HibernateUtils.getSessionFactory().openSession();

            // calculate number of pages
            String countQ = "Select count (c.computerCode) from Computer c";
            Query countQuery = session.createQuery(countQ);
            int lastPageNumber = 1;
            Long countResults = (Long) countQuery.getSingleResult();
            if (countResults % PAGE_SIZE == 0) {
                lastPageNumber = (int) (countResults / PAGE_SIZE);
            }
            if (countResults % PAGE_SIZE != 0) {
                lastPageNumber = (int) (countResults / PAGE_SIZE) + 1;
            }

            TypedQuery<Computer> query = session.createQuery("FROM Computer c ORDER BY c.computerCode");
            query.setFirstResult((pageNumber - 1) * PAGE_SIZE); // offset
            query.setMaxResults(PAGE_SIZE); // limit
            List<Computer> computerList = query.getResultList();

            Map<String, Object> response = new HashMap<>();
            response.put("computers", computerList);
            response.put("totalPages", lastPageNumber);

            return response;
        } catch (Exception e) {
            System.out.println("List All Computers Error");
            return null;
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
