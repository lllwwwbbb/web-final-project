package com.webbook.example.demo.entity;

import com.webbook.example.demo.respository.UserRespository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue
    private Integer UserId;

    @Column
    private String name;

    @Column
    private String passwd;

    @Column
    private String phoneNum;

    @Column
    private String address;

    private List<Integer> OrderIdList;

    private List<Integer> CartIdList;

    public String getName() {
        return name;
    }

    public Integer getUserId() {
        return UserId;
    }

    public String getAddress() {
        return address;
    }

    public String getPasswd() {
        return passwd;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setAddress(String address) {
        this.address = address;
        UserRespository userRespository=null;
        userRespository.ChangeAddress(name,address);
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
        UserRespository userRespository=null;
        userRespository.ChangePasswd(name,passwd);
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
        UserRespository userRespository=null;
        userRespository.ChangePhone(name,phoneNum);
    }
}
