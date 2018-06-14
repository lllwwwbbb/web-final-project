package cs.lwb.web.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class BookEntry {

    @Id
    @GeneratedValue
    private String id;
    @OneToOne
    private Book book;
    private Integer count;

    public BookEntry() {}

    public BookEntry(Book book, Integer count) {
        this.book = book;
        this.count = count;
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
}
