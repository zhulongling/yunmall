package com.allen.yunmall;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

/**
 * 根据数据表自动生成entity,XML,mapper,service,serviceImpl,controller
 * @author Wayne.M
 * 2019年2月14日
 */
public class MpGenerator {
	/**
	 * 生成
	 */
	@Test
	public void generator() {
		AutoGenerator mpg = new AutoGenerator();
		GlobalConfig gc = new GlobalConfig();
		String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("zhull");
        gc.setOpen(false);
        gc.setIdType(IdType.AUTO);//实体的ID字段策略
        mpg.setGlobalConfig(gc);
        
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://193.112.17.50/yunmall?useUnicode=true&characterEncoding=utf-8&useSSL=false");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("Yixia@827");
        mpg.setDataSource(dsc);
        
        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.allen.yunmall");
        mpg.setPackageInfo(pc);
        StrategyConfig strategy = new StrategyConfig();
        strategy.setTablePrefix("t_");// 表前缀过滤
        strategy.setInclude(new String[] {"t_user"}); // 需要生成的表
        //strategy.setExclude(new String[]{"t_test"}); // 排除生成的表
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        mpg.setStrategy(strategy);
        mpg.execute();
	}
}