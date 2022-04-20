package com.tutoedu.lmsadmin;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;


@SpringBootTest
public class DbConnectionTest {

    @Autowired
    private SqlSessionFactory sessionFactory;

    @Test
    public void connecntion_test(){
        try(Connection conn = sessionFactory.openSession().getConnection()){
            System.out.println("연결 성공");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
