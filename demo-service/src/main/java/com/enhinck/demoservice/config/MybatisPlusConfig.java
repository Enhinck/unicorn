package com.enhinck.demoservice.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述
 *
 * @author huenbin
 * @date 1/21/21 4:06 PM
 */
@Configuration
@MapperScan("com.enhinck.demoservice.mapper")
public class MybatisPlusConfig {


    /**
     * 分页
     * @return
     */
    @Bean
    public MybatisPlusInterceptor paginationInterceptor(){
        return new MybatisPlusInterceptor();
    }


//    /**
//     * SQL执行效率插件
//     */
//    @Bean
//    public PerformanceInterceptor performanceInterceptor() {
//        return new PerformanceInterceptor();
//    }
}

