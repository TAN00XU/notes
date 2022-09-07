package com.tan00xu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

/**
 * Swagger配置
 *
 * @author TAN00XU
 * @date 2022/09/04
 */
@Configuration
//开启Swagger2
//老版本
//@EnableSwagger2
//新版本3.0
@EnableOpenApi
public class SwaggerConfig {


    /**
     * 配置Swagger的Docket的bean实例
     *
     * @return {@link Docket}
     */
    @Bean
    public Docket docket(Environment environment) {
        //设置要显示的Swagger环境
        Profiles profiles = Profiles.of("dev", "test");
        //通过environment.acceptsProfiles判断是否处在自己设定的环境中
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //是否启用Swagger，若果为false，则不能在浏览器中访问
                .enable(flag)
                .groupName("饮梦")
                .select()
                //RequestHandlerSelectors 配置要扫描的接口的方式
                //.basePackage() 指定要扫描的包
                //.any() 扫描全部
                //.none 都不扫描
                //.withClassAnnotation() 扫描类上的注解，参数是一个注解的反射对象
                //.withMethodAnnotation()扫描方法的注解
                .apis(RequestHandlerSelectors.basePackage("com.tan00xu.controller"))
                //paths() 过滤请求路径，只扫描以此开头的路径
                .paths(PathSelectors.ant("/test/**"))
                .build();
    }

    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }
    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }
    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("C");
    }

    /**
     * 配置Swagger的api信息
     *
     * @return {@link ApiInfo}
     */
    private ApiInfo apiInfo() {
        Contact contact = new Contact("饮梦", "https://gitee.com/TAN00XU", "2507320149@qq.com");
        return new ApiInfo(
                "饮梦的SwaggerAPI",
                "梦中扬帆",
                "1.0",
                "localhost:8080",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>()
        );
    }
}
