package com.webbook.example.demo.entity;

import com.webbook.example.demo.repository.BookRepository;
import com.webbook.example.demo.repository.BookentryRepository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.IOException;

@Entity(name = "bookentry")
public class BookEntry {
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private Integer bookId;

    @Column
    private int bookNum;

    @Column
    private int property;//0为order的bookentry；1为cart的bookentry,2为库存

    @Column
    private Integer orderId;

    @Column
    private Integer cartId;

    private Book book;

    public Book getBook() {
        return book;
    }

    public void initBook() throws IOException {
        BookRepository bookRepository =null;
        book= bookRepository.GetBookById(bookId);
        book.initBook();
    }
    public int GetProperty() {
        return property;
    }

    public int getBookNum() {
        return bookNum;
    }

    public Integer getBookId() {
        return bookId;
    }

    public Integer getCartId() {
        return cartId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setBookNum(int num){
        BookentryRepository bookentryRepository =null;
        bookentryRepository.SetBookNum(bookId,num);
        bookNum=num;
    }

    BookEntry(Integer bookId,int bookNum, int property,Integer integer){
        this.bookId=bookId;
        this.bookNum=bookNum;
        this.property=property;
        if(property==0)
            orderId=integer;
        else
            cartId=integer;
    }
    BookEntry(Integer bookId,int bookNum){
        this.bookId=bookId;
        this.bookNum=bookNum;
        this.property=2;
    }
}
