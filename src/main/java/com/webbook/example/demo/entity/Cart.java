package com.webbook.example.demo.entity;

import com.webbook.example.demo.respository.BookentryRespository;

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
        BookentryRespository bookentryRespository=null;
        Bookentry=bookentryRespository.GetBookEntryByCartId(id);
    }
    public void AddBookentry(Integer BookId,int Num){
        BookEntry Be=new BookEntry(BookId,Num,1,id);
        Bookentry.add(Be);
        BookentryRespository bookentryRespository=null;
        bookentryRespository.AddCartBookEntry(BookId,Num,id);
    }

    public void deleteBookEntry(Integer BookId){
        for (BookEntry be:Bookentry) {
            if(be.getBookId()==BookId)
                Bookentry.remove(be);
        }
        BookentryRespository bookentryRespository=null;
        bookentryRespository.DeleteCartBookByBookId(BookId);
    }
    public void setCurTotalPrice(float curTotalPrice) {
        CurTotalPrice = curTotalPrice;
    }

    public float getCurTotalPrice() {
        return CurTotalPrice;
    }
}
