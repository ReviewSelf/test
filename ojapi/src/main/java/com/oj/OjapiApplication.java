package com.oj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.oj.DAO","com.oj.service.impl"})
public class OjapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(OjapiApplication.class, args);
    }

}
