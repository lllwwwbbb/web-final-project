package com.webbook.example.demo.respository;

import com.webbook.example.demo.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRespository extends JpaRepository<Manager,Integer> {
    /*通过用户名获取密码*/
    @Query(value = "select Passwd from manager where UserName=?1",nativeQuery = true)
    String GetPasswdByName(String name);

    /*添加管理员*/
    @Query(value = "insert into manager (UserName,Passwd) values (?1,?2)",nativeQuery = true)
    Boolean AddManager(String name,String Passwd);
}
