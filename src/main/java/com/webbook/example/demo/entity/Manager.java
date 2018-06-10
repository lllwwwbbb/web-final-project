package com.webbook.example.demo.entity;

import com.webbook.example.demo.respository.BookRespository;
import com.webbook.example.demo.respository.ImgRespository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "manager")
public class Manager {
    @Id
    @GeneratedValue
    private Integer ManagerId;

    @Column
    private String UserName;

    @Column
    private String Passwd;

    public String getPasswd() {
        return Passwd;
    }

    public String getUserName() {
        return UserName;
    }

    public void setPasswd(String passwd) {
        Passwd = passwd;
    }
    /*添加图书*/
    public void AddBook(String name,float price,String authorName,String publishName,String detail_list,String Abstract,String content,String authorIntroduction,String Url){
        BookRespository bookRespository=null;
        Integer bookId=bookRespository.AddBook(name,price,authorName,publishName,detail_list,Abstract,content,authorIntroduction);
        Img image=new Img(bookId,false,Url);
        ImgRespository imgRespository=null;
        imgRespository.InsertPicForBook(bookId,image.getData());
    }

    public void deleteBook(Integer BookId){

    }
}
