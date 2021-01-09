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

@Configuration
@ConfigurationProperties(prefix = "sqlserver.datasource")
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "spEntityManagerFactory",
    transactionManagerRef = "spTransactionManager",
    basePackages = {"com.example.jpaMultipleDataSource.dao.bnp"})
public class SqlServerConfig extends HikariConfig {
	
	private Environment env;
	
	public SqlServerConfig(Environment env) {
		this.env = env;
	}
	
	@Bean(name = "spDataSource")
	public DataSource certifiedDataSource() {
		return new HikariDataSource(this);
	}
	
	@Bean(name = "spEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(certifiedDataSource());
		em.setPackagesToScan("com.example.jpaMultipleDataSource.entity.bnp");
		
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		
		Map<String, Object> properties = new HashMap<>();
		properties.put("hibernate.dialect", env.getProperty("sqlserver.jpa.database-platform"));
//		properties.put("hibernate.hbm2ddl.auto", env.getProperty("sqlserver.jpa.hbm2ddl"));
		
		em.setJpaPropertyMap(properties);
		
		return em;
	}
	
	@Bean(name = "spTransactionManager")
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		
		return transactionManager;
	}
}
