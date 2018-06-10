package com.webbook.example.demo.respository;

import com.webbook.example.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRespository extends JpaRepository<Book,Integer> {
    /*获取所有图书Id*/
    @Query(value="select id from book",nativeQuery = true)
    List<Integer> GetAllBookId();
    /*获取id为某整数的全部信息,图片信息还不完整*/
    @Query(value = "select * from book where id=?1",nativeQuery = true)
    Book GetBookById(Integer BookId);
    /*修改图书价格*/
    @Query(value = "update book price=?2 where id=?1",nativeQuery = true)
    void SetPrice(Integer BookId,float price);
    /*返回搜索结果Id*/
    @Query(value="select id from book where name=%?1%",nativeQuery = true)
    List<Integer> SearchByName(String name);
}
