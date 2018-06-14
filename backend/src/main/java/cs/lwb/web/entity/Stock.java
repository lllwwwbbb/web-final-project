package cs.lwb.web.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Stock {

    @Id
    @GeneratedValue
    private String id;
    @OneToMany
    private List<BookEntry> bookEntryList;

    public Stock() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<BookEntry> getBookEntryList() {
        return bookEntryList;
    }

    public void setBookEntryList(List<BookEntry> bookEntryList) {
        this.bookEntryList = bookEntryList;
    }
}
