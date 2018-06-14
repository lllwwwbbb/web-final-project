package cs.lwb.web.web;

import cs.lwb.web.entity.Hello;
import cs.lwb.web.repository.HelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @Autowired
    private HelloRepository helloRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String getHello(@RequestParam(value = "lastName") String lastName) {
        List<Hello> helloList = helloRepository.findByLastName(lastName);
        String helloString = "";
        for (Hello hello : helloList)
            helloString += hello;
        return "get hello: " + helloString;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String postHello(@RequestParam(value = "firstName") String firstName,
                            @RequestParam(value = "lastName") String lastName) {
        helloRepository.save(new Hello(firstName, lastName));
        return "post hello: success";
    }
}
