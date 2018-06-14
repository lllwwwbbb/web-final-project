package cs.lwb.web.entity;

import org.apache.el.parser.BooleanNode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class BookEntry {

    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    @ManyToOne
    private Book book;
    private Integer count;
    private Boolean isStock;

    public BookEntry() {}

    public BookEntry(Book book, Integer count) {
        this(book, count, false);
    }

    public BookEntry(Book book, Integer count, Boolean isStock) {
        this.book = book;
        this.count = count;
        this.isStock = isStock;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Boolean getStock() {
        return isStock;
    }

    public void setStock(Boolean stock) {
        isStock = stock;
    }
}
