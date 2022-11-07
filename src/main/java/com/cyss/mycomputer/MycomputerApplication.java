package com.cyss.mycomputer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cyss.mycomputer.mapper")
public class MycomputerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MycomputerApplication.class, args);
    }
}
