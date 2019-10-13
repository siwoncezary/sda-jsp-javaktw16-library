package repository;

import javax.persistence.Persistence;

final public class Repos {
    public static final AuthorRepository authorRepo = new AuthorJpaRepository(Persistence.createEntityManagerFactory("library"));
    public static final BookRepository bookRepo = new BookJpaRepository(Persistence.createEntityManagerFactory("library"));
    public static final UserRepository userRepo = new UserJpaRepository(Persistence.createEntityManagerFactory("library"));
}
