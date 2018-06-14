package cs.lwb.web.repository;

import cs.lwb.web.entity.Admin;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AdminRepository extends CrudRepository<Admin, String> {

    Optional<Admin> findByUserName(String s);
}
