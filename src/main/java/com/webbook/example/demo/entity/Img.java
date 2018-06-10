package com.webbook.example.demo.entity;
import com.webbook.example.demo.respository.ImgRespository;

import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@Entity(name="img")
public class Img  {
    @Id
    @GeneratedValue
    private Integer Idimg;

    @Column
    private Integer bookId;

    @Column
    private Boolean property;

    @Column
    private byte[] data;



    public Integer getId() {

        return Idimg;

    }

    public Integer getBookId() {

        return bookId;

    }

    public String GetUrl() throws IOException {
        String url="resource/"+bookId+"/"+Idimg+".jpg";
        OutputStream out=new FileOutputStream(url);
        out.write(data);
        out.flush();
        out.close();
        return url;
    }



    @Override

    public String toString(){
        try {
            return GetUrl();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            return "NULL";
        }
    }
}
