package com.webbook.example.demo.respository;

import com.webbook.example.demo.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRespository extends JpaRepository<Cart,Integer> {
    //添加购物车
    @Query(value = "insert if not exist into cart(UserId)values(?1);",nativeQuery = true)
    void AddCart(Integer UserId);

    //删除购物车
    @Query(value = "delete if exist from cart where UserId=?1;",nativeQuery = true)
    void DeleteCart(Integer UserId);

    //获取购物车Id
    @Query(value = "select id from cart where UserId=?1;",nativeQuery = true)
    Integer GetCartId(Integer UserId);

}
