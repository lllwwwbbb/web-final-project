package com.webbook.example.demo.entity;

import com.webbook.example.demo.repository.BookentryRepository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity(name = "cart")
public class Cart {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private Integer UserId;

    private float CurTotalPrice;
    private List<BookEntry> Bookentry;

    public List<BookEntry> getBookentry() {
        return Bookentry;
    }

    public Integer getUserId() {
        return UserId;
    }

    public void initBookentry(){
        BookentryRepository bookentryRepository =null;
        Bookentry= bookentryRepository.GetBookEntryByCartId(id);
    }
    public void AddBookentry(Integer BookId,int Num){
        BookEntry Be=new BookEntry(BookId,Num,1,id);
        Bookentry.add(Be);
        BookentryRepository bookentryRepository =null;
        bookentryRepository.AddCartBookEntry(BookId,Num,id);
    }

    public void deleteBookEntry(Integer BookId){
        for (BookEntry be:Bookentry) {
            if(be.getBookId()==BookId)
                Bookentry.remove(be);
        }
        BookentryRepository bookentryRepository =null;
        bookentryRepository.DeleteCartBookByBookId(BookId);
    }
    public void setCurTotalPrice(float curTotalPrice) {
        CurTotalPrice = curTotalPrice;
    }

    public float getCurTotalPrice() {
        return CurTotalPrice;
    }
}
