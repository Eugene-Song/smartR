package com.eugene.eugeneblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.eugene.eugeneblog.dao")
@SpringBootApplication
public class EugeneBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(EugeneBlogApplication.class, args);
    }

}
