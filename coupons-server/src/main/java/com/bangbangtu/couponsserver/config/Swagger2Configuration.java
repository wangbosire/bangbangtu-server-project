package com.bangbangtu.couponsserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2 配置文件
 *
 * @author Administrator
 */
@Configuration
@EnableSwagger2
public class Swagger2Configuration {
    public static final String SWAGGER_SCAN_BASE_PACKAGE = "com.bangbangtu.couponsserver";

    public static final String VERSION = "1.0.0";

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("单词计数服务")
                .description("单词计数服务 API 接口文档")
                .version(VERSION)
                .termsOfServiceUrl("http://www.baidu.com")
                .build();
    }
}
