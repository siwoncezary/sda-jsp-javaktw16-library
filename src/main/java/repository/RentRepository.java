package repository;

import entity.BookBean;
import entity.RentBean;
import entity.UserBean;

import java.util.List;
import java.util.Optional;

public interface RentRepository {
    void save(RentBean bean);
    void update(RentBean bean);
    RentBean delete(long id);
    RentBean find(long id);
    List<RentBean> findAll();
    List<BookBean> findRentedBooks();
}
