package net.webapp.ecommerce.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement 
// @EnableJpaRepositories("net.webapp.springtest.repository") // Enable Spring Data JPA
@PropertySource("classpath:application.properties")
public class DataBaseConfig {

	// database property
	private static final String PROPERTY_NAME_DATABASE_DRIVER = "datasource.DriverClassName";
	private static final String PROPERTY_NAME_DATABASE_PASSWORD = "datasource.Password";
	private static final String PROPERTY_NAME_DATABASE_URL = "datasource.Url";
	private static final String PROPERTY_NAME_DATABASE_USERNAME = "datasource.Username";
	// Hibernate property
	private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
	private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
	// scan for @Entity classes , no persistence xml
	private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "net.webapp.ecommerce.entities";

	@Resource
	private Environment env;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));
		dataSource.setUrl(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));
		dataSource.setUsername(env.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));
		dataSource.setPassword(env.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));
		return dataSource;
	}

	@Bean
	public EntityManagerFactory entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		em.setPackagesToScan(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN);
		em.setJpaVendorAdapter(jpaVendorAdaper());
		em.setJpaProperties(jpaProperties());
		em.afterPropertiesSet();
		return em.getObject();
	}

	private Properties jpaProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
//		properties.put("hibernate.validator.apply_to_ddl", env.getRequiredProperty("hibernate.validator.apply_to_ddl"));
//		properties.put("hibernate.validator.autoregister_listeners",env.getRequiredProperty("hibernate.validator.autoregister_listeners"));
//		properties.put("hibernate.dialect", env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
//		properties.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
//		properties.put("hibernate.use_sql_comments", env.getRequiredProperty("hibernate.use_sql_comments"));
//		properties.put("hibernate.show_sql", env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));
		return properties;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager(entityManagerFactory());
	}
	
	 @Bean 
	 public JpaVendorAdapter jpaVendorAdaper() { 
		 final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter(); // vendorAdapter.setDatabase();
		 vendorAdapter.setDatabase(env.getRequiredProperty("jpa.database", Database.class));
		 vendorAdapter.setDatabasePlatform(env.getRequiredProperty("jpa.databasePlateform"));
		 vendorAdapter.setShowSql(env.getRequiredProperty("jpa.showSql", Boolean.class));
		 vendorAdapter.setGenerateDdl(env.getRequiredProperty("jpa.generateDdl", Boolean.class)); 
		 return vendorAdapter; 
	 }
	 

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

}
