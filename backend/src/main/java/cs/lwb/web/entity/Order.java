package cs.lwb.web.entity;

import org.aspectj.weaver.ast.Or;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Order {

    @Id
    @GeneratedValue
    private String id;
    private Double totalPrice;
    private String date;
    @OneToMany
    private List<BookEntry> bookEntryList;

    public Order() {}

    public Order(Double totalPrice, String date, List<BookEntry> bookEntryList) {
        this.totalPrice = totalPrice;
        this.date = date;
        this.bookEntryList = bookEntryList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<BookEntry> getBookEntryList() {
        return bookEntryList;
    }

    public void setBookEntryList(List<BookEntry> bookEntryList) {
        this.bookEntryList = bookEntryList;
    }
}
