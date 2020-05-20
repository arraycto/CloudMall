package com.suzhou.love.autumn.admin.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatis配置类
 * Created by macro on 2019/4/8.
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.suzhou.love.autumn.mapper","com.suzhou.love.autumn.admin.dao","com.suzhou.love.autumn.security.service"})
public class MyBatisConfig {
}
