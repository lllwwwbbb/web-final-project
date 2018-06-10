package com.webbook.example.demo.entity;

import com.webbook.example.demo.respository.BookentryRespository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

    public void AddBookEntry(Integer BookId,int BookNum,float price){
        BookEntry Be=new BookEntry(BookId,BookNum,0,id);
        Bookentry.add(Be);
        TotalPrice+=price*BookNum;
        BookentryRespository bookentryRespository=null;
        bookentryRespository.AddOrderBookEntry(BookId,BookNum,id);
    }

    public void initBookEntry(){
        BookentryRespository bookentryRespository=null;
        Bookentry=bookentryRespository.GetBookEntryByOrderId(id);
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
