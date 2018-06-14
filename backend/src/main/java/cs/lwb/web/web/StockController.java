package cs.lwb.web.web;

import cs.lwb.web.entity.Book;
import cs.lwb.web.entity.BookEntry;
import cs.lwb.web.repository.BookRepository;
import cs.lwb.web.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(value = "/stock")
public class StockController {

    @Autowired
    private StockRepository stockRepository;

    @RequestMapping(method = RequestMethod.GET)
    List<BookEntry> getStock() {
        return stockRepository.findByIsStock(true);
    }

    @RequestMapping(method = RequestMethod.POST)
    String addStock(@RequestParam(value = "id") String id,
                    @RequestParam(value = "count") Integer count) {
        String ret = "Failure";
        Optional<BookEntry> optionalBook = stockRepository.findById(id);
        if (optionalBook.isPresent()) {
            optionalBook.get().setCount(count);
            stockRepository.save(optionalBook.get());
            ret = "Success";
        }
        return ret;
    }
}
