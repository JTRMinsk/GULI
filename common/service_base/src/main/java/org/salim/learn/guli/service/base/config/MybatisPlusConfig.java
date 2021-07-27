package org.salim.learn.guli.service.base.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement//本地事务管理，乐观锁的时候会用到
@Configuration
@MapperScan("org.salim.learn.guli.service.*.mapper")//通过这样的设置来扫描不同模块包里的mapper包, mybatis注解
public class MybatisPlusConfig {
    //因为XXXApp.java(主类) 所在包名不同，没有经过配置的情况下是看不到这个配置类的(只扫描本类所在包下的所有目录)
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
        //MyBatis PLUS中的分页插件
    }

}
