package cs.lwb.web.web;


import cs.lwb.web.entity.Customer;
import cs.lwb.web.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping(method = RequestMethod.GET)
    Customer getCustomer(@RequestParam(value = "userName") String userName) {
        Optional<Customer> optionalCustomer = customerRepository.findByUserName(userName);
        return optionalCustomer.get();
    }

    @RequestMapping(method = RequestMethod.POST)
    String setCustomer(@RequestParam(value = "userName") String userName,
                         @RequestParam(value = "password") String password,
                         @RequestParam(value = "email") String email,
                         @RequestParam(value = "phone") String phone) {
        Optional<Customer> optionalCustomer = customerRepository.findByUserName(userName);
        Customer customer = optionalCustomer.get();
        customer.setPassword(password);
        customer.setEmail(email);
        customer.setPhone(phone);
        customerRepository.save(customer);
        return "Success";
    }
}
