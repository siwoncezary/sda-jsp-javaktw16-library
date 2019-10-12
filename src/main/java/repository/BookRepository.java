package repository;

import entity.BookBean;

import java.util.List;

public interface BookRepository {
    void save(BookBean bean);
    void update(BookBean bean);
    BookBean delete(long id);
    BookBean find(long id);
    List<BookBean> findAll();
}
