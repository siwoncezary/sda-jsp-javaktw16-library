package repository;

import entity.BookBean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class BookJpaRepository implements BookRepository {
    private EntityManagerFactory factory;
    private EntityManager em;

    public BookJpaRepository(EntityManagerFactory factory) {
        this.factory = factory;
        em = factory.createEntityManager();
    }

    EntityManager getManager(){
        return em;
    }

    @Override
    public void save(BookBean bean) {
        em.getTransaction().begin();
        em.persist(bean);
        em.getTransaction().commit();
    }

    @Override
    public void update(BookBean bean) {
        em.getTransaction().begin();
        em.merge(bean);
        em.getTransaction().commit();
    }

    @Override
    public BookBean delete(long id) {
        em.getTransaction().begin();
        BookBean bean = em.find(BookBean.class, id);
        em.remove(bean);
        em.getTransaction().commit();
        return bean;
    }

    @Override
    public BookBean find(long id) {
        em.getTransaction().begin();
        BookBean bean = em.find(BookBean.class, id);
        em.getTransaction().commit();
        return bean;
    }

    @Override
    public List<BookBean> findAll() {
        em.getTransaction().begin();
        List<BookBean> result = em.createQuery("FROM BookBean").getResultList();
        em.getTransaction().commit();
        return result;

    }
}
