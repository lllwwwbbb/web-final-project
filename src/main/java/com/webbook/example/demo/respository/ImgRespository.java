package com.webbook.example.demo.respository;

import com.webbook.example.demo.entity.Img;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;

import org.springframework.data.jpa.repository.Query;

import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.criteria.CriteriaBuilder;

public interface ImgRespository extends JpaRepository<Img,Integer>{
    /*通过bookId查找封面图片*/
    @Query(value="SELECT * FROM img where bookId=?1 and property=0",nativeQuery = true)
    Img[] findAllPicByBookId(Integer BookId);

    /*通过bookId查找细节介绍图片*/
    @Query(value="select * from img where bookId=?1 and property=1",nativeQuery = true)
    Img findFeatureImgByBookId(Integer BookId);

    /*删除某图书的所有图片*/
    @Query(value="delete from img where bookId=?1",nativeQuery = true)
    void deleteAllImgByBookId(Integer BookId);

    /*添加某书的封面图片*/
    @Query(value = "insert into img (bookId,property,data) values (?1,0,?2)",nativeQuery = true)
    void InsertPicForBook(Integer bookId,byte[] data);
}
