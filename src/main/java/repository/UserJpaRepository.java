package repository;

import entity.AuthorBean;
import entity.UserBean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Optional;

public class UserJpaRepository implements UserRepository {

    private EntityManagerFactory factory;

    public UserJpaRepository(EntityManagerFactory factory) {
        this.factory = factory;
    }

    EntityManager getManager(){
        return factory.createEntityManager();
    }

    @Override
    public void save(UserBean bean) {
        EntityManager em = getManager();
        em.getTransaction().begin();
        em.persist(bean);
        em.getTransaction().commit();
    }

    @Override
    public void update(UserBean bean) {
        EntityManager em = getManager();
        em.getTransaction().begin();
        em.merge(bean);
        em.getTransaction().commit();
    }

    @Override
    public UserBean delete(long id) {
        EntityManager em = getManager();
        em.getTransaction().begin();
        UserBean bean = em.find(UserBean.class, id);
        em.remove(bean);
        em.getTransaction().commit();
        return bean;
    }

    @Override
    public UserBean find(long id) {
        EntityManager em = getManager();
        em.getTransaction().begin();
        UserBean bean = em.find(UserBean.class, id);
        em.getTransaction().commit();
        return bean;
    }

    @Override
    public List<UserBean> findAll() {
        EntityManager em = getManager();
        return em.createQuery("FROM UserBean").getResultList();
    }

    @Override
    public Optional<UserBean> findByLogin(String login) {
        EntityManager em = getManager();
        return Optional.ofNullable(em.createQuery("select u FROM UserBean u where u.login =:login_param", UserBean.class).setParameter("login_param", login).getSingleResult());
    }
}
