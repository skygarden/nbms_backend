package com.nexblue.nbms_backend.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan("com.nexblue.nbms_backend.web.mapper") // Mapper 인터페이스 스캔
public class MyBatisConfig {

}
