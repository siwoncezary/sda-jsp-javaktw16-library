package repository;

import entity.AuthorBean;
import entity.UserBean;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    void save(UserBean bean);
    void update(UserBean bean);
    UserBean delete(long id);
    UserBean find(long id);
    List<UserBean> findAll();
    Optional<UserBean> findByLogin(String login);
}
