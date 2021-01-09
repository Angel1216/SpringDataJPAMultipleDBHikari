package com.example.jpaMultipleDataSource.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Primary
@Configuration
@ConfigurationProperties(prefix = "oracle.datasource")
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "clientsEntityManagerFactory",
    transactionManagerRef = "clientsTransactionManager",
    basePackages = {"com.example.jpaMultipleDataSource.dao.mobile"})
public class OracleConfig extends HikariConfig {
	
	private Environment env;
	
	public OracleConfig(Environment env) {
		this.env = env;
	}
	
	@Primary
	@Bean(name = "clientsDataSource")
	public DataSource certifiedDataSource() {
		return new HikariDataSource(this);
	}
	
	@Primary
	@Bean(name = "clientsEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(certifiedDataSource());
		em.setPackagesToScan("com.example.jpaMultipleDataSource.entity.mobile");
		
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		
		Map<String, Object> properties = new HashMap<>();
		properties.put("hibernate.dialect", env.getProperty("oracle.jpa.database-platform"));
//		properties.put("hibernate.hbm2ddl.auto", env.getProperty("oracle.jpa.hbm2ddl"));
		
		em.setJpaPropertyMap(properties);
		
		return em;
	}
	
	@Primary
	@Bean(name = "clientsTransactionManager")
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		
		return transactionManager;
	}
}
