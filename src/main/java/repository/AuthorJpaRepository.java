package repository;

import entity.AuthorBean;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class AuthorJpaRepository implements AuthorRepository{
    private EntityManagerFactory factory;
    private EntityManager em;

    public AuthorJpaRepository(EntityManagerFactory factory) {
        this.factory = factory;
        em = factory.createEntityManager();
    }

    EntityManager getManager(){
        return em;
    }

    @Override
    public void save(AuthorBean bean) {
        em.getTransaction().begin();
        em.persist(bean);
        em.getTransaction().commit();
    }

    @Override
    public void update(AuthorBean bean) {
        em.getTransaction().begin();
        em.merge(bean);
        em.getTransaction().commit();
    }

    @Override
    public AuthorBean delete(long id) {
        em.getTransaction().begin();
        AuthorBean bean = em.find(AuthorBean.class, id);
        em.remove(bean);
        em.getTransaction().commit();
        return bean;
    }

    @Override
    public AuthorBean find(long id) {
        em.getTransaction().begin();
        AuthorBean bean = em.find(AuthorBean.class, id);
        em.getTransaction().commit();
        return bean;
    }

    @Override
    public List<AuthorBean> findAll() {
        return em.createQuery("FROM AuthorBean").getResultList();

    }
}
