package com.webbook.example.demo.respository;

import com.webbook.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRespository extends JpaRepository<User,Integer> {
    /*通过用户名获取密码*/
    @Query(value = "select passwd from user where name=?1",nativeQuery = true)
    String GetpasswdByName(String Name);

    /*通过用户名获取用户Id*/
    @Query(value = "select UserId from user where name=?1",nativeQuery = true)
    Integer GetUserIdByName(String Name);

    /*修改用户密码*/
    @Query(value = "update user passwd=?2 where name=?1",nativeQuery = true)
    boolean ChangePasswd(String Name,String NewPasswd);

    /*修改手机号*/
    @Query(value = "update user phoneNum=?2 where name=?1",nativeQuery = true)
    boolean ChangePhone(String Name,String NewPhoneNum);

    /*修改地址*/
    @Query(value = "update user address=?2 where name=?1",nativeQuery = true)
    boolean ChangeAddress(String Name,String NewAddress);

    /*添加用户*/
    @Query(value = "insert into user (name,passwd,phoneNum,address) values (?1,?2,?3,?4);" +
            "select last_insert_id();",nativeQuery = true)
    Integer AddUser(String name,String passwd,String phoneNum,String adress);

    /*删除用户*/
    @Query(value = "delete from user where name=?1",nativeQuery = true)
    boolean DeleteUser(String name);

    /*获得用户所有信息*/
    @Query(value = "select * from user where name=?1",nativeQuery = true)
    User GetInfoByName(String name);
}
