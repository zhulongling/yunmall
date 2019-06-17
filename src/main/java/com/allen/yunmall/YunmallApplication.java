package com.allen.yunmall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableScheduling
@MapperScan("com.allen.yunmall.mapper")
public class YunmallApplication {

    public static void main(String[] args) {
        SpringApplication.run(YunmallApplication.class, args);
    }

}
