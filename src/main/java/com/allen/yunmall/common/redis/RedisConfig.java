package com.allen.yunmall.common.redis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * Redis多数据源配置类
 * @author Wayne.M
 * 2019年2月15日
 */
@Configuration
public class RedisConfig {
	
	private StringRedisTemplate getStringRedisTemplate(RedisConnectionFactory factory) {
        StringRedisTemplate template = new StringRedisTemplate(factory);
        template.afterPropertiesSet();
        return template;
    }

//    private RedisTemplate<String, Object> getObjectRedisTemplate(RedisConnectionFactory factory) {
//        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(factory);
//        return redisTemplate;
//    }
	@Bean
    @ConfigurationProperties(prefix = "spring.redis.lettuce.pool")
    public GenericObjectPoolConfig redisPool() {
        return new GenericObjectPoolConfig();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.redis.db0")
    public RedisStandaloneConfiguration commentRedisConfig() {
        return new RedisStandaloneConfiguration();
    }

    @Bean("commentFactory")
    public LettuceConnectionFactory commentFactory(GenericObjectPoolConfig config, RedisStandaloneConfiguration commentRedisConfig) {
        LettuceClientConfiguration clientConfiguration = LettucePoolingClientConfiguration.builder().poolConfig(config).build();
        return new LettuceConnectionFactory(commentRedisConfig, clientConfiguration);
    }

    @Bean("commentStringRedisTemplate")
    public StringRedisTemplate countryStringRedisTemplate(@Qualifier("commentFactory") RedisConnectionFactory factory) {
        return getStringRedisTemplate(factory);
    }
    
//	//配置多数据源，增加以下内容
//	@Bean
//    @ConfigurationProperties(prefix = "spring.redis.db-1")
//    public RedisStandaloneConfiguration countryRedisConfig() {
//        return new RedisStandaloneConfiguration();
//    }
//
//    @Bean("countryFactory")
//    public LettuceConnectionFactory countryFactory(GenericObjectPoolConfig config, RedisStandaloneConfiguration countryRedisConfig) {
//        LettuceClientConfiguration clientConfiguration = LettucePoolingClientConfiguration.builder().poolConfig(config).build();
//        return new LettuceConnectionFactory(countryRedisConfig, clientConfiguration);
//    }
//
//    @Bean("countryStringRedisTemplate")
//    public StringRedisTemplate countryStringRedisTemplate(@Qualifier("countryFactory") RedisConnectionFactory factory) {
//        return getStringRedisTemplate(factory);
//    }

//    //配置多数据源，增加以下内容
//    @Bean
//    @ConfigurationProperties(prefix = "spring.redis.db-2")
//    public RedisStandaloneConfiguration commentRedisConfig() {
//        return new RedisStandaloneConfiguration();
//    }
//
//    @Bean("commentFactory")
//    public LettuceConnectionFactory commentFactory(GenericObjectPoolConfig config, RedisStandaloneConfiguration countryRedisConfig) {
//        LettuceClientConfiguration clientConfiguration = LettucePoolingClientConfiguration.builder().poolConfig(config).build();
//        return new LettuceConnectionFactory(countryRedisConfig, clientConfiguration);
//    }
//
//    @Bean("commentRedisTemplate")
//    public RedisTemplate<String, Object> commentRedisTemplate(@Qualifier("commentFactory") RedisConnectionFactory factory) {
//        return getObjectRedisTemplate(factory);
//    }
//
}
