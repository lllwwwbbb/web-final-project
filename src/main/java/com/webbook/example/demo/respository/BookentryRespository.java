package com.webbook.example.demo.respository;

import com.webbook.example.demo.entity.BookEntry;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookentryRespository extends JpaRepository<BookEntry,Integer> {
    //添加order的BookEntry
    @Query(value = "insert into bookentry (bookId,bookNum,Property,orderId) values(?1,?2,0,?3)",nativeQuery = true)
    void AddOrderBookEntry(Integer bookId,int bookNum,Integer orderId);
    //添加cart的BookEntry
    @Query(value = "insert into bookentry (bookId,bookNum,Property,cartId) values(?1,?2,1,?3)",nativeQuery = true)
    void AddCartBookEntry(Integer bookId,int bookNum,Integer CartId);

    //通过orderId获取所有BookEntry
    @Query(value = "select * from bookentry where orderId=?1",nativeQuery = true)
    List<BookEntry> GetBookEntryByOrderId(Integer OrderId);

    //通过cartId获得所有BookEntry
    @Query(value = "select * from bookentry where cartId=?1",nativeQuery = true)
    List<BookEntry> GetBookEntryByCartId(Integer CartId);

    //通过BookId删除cart的BookEntry
    @Query(value = "delete from bookentry where Property=1 and BookId=?1",nativeQuery = true)
    void DeleteCartBookByBookId(Integer BookId);

    //通过orderId删除订单
    @Query(value = "delete from bookentry where orderId=?1",nativeQuery = true)
    void DeleteBookentryByOrderId(Integer orderId);

    //添加库存信息
    @Query(value = "insert into bookentry (bookId,bookNum,Property) values (?1,2,?2)",nativeQuery = true)
    void InsertStock(Integer BookId,int BookNum);

    //通过bookId修改库存信息
    @Query(value = "update bookentry bookNum=?2 where bookId=?1 and Property=2",nativeQuery = true)
    void SetBookNum(Integer BookId,int Num);

}
