package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 构建 jar 包用这个
 */
//@SpringBootApplication
//public class ZlibraryBackApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(ZlibraryBackApplication.class, args);
//    }
//
//}


/**
 * 构建 war 包用这个
 */
@SpringBootApplication
public class ZlibraryBackApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        //return super.configure(builder);
        return builder.sources(ZlibraryBackApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ZlibraryBackApplication.class, args);
    }

}
