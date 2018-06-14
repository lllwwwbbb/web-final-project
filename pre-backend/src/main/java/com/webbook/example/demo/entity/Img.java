package com.webbook.example.demo.entity;
import com.webbook.example.demo.repository.ImgRepository;

import javax.imageio.ImageIO;
import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import java.awt.image.BufferedImage;
import java.io.*;

@Entity(name="img")
public class Img  {
    @Id
    @GeneratedValue
    private Integer Idimg;

    @Column
    private Integer bookId;

    @Column
    private Boolean property;//0是指封面图片，1是指详情图片

    @Column
    private byte[] data;

    Img(Integer bookId,boolean property,String url){
        this.bookId=bookId;
        this.property=property;
        try {
            this.SetDataFromUrl(url);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

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

    public byte[] getData() {
        return data;
    }

    public void SetDataFromUrl(String Url) throws FileNotFoundException {
        File f = new File(Url);
        BufferedImage bi;
        try {
            bi = ImageIO.read(f);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bi, "jpg", baos);  //经测试转换的图片是格式这里就什么格式，否则会失真
            data= baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void SaveToDB(){
        ImgRepository imgRepository =null;
        imgRepository.InsertPicForBook(bookId,data);
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
