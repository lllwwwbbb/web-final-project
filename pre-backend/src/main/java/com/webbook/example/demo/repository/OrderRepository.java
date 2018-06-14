package com.webbook.example.demo.repository;

import com.webbook.example.demo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
    //添加order
    @Query(value = "insert into order (TotalPrice,date,UserId) values (?1,?2,?3);" +
            "select last_insert_id();",nativeQuery = true)
    Integer AddOrder(float TotalPrice, Date Date,Integer UserId);

    //删除User的所有order
    @Query(value = "delete from order where UserId=?1",nativeQuery = true)
    void DeleteAllOrder(Integer UserId);

    //获取一个用户的所有订单订单号
    @Query(value = "select id from order where UserId=?1 order by date",nativeQuery = true)
    List<Integer> GetOrderListByUserId(Integer UserId);

}
