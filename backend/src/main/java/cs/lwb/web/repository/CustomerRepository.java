package cs.lwb.web.repository;

import cs.lwb.web.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, String> {

    Optional<Customer> findByUserName(String s);
}
