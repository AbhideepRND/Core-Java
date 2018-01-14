package com.springdata.db.config;

import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(basePackages = { "com.springdata.db.repository.jpa" },
		entityManagerFactoryRef = "derbyEntityManager",
		transactionManagerRef = "derbyTransactionmanager",
		repositoryImplementationPostfix = "CustomImpl")
public class JpaDerbyConfig {

	@Bean(name = "derby")
	public DataSource dataSource() {
		final DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("org.apache.derby.jdbc.ClientDriver");
		driverManagerDataSource.setUrl("jdbc:derby://localhost:1527/Store");
		driverManagerDataSource.setUsername("store");
		driverManagerDataSource.setPassword("store");
		return driverManagerDataSource;

	}

	@Bean(name = "derbyEntityManager")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(
			@Qualifier(value = "derby") DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean entityManagerFactory =
				new LocalContainerEntityManagerFactoryBean();

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		Properties additionalProperties = new Properties();
		additionalProperties.put("hibernate.dialect", "org.hibernate.dialect.DerbyDialect");
		additionalProperties.put("hibernate.show_sql", "true");
		additionalProperties.put("hibernate.hbm2ddl.auto", "none");
		additionalProperties.put("hibernate.default_schema", "payroll");
		additionalProperties.put("hibernate.id.new_generator_mappings", "false");
		entityManagerFactory.setJpaProperties(additionalProperties);
		entityManagerFactory.setDataSource(dataSource);
		entityManagerFactory.setPackagesToScan("com.springdata.db.model");
		entityManagerFactory.setPersistenceUnitName("derby");
		entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
		entityManagerFactory.setJpaProperties(additionalProperties);

		return entityManagerFactory;

	}

	@Bean(name = "derbyTransactionmanager")
	public PlatformTransactionManager getTransactionManager(
			@Qualifier("derbyEntityManager") EntityManagerFactory derbyEntityManager) {
		return new JpaTransactionManager(derbyEntityManager);

	}

}
