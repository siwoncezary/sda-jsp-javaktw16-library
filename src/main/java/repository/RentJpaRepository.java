package repository;

import entity.BookBean;
import entity.RentBean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class RentJpaRepository implements RentRepository {
    private EntityManagerFactory factory;
    private EntityManager em;

    public RentJpaRepository(EntityManagerFactory factory) {
        this.factory = factory;
        em = factory.createEntityManager();
    }

    EntityManager getManager(){
        return em;
    }

    @Override
    public void save(RentBean bean) {
        em.getTransaction().begin();
        em.persist(bean);
        em.getTransaction().commit();
    }

    @Override
    public void update(RentBean bean) {
        em.getTransaction().begin();
        em.merge(bean);
        em.getTransaction().commit();
    }

    @Override
    public RentBean delete(long id) {
        em.getTransaction().begin();
        RentBean bean = em.find(RentBean.class, id);
        em.remove(bean);
        em.getTransaction().commit();
        return bean;
    }

    @Override
    public RentBean find(long id) {
        em.getTransaction().begin();
        RentBean bean = em.find(RentBean.class, id);
        em.getTransaction().commit();
        return bean;
    }

    @Override
    public List<RentBean> findAll() {
        return em.createQuery("FROM RentBean").getResultList();
    }

    @Override
    public List<BookBean> findRentedBooks() {
        return em.createQuery("Select r.book FROM RentBean r where r.returnDate is null", BookBean.class).getResultList();
    }


}
