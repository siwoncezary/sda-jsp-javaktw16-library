package repository;

import javax.persistence.Persistence;

final public class Repos {
    public static AuthorRepository authorRepo = new AuthorJpaRepository(Persistence.createEntityManagerFactory("library"));
    public static BookRepository bookRepo = new BookJpaRepository(Persistence.createEntityManagerFactory("library"));
}
