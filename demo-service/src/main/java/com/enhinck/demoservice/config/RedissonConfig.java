package com.enhinck.demoservice.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * 描述
 *
 * @author huenbin
 * @date 1/19/21 1:56 PM
 */
@Configuration
public class RedissonConfig {
    @Bean(name="redissonClient1",destroyMethod = "shutdown")
    public RedissonClient redissonClient1() throws IOException {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.9.111:6379").setPassword("123456");

        return Redisson.create(config);
    }


    @Bean(name="redissonClient2",destroyMethod = "shutdown")
    public RedissonClient redissonClient2() throws IOException {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.9.112:6379").setPassword("123456");

        return Redisson.create(config);
    }

    @Bean(name="redissonClient3",destroyMethod = "shutdown")
    public RedissonClient redissonClient3() throws IOException {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.9.114:6379").setPassword("123456");

        return Redisson.create(config);
    }


//    @Bean
//    public CacheManager cacheManager(@Qualifier("redisson1") RedissonClient redissonClient) {
//        Map<String, CacheConfig> config = new HashMap<>();
////        LocalCachedMapOptions options = LocalCachedMapOptions.defaults()
////                .evictionPolicy(LocalCachedMapOptions.EvictionPolicy.LFU)
////                .cacheSize(1000);
//        // 创建一个名称为"testMap"的缓存，过期时间ttl为24分钟，同时最长空闲时maxIdleTime为12分钟。
//        config.put("testMap", new CacheConfig(24 * 60 * 1000, 12 * 60 * 1000));
//        return new RedissonSpringCacheManager(redissonClient, config);
//    }
}
