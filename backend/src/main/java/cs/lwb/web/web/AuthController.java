package cs.lwb.web.web;

import cs.lwb.web.entity.Admin;
import cs.lwb.web.entity.Customer;
import cs.lwb.web.repository.AdminRepository;
import cs.lwb.web.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping(method = RequestMethod.GET)
    String authentication(@RequestParam(value = "userName") String userName,
                          @RequestParam(value = "password") String password) {
        String ret = "Failure";
        Optional<Admin> optionalAdmin = adminRepository.findByUserName(userName);
        Optional<Customer> optionalCustomer = customerRepository.findByUserName(userName);
        if (optionalAdmin.isPresent()) {
            if (optionalAdmin.get().getPassword().equals(password)) {
                ret = "Admin";
            }
        }
        else if (optionalCustomer.isPresent()) {
            if (optionalCustomer.get().getPassword().equals(password)) {
                ret = "Customer";
            }
        }

        return ret;
    }

    @RequestMapping(method = RequestMethod.POST)
    String register(@RequestParam(value = "userName") String userName,
                    @RequestParam(value = "password") String password,
                    @RequestParam(value = "email") String email,
                    @RequestParam(value = "phone") String phone) {
        String ret = "Failure";
        Optional<Customer> optionalCustomer = customerRepository.findByUserName(userName);
        if (!optionalCustomer.isPresent()) {
            customerRepository.save(new Customer(userName, password, email, phone));
            ret = "Success";
        }
        return ret;
    }
}
