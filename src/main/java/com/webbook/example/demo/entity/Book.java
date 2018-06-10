package com.webbook.example.demo.entity;

import com.webbook.example.demo.respository.BookRespository;
import com.webbook.example.demo.respository.ImgRespository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Entity(name = "book")
public  class Book {
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String name;

    @Column
    private Float price;

    @Column
    private String authorName;

    @Column
    private String publishName;

    @Column
    private String detail_list;

    @Column
    private String Abstract;

    @Column
    private String content;

    @Column
    private String authorIntroduction;

    //详细特征图片，在详细展示中
    private String featureImgUrl=null;
    //封面图片
    private String[] picImgUrl=null;

    public Float getPrice() {
        return price;
    }

    public Integer getId() {
        return id;
    }

    public String getAbstract() {
        return Abstract;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getAuthorIntroduction() {
        return authorIntroduction;
    }
    /*返回书的印刷信息、isbn等*/
    public String[] getDetail_list() {
        String [] detailList=detail_list.split(";");
        return detailList;
    }

    public String getName() {
        return name;
    }

    public String getPublishName() {
        return publishName;
    }

    public String getContent() {
        return content;
    }

    public String getFeatureImgUrl() throws IOException {
        ImgRespository imgRespository = null;
        Img image=imgRespository.findFeatureImgByBookId(id);
        return image.GetUrl();
    }

    public String[] getPicImgUrl() throws IOException {
        ImgRespository imgRespository = null;
        Img[] imgs=imgRespository.findAllPicByBookId(id);
        String []Urllist=null;
        for(int i=0;i<imgs.length;i++){
            Urllist[i]=imgs[i].GetUrl();
        }
        return Urllist;
    }
}
