package cs.lwb.web.web;

import cs.lwb.web.entity.Book;
import cs.lwb.web.entity.BookEntry;
import cs.lwb.web.repository.BookRepository;
import cs.lwb.web.repository.StockRepository;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private StockRepository stockRepository;

    @RequestMapping(method = RequestMethod.GET)
    List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    String addBook(@RequestParam(value = "name")String name,
                   @RequestParam(value = "author")String author,
                   @RequestParam(value = "price")Double price) {
        String ret = "Success";
        Book book = bookRepository.save(new Book(name, author, price, name));
        stockRepository.save(new BookEntry(book, 0, true));
        return ret;
    }
}
