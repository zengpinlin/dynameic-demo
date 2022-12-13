package com.zpl.dynamic.framework.config;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.handler.TableNameHandler;
import com.baomidou.mybatisplus.extension.plugins.inner.DynamicTableNameInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.zpl.dynamic.framework.aop.DynamicNameAspect;
import com.zpl.dynamic.framework.handler.DynamicTableNameHandler;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * mybatis 自动配置类
 *
 * @author: pinlin
 */
@MapperScan(value = {"com.zpl"}, annotationClass = Mapper.class)
@Component
public class MybatisAutoConfiguration {

    @Resource
    private TableNameHandler tableNameHandler;

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        DynamicTableNameInnerInterceptor dynamicTableNameInnerInterceptor = new DynamicTableNameInnerInterceptor();
        // 需要放到第一位，切记不要放错，不然会导致动态表名切换失效
        dynamicTableNameInnerInterceptor.setTableNameHandler(tableNameHandler);
        interceptor.addInnerInterceptor(dynamicTableNameInnerInterceptor);
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }

    @Bean
    public DynamicNameAspect dynamicNameAspect() {
        return new DynamicNameAspect();
    }

    @Bean
    public DynamicTableNameHandler dynamicTableNameHandler() {
        return new DynamicTableNameHandler();
    }
}
