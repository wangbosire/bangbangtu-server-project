package com.bangbangtu.couponsserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot 启动程序
 *
 * @author Administrator
 */
@SpringBootApplication
@MapperScan("com.bangbangtu.couponsserver.mapper")
public class CouponsServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CouponsServerApplication.class, args);
    }

}
