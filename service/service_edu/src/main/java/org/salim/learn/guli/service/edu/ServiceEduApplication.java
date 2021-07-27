package org.salim.learn.guli.service.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.salim.learn.guli")//这个ComponentScan的目的是扩大搜索范围
//{"org.salim.learn.guli"}这里的大括号是干什么用的？不写可以吗，好像可以，程序仍然能走到config
public class ServiceEduApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceEduApplication.class, args);
        //首次运行，启用的端口号是8080，与配置不符service.port=8110
        //要设置为server.port=8110，这里是用Spring boot的ServletWebServerFactoryConfiguration来设置的
    }
}
