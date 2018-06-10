package com.webbook.example.demo.respository;

import com.webbook.example.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
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

    /*添加图书*/
    @Query(value = "insert into book (name,price,authorName,publishName,detail_list,abstract,content,authorIntroduction) values (?1,?2,?3,?4,?5,?6?7?8);" +
            "select id from book where name=?1 and price=?2 and authorName=?3;select last_insert_id();",nativeQuery = true)
    Integer AddBook(String name,float price,String authorName,String publishName,String detail_list,String Abstract,String content,String authorIntroduction);
}
