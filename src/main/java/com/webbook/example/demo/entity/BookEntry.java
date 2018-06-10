package com.webbook.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
    private boolean property;//false为order的bookentry；true为cart的bookentry

    @Column
    private Integer orderId;

    @Column
    private Integer cartId;

    public boolean isProperty() {
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

    BookEntry(Integer bookId,int bookNum, boolean property,Integer integer){
        this.bookId=bookId;
        this.bookNum=bookNum;
        this.property=property;
        if(property)
            orderId=integer;
        else
            cartId=integer;
    }
}
