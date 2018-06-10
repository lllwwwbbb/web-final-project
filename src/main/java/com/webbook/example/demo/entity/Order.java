package com.webbook.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
