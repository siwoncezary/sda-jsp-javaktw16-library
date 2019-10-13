package repository;

import entity.BookBean;
import entity.RentBean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class RentJpaRepository implements RentRepository {
    private EntityManagerFactory factory;

    public RentJpaRepository(EntityManagerFactory factory) {
        this.factory = factory;
    }

    EntityManager getManager(){
        return factory.createEntityManager();
    }

    @Override
    public void save(RentBean bean) {
        EntityManager em = getManager();
        em.getTransaction().begin();
        em.persist(bean);
        em.getTransaction().commit();
    }

    @Override
    public void update(RentBean bean) {
        EntityManager em = getManager();
        em.getTransaction().begin();
        em.merge(bean);
        em.getTransaction().commit();
    }

    @Override
    public RentBean delete(long id) {
        EntityManager em = getManager();
        em.getTransaction().begin();
        RentBean bean = em.find(RentBean.class, id);
        em.remove(bean);
        em.getTransaction().commit();
        return bean;
    }

    @Override
    public RentBean find(long id) {
        EntityManager em = getManager();
        em.getTransaction().begin();
        RentBean bean = em.find(RentBean.class, id);
        em.getTransaction().commit();
        return bean;
    }

    @Override
    public List<RentBean> findAll() {
        EntityManager em = getManager();
        return em.createQuery("FROM RentBean").getResultList();
    }
}
