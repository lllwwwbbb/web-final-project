package com.webbook.example.demo.respository;

import com.webbook.example.demo.entity.BookEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookentryRespository extends JpaRepository<BookEntry,Integer> {

}
