package com.ljl.mall.tiny.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 *  mybatis配置类
 *
 */

@Configuration
@MapperScan("com.ljl.mall.tiny.mbg.mapper")
public class MyBatisConfig {
}
