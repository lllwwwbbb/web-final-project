package com.webbook.example.demo.entity;

import com.webbook.example.demo.respository.BookentryRespository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.IOException;
import java.util.List;

@Entity(name = "order")
public class Order {
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private float TotalPrice;

    @Column
    private  String date;

    @Column
    private Integer UserId;

    private List<BookEntry> Bookentry;

    public void setBookentry(List<BookEntry> bookentry) {
        Bookentry = bookentry;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTotalPrice(float totalPrice) {
        TotalPrice = totalPrice;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
    }


    public void AddBookEntry(Integer BookId, int BookNum) throws IOException {
        BookEntry Be=new BookEntry(BookId,BookNum,0,id);
        Be.initBook();
        Bookentry.add(Be);
        BookentryRespository bookentryRespository=null;
        BookEntry B=bookentryRespository.GetBookEntryById(BookId);
        int Num=B.getBookNum()-BookNum;
        bookentryRespository.SetBookNum(BookId,Num);
        bookentryRespository.AddOrderBookEntry(BookId,BookNum,id);
    }

    public void initBookEntry() throws IOException {
        BookentryRespository bookentryRespository=null;
        Bookentry=bookentryRespository.GetBookEntryByOrderId(id);
        for (BookEntry be:Bookentry) {
            be.initBook();
        }
    }

    public List<BookEntry> getBookentry() {
        return Bookentry;
    }

    public Integer getUserId() {
        return UserId;
    }

    public float getTotalPrice() {
        return TotalPrice;
    }

    public String getDate() {
        return date;
    }

    public Integer getId() {
        return id;
    }

}
