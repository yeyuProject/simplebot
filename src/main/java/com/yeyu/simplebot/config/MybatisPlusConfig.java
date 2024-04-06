package com.yeyu.simplebot.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author chy
 * @createDate 2024-04-06 17:28
 */
@Configuration
@MapperScan("com.yeyu.simplebot.mapper")
public class MybatisPlusConfig {
}
