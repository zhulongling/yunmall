/**
 * 
 */
package com.allen.yunmall.common.dataSource;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 数据源切口拦截器
 * @author Wayne.M
 * 2019年2月13日
 */
@Aspect
@Component
@Slf4j
@Lazy(false)
@Order(0)
public class DataSourceAspect{
	private final String QUERY_PREFIX = "select";
	
	@Before("execution( * com.allen.yunmall.mapper.*.*(..))")
    public void process(JoinPoint point) {
    	Boolean isQueryMethod = isSelectMethod(point.getSignature().getName());
        if (isQueryMethod) {
            DataSourceContextHolder.setDataSourceKey(DataSourceType.slave);
            //log.info("切换数据源到 【{}】 在方法 【{}】中",DataSourceContextHolder.getDataSourceKey(), point.getSignature());
        }else {
        	DataSourceContextHolder.setDataSourceKey(DataSourceType.master);
        	//log.info("切换数据源到 【{}】 在方法 【{}】中",DataSourceContextHolder.getDataSourceKey(), point.getSignature());
        }
    }
    
    private Boolean isSelectMethod(String methodName) {
    	if (methodName.startsWith(QUERY_PREFIX)) 
    		return true;
        return false;
    }
}
