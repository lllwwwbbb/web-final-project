package com.webbook.example.demo.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.webbook.example.demo.entity.Book;
import com.webbook.example.demo.entity.User;
import com.webbook.example.demo.repository.BookRepository;
import com.webbook.example.demo.framework.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Repository
@RestController
public class BookController extends BaseController{
    @Autowired
    private BookRepository bookRepository;

    //查询所有图书
    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public Response queryBooks(Request request){
        Response response = new Response();

        try{
            List<Book> books = bookRepository.findAll();
            JSONArray resultArray = new JSONArray();
            for (Book book:books) {
                JSONObject jsonObject = JSON.parseObject(JSONObject.toJSONString(book));
                resultArray.add(jsonObject);
                response.data = resultArray;
                response.status = ResponseType.SUCCESS;
            }
            response.status = ResponseType.SUCCESS;
        } catch (Exception e){
            e.printStackTrace();
            response.status = ResponseType.FAILURE;
            response.message = e.getMessage();
        }
        return response;
    }

    //添加图书
    @RequestMapping(value = "/book",method = RequestMethod.POST)
    public Response addBook(JSONObject params,List<MultipartFile> files,User user) {
        Response response = new Response();

        try{
            /*String name = params.getString("name");
            String author = params.getString("authorName");
            float price = params.getFloat("price");
            String publisher = params.getString("publishName");
            String detail = params.getString("detail_list");

            bookRepository.AddBook(name,price,author,publisher,detail,null,null,null);*/

            Book book = JSONObject.toJavaObject(params,Book.class);
            response.data = JSON.parseObject(JSONObject.toJSONString(book));
            response.status = ResponseType.SUCCESS;

        } catch (Exception e){
            e.printStackTrace();
            response.status = ResponseType.FAILURE;
            response.message = e.getMessage();
        }
        return response;
    }

}
