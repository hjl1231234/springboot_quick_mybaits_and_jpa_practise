package com.firstapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MySpringBootApp {
    public static void main(String[] args) {
//        run静态方法，跑引导类,传入相应字节码参数
        SpringApplication.run(MySpringBootApp.class);
    }
}
