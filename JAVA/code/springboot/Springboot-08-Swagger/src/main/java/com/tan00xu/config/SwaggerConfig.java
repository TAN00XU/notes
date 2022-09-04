package com.tan00xu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

/**
 * 配置
 *
 * @author TAN00XU
 * @date  2022/09/04
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
     * @return {@code Docket}
     */
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo());
    }


    /**
     * 配置Swagger的api信息
     *
     * @return {@code ApiInfo}
     */
    private ApiInfo apiInfo() {
        Contact contact = new Contact("饮梦", "localhost:8080", "2507320149@qq.com");
        return new ApiInfo(
                "饮梦的SwaggerAPI",
                "梦中扬帆",
                "1.0",
                "localhost:8080",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList()
        );

    }

}
