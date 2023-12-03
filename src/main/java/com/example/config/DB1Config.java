package com.example.config;

import com.example.DAO.db1.CustomerMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@PropertySource({ "classpath:dbs.properties" })
@EnableJpaRepositories(
        basePackages = "com.example.DAO.db1",
        entityManagerFactoryRef = "customerEntityManager",
        transactionManagerRef = "customerTransactionManager"
)
@MapperScan(basePackages = "com.example.DAO.db1", sqlSessionFactoryRef = "customerSqlSessionFactory")
@EntityScan(basePackages = "com.example.model") // Replace with the actual package of Customer entity

public class DB1Config {

    @Autowired
    private Environment env;

    @Primary
    @Bean
    @ConfigurationProperties(prefix="spring.db1")
    public DataSource customerDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(env.getProperty("spring.db1.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.db1.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.db1.datasource.password"));
        dataSource.setDriverClassName(env.getProperty("spring.db1.datasource.driver-class-name"));
        return dataSource;
    }

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean customerEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(customerDataSource());
        em.setPackagesToScan("com.example.model");
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        em.setJpaPropertyMap(properties);
        return em;
    }

    @Primary
    @Bean
    public PlatformTransactionManager customerTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(customerEntityManager().getObject());
        return transactionManager;
    }

    @Primary
    @Bean
    public SqlSessionFactory customerSqlSessionFactory(@Qualifier("customerDataSource") DataSource customerDataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(customerDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:customerMapper.xml"));
        return sessionFactory.getObject();
    }

    @Primary
    @Bean
    public CustomerMapper customerMapper(SqlSessionFactory sqlSessionFactory) {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
        return sqlSessionTemplate.getMapper(CustomerMapper.class);
    }
}

