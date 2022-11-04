package com.leetcode.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration  //设置为配置类
@ComponentScan({"com.leetcode.hot100"})  //用于加载控制的Bean
//@PropertySource("classpath:jdbc.properties")  //加载properties文件
//@Import({JdbcConfig.class, MyBatisConfig.class})    //导入其它的配置类
//@EnableTransactionManagement    //开启事务管理器
public class SpringConfig {
}
