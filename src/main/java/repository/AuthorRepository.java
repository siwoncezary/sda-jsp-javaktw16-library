package repository;

import entity.AuthorBean;
import java.util.List;

public interface AuthorRepository {
    void save(AuthorBean bean);
    void update(AuthorBean bean);
    AuthorBean delete(long id);
    AuthorBean find(long id);
    List<AuthorBean> findAll();
}
