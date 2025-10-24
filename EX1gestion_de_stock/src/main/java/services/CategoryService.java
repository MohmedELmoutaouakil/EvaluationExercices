package services;

import classes.Category;
import dao.IDao;
import utile.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
public class CategoryService implements IDao<Category> {
    @Override
    public Category save(Category c) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(c);
            tx.commit();
            return c;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    @Override
    public Category update(Category category) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            category = (Category) session.merge(category);
            tx.commit();
            return category;
        } catch (Exception e) { if (tx != null) tx.rollback(); throw e; }
    }

    @Override
    public void delete(Category c) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.remove(session.contains(c) ? c : session.merge(c));
            tx.commit();
        } catch (Exception e) { if (tx != null) tx.rollback(); throw e; }
    }

    @Override
    public Category findById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Category.class, id);
        }
    }

    @Override
    public List<Category> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Category", Category.class).getResultList();
        }
    }
}
