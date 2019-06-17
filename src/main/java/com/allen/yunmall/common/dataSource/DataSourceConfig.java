package com.allen.yunmall.common.dataSource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * 数据源配置管理器
 * @author Wayne.M
 * 2019年2月14日
 */
@Slf4j
@Component
public class DataSourceConfig {
	@Bean("master")
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource createMaster() {
		log.info("【开始初始主库】");
        return DataSourceBuilder.create().build();
    }
	
	@Bean("slave")
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    public DataSource createSlave() {
		log.info("【开始初始从库】");
        return DataSourceBuilder.create().build();
    }
}
