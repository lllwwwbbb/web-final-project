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
    private int property;//0为order的bookentry；1为cart的bookentry,2为库存

    @Column
    private Integer orderId;

    @Column
    private Integer cartId;

    public int isProperty() {
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
