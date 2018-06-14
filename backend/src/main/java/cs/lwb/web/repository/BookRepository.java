package cs.lwb.web.repository;

import cs.lwb.web.entity.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, String> {

    @Override
    Optional<Book> findById(String id);

    @Override
    List<Book> findAll();

    Optional<Book> findByName(String name);
}
