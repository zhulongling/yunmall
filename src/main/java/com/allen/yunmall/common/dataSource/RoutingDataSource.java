/**
 * 
 */
package com.allen.yunmall.common.dataSource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 数据源路由管理器
 * @author Wayne.M
 * 2019年2月13日
 */
@Slf4j
@Component
@Primary
public class RoutingDataSource extends AbstractRoutingDataSource {
	@Autowired
    @Qualifier("master")
    private DataSource master;//只写数据源
	
	@Autowired
    @Qualifier("slave")
    private DataSource slave;//只读数据源
	
	@Override
	protected Object determineCurrentLookupKey() {
		//log.info("【当前数据源:"+DataSourceContextHolder.getDataSourceKey()+"】");
		return DataSourceContextHolder.getDataSourceKey();
	}
	
	@Override
    public void afterPropertiesSet() {
        Map<Object,Object> map = new HashMap<>();
        map.put(DataSourceType.master,master);
        map.put(DataSourceType.slave,slave);
        setTargetDataSources(map);
        setDefaultTargetDataSource(master);
        super.afterPropertiesSet();
    }
}
