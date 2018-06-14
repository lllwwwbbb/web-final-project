package cs.lwb.web.repository;

import cs.lwb.web.entity.BookEntry;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface StockRepository extends CrudRepository<BookEntry, String> {

    List<BookEntry> findByIsStock(Boolean is);

    @Override
    Optional<BookEntry> findById(String s);
}
