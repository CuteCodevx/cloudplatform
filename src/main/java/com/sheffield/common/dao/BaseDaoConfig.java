package com.sheffield.common.dao;

import com.github.pagehelper.PageInterceptor;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@EnableTransactionManagement
public class BaseDaoConfig {

    private static final Logger log = LoggerFactory.getLogger(BaseDaoConfig.class);


    @Primary
    @Bean(name = "dataSource")
    @ConfigurationProperties("spring.datasource.hikari")
    public DataSource dataSource() {

        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setMinimumIdle(5);
        dataSource.setMaximumPoolSize(100);
        dataSource.setAutoCommit(true);
        dataSource.setIdleTimeout(60000L);
        dataSource.setMaxLifetime(1800000L);
        dataSource.setConnectionTimeout(30000L);
        dataSource.setConnectionTestQuery("select 1");
        return dataSource;
    }


    @Primary
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
        log.info("Initialize sqlSessionFactoryBean");

        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);

        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] mapperLocations = resolver.getResources("classpath:mapper/**/*Mapper*.xml");
        sessionFactoryBean.setMapperLocations(mapperLocations);

        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "mysql");
        properties.setProperty("reasonable", "true");
        pageInterceptor.setProperties(properties);
        sessionFactoryBean.setPlugins(new Interceptor[]{pageInterceptor});

        return sessionFactoryBean.getObject();
    }

}
