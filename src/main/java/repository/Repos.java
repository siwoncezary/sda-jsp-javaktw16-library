package repository;

import javax.persistence.Persistence;

final public class Repos {
    public static AuthorRepository authorRepo = new AuthorJpaRepository(Persistence.createEntityManagerFactory("library"));

}
