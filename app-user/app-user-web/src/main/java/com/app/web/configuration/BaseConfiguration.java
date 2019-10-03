package com.app.web.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.app.common.constants.CommonConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author Feinik
 * @discription
 * @date 2019/10/3
 * @since 1.0.0
 */
@Configuration
public class BaseConfiguration {

    @Bean
    public DataSource dataSource() throws Exception {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/app?characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&useSSL=false&allowMultiQueries=true");
        dataSource.setUsername("root");
        dataSource.setPassword("Feinik_12354");

        dataSource.setMaxPoolPreparedStatementPerConnectionSize(200);
        dataSource.setInitialSize(50);
        dataSource.setMinIdle(50);
        dataSource.setMaxActive(200);
        dataSource.setMaxWait(60000);

        dataSource.setDriverClassName(CommonConstant.MYSQL_DRIVER);
        dataSource.setTestOnBorrow(CommonConstant.DRUID_TESTONBORROW);
        dataSource.setTestOnReturn(CommonConstant.DRUID_TESTONRETURN);
        dataSource.setTestWhileIdle(CommonConstant.DRUID_TESTWHILEIDLE);
        dataSource.setTimeBetweenEvictionRunsMillis(CommonConstant.DRUID_TIMEBETWEENEVICTIONRUNSMILLIS);
        dataSource.setMinEvictableIdleTimeMillis(CommonConstant.DRUID_MINEVICTABLEIDLETIMEMILLIS);
        dataSource.setPoolPreparedStatements(CommonConstant.DRUID_POOLPREPAREDSTATEMENTS);
        dataSource.setFilters(CommonConstant.DRUID_FILTERS);
        dataSource.init();
        return dataSource;
    }
}
