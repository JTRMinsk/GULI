package org.salim.learn.guli.service.base.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.function.Predicate;

@Configuration
@EnableSwagger2
public class Swagger2Config {
    //@Bean
    //    public Docket webApiConfig() {
    //        return new Docket(DocumentationType.SWAGGER_2);
    //    }

    //複数の配置方法でAPIsを別々にする
    @Bean
    public Docket webApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("webApi")
                .apiInfo(webApiInfo())//添加API的基本信息,显示在本组API首页
                .select()
                .paths(Predicates.and(PathSelectors.regex("/api/.*")))//通过不同的路径来区分组别
                .build();
    }

    @Bean
    public Docket adminApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("adminApi")
                .apiInfo(webApiInfo())//添加API的基本信息
                .select()
                .paths(Predicates.and(PathSelectors.regex("/admin/.*")))
                .build();
    }

    private ApiInfo webApiInfo() {
        return new ApiInfoBuilder()
                .title("网站的API文档")
                .description("网站的API接口定义")
                .version("1.0")
                .contact(new Contact("Salim", "", "jtrkiev@yahoo.com"))
                .build();
    }
}
