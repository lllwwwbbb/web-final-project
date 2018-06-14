package cs.lwb.web.repository;

import cs.lwb.web.entity.Hello;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HelloRepository extends CrudRepository<Hello, Long> {

    List<Hello> findByLastName(String lastName);
}
