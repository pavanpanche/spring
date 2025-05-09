package com.hotel.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.DriverManager;

@Configuration
@ComponentScan (basePackages = "com.hotel")
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Value("${db.url}")
    private String dbUrl;

    @Value("${db.username}")
    private String dbUsername;

    @Value("${db.password}")
    private String dbPassword;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();

        ds.setUrl(dbUrl);
        ds.setUsername(dbUsername);
        ds.setPassword(dbPassword);
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return  ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
