/**
 * 
 */
package com.allen.yunmall.common.dataSource;

/**
 * 数据源切换
 * @author Wayne.M
 * 2019年2月13日
 */
public class DataSourceContextHolder {
	private static final ThreadLocal<Object> CONTEXT_HOLDER = ThreadLocal.withInitial(()->DataSourceType.master);
	
	public static void setDataSourceKey(Object key) {
        CONTEXT_HOLDER.set(key);
    }

	public static Object getDataSourceKey() {
        return CONTEXT_HOLDER.get();
    }
	
    public static void clearDataSourceKey() {
        CONTEXT_HOLDER.remove();
    }
}
