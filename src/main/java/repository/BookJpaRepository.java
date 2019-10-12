package repository;

import entity.BookBean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class BookJpaRepository implements BookRepository {
    private EntityManagerFactory factory;

    public BookJpaRepository(EntityManagerFactory factory) {
        this.factory = factory;
    }

    EntityManager getManager(){
        return factory.createEntityManager();
    }

    @Override
    public void save(BookBean bean) {
        EntityManager em = getManager();
        em.getTransaction().begin();
        em.persist(bean);
        em.getTransaction().commit();
    }

    @Override
    public void update(BookBean bean) {
        EntityManager em = getManager();
        em.getTransaction().begin();
        em.merge(bean);
        em.getTransaction().commit();
    }

    @Override
    public BookBean delete(long id) {
        EntityManager em = getManager();
        em.getTransaction().begin();
        BookBean bean = em.find(BookBean.class, id);
        em.remove(bean);
        em.getTransaction().commit();
        return bean;
    }

    @Override
    public BookBean find(long id) {
        EntityManager em = getManager();
        em.getTransaction().begin();
        BookBean bean = em.find(BookBean.class, id);
        em.getTransaction().commit();
        return bean;
    }

    @Override
    public List<BookBean> findAll() {
        EntityManager em = getManager();
        return em.createQuery("FROM BookBean").getResultList();

    }
}
