package com.jc.bigscreen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.jc.bigscreen.dao")
@EnableSwagger2
public class BigScreenApplication {

    public static void main(String[] args) {
        SpringApplication.run(BigScreenApplication.class, args);
    }

}
