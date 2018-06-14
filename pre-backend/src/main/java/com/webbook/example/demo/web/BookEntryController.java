package com.webbook.example.demo.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.webbook.example.demo.entity.Book;
import com.webbook.example.demo.repository.BookRepository;
import com.webbook.example.demo.framework.*;
import com.webbook.example.demo.repository.BookentryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class BookEntryController extends BaseController{
    @Autowired
    private BookentryRepository bookentryRepository;


}
