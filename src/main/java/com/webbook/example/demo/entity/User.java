package com.webbook.example.demo.entity;

import com.webbook.example.demo.repository.CartRepository;
import com.webbook.example.demo.repository.OrderRepository;
import com.webbook.example.demo.repository.UserRepository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.IOException;
import java.util.Date;
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

    private Integer CartId;

    private Cart cart;

    private List<Order> orderList;

    public Integer getCart() {
        return CartId;
    }

    public List<Integer> getOrderIdList() {
        return OrderIdList;
    }

    public Cart GetCart(){
        return cart;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void init() throws IOException {
        CartRepository cartRepository =null;
        CartId= cartRepository.GetCartId(UserId);
        cart= cartRepository.getOne(CartId);
        OrderRepository orderRepository =null;
        OrderIdList= orderRepository.GetOrderListByUserId(UserId);
        for(Integer id:OrderIdList){
            Order order= orderRepository.getOne(id);
            order.initBookEntry();
            orderList.add(order);
        }
    }
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
        UserRepository userRepository =null;
        userRepository.ChangeAddress(name,address);
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
        UserRepository userRepository =null;
        userRepository.ChangePasswd(name,passwd);
    }

    public void AddCart(Integer Bookid,int num){
        cart.AddBookentry(Bookid,num);
    }
    public void Addorder(List<BookEntry> Be, float TotalPrice, Date date) throws IOException {
        OrderRepository orderRepository =null;
        Integer NewOrderId= orderRepository.AddOrder(TotalPrice,date,getUserId());
        Order newOrder=new Order();
        for (BookEntry b:Be) {
            newOrder.AddBookEntry(b.getBookId(),b.getBookNum());
        }
        newOrder.setDate(date.toString());
        newOrder.setId(NewOrderId);
        newOrder.setTotalPrice(TotalPrice);
        newOrder.setUserId(getUserId());
        newOrder.initBookEntry();
        orderList.add(newOrder);
    }
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
        UserRepository userRepository =null;
        userRepository.ChangePhone(name,phoneNum);
    }
}
