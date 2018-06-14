package com.webbook.example.demo.entity;

import com.webbook.example.demo.repository.BookRepository;
import com.webbook.example.demo.repository.BookentryRepository;
import com.webbook.example.demo.repository.ImgRepository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.IOException;
import java.util.List;

@Entity(name = "manager")
public class Manager {
    @Id
    @GeneratedValue
    private Integer ManagerId;

    @Column
    private String UserName;

    @Column
    private String Passwd;

    private List<BookEntry> BookEntryList;

    public void initBookEntryList() throws IOException {
        BookentryRepository bookentryRepository =null;
        BookEntryList= bookentryRepository.GetAll();
        for (BookEntry be:BookEntryList) {
            be.initBook();
        }
    }

    public void AddNewBook(String name,float price,String authorName,String publishName,String detail_list,String Abstract,String content,String authorIntroduction,int num) throws IOException {
        BookRepository bookRepository =null;
        Integer BookId= bookRepository.AddBook(name, price, authorName, publishName, detail_list, Abstract, content, authorIntroduction);
        BookentryRepository bookentryRepository =null;
        bookentryRepository.InsertStock(BookId,num);
        BookEntry be=new BookEntry(BookId,num);
        be.initBook();
        BookEntryList.add(be);
    }
    public void SetBookNum(Integer BookId,int Num){
        for (BookEntry be:BookEntryList){
            if(be.getBookId()==BookId)
                be.setBookNum(Num);
                BookentryRepository bookentryRepository =null;
                bookentryRepository.SetBookNum(BookId,Num);
        }
    }

    public List<BookEntry> getBookEntryList() {
        return BookEntryList;
    }

    public BookEntry GetById(Integer id){
        for (BookEntry Be:BookEntryList
             ) {
            if(Be.getBookId()==id)
                return Be;
        }
        return null;
    }
    public List<BookEntry> SearchByName(String Name){
        BookRepository bookRepository =null;
        List<Integer> BookIdList= bookRepository.SearchByName(Name);
        List<BookEntry> result=null;
        for(Integer id:BookIdList){
            result.add(GetById(id));
        }
        return result;
    }

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
        BookRepository bookRepository =null;
        Integer bookId= bookRepository.AddBook(name,price,authorName,publishName,detail_list,Abstract,content,authorIntroduction);
        Img image=new Img(bookId,false,Url);
        ImgRepository imgRepository =null;
        imgRepository.InsertPicForBook(bookId,image.getData());
    }

    public void deleteBook(Integer BookId){

    }
}
