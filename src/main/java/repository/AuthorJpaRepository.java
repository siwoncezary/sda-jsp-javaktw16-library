package repository;

import entity.AuthorBean;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class AuthorJpaRepository implements AuthorRepository{
    private EntityManagerFactory factory;

    public AuthorJpaRepository(EntityManagerFactory factory) {
        this.factory = factory;
    }

    EntityManager getManager(){
        return factory.createEntityManager();
    }

    @Override
    public void save(AuthorBean bean) {
        EntityManager em = getManager();
        em.getTransaction().begin();
        em.persist(bean);
        em.getTransaction().commit();
    }

    @Override
    public void update(AuthorBean bean) {
        EntityManager em = getManager();
        em.getTransaction().begin();
        em.merge(bean);
        em.getTransaction().commit();
    }

    @Override
    public AuthorBean delete(long id) {
        EntityManager em = getManager();
        em.getTransaction().begin();
        AuthorBean bean = em.find(AuthorBean.class, id);
        em.remove(bean);
        em.getTransaction().commit();
        return bean;
    }

    @Override
    public AuthorBean find(long id) {
        EntityManager em = getManager();
        em.getTransaction().begin();
        AuthorBean bean = em.find(AuthorBean.class, id);
        em.getTransaction().commit();
        return bean;
    }

    @Override
    public List<AuthorBean> findAll() {
        EntityManager em = getManager();
        return em.createQuery("FROM BookBean").getResultList();

    }
}
