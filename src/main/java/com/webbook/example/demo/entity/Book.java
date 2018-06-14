package com.webbook.example.demo.entity;

import com.webbook.example.demo.repository.BookRepository;
import com.webbook.example.demo.repository.ImgRepository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.IOException;

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

    public void initBook() throws IOException {
       featureImgUrl = this.getFeatureImgUrl();
       picImgUrl=this.getPicImgUrl();
    }

    public String getFeatureImgUrl() throws IOException {
        ImgRepository imgRepository = null;
        Img image= imgRepository.findFeatureImgByBookId(id);
        return image.GetUrl();
    }

    public String[] getPicImgUrl() throws IOException {
        ImgRepository imgRepository = null;
        Img[] imgs= imgRepository.findAllPicByBookId(id);
        String []Urllist=null;
        for(int i=0;i<imgs.length;i++){
            Urllist[i]=imgs[i].GetUrl();
        }
        return Urllist;
    }

    public void setPrice(Float price) {
        BookRepository bookRepository =null;
        bookRepository.SetPrice(id,price);
    }
}
