/*
 * package com.people10.assignment.AssignmentPeople10.util;
 * 
 * import java.util.Properties;
 * 
 * import javax.persistence.EntityManagerFactory; import javax.sql.DataSource;
 * 
 * import org.hibernate.SessionFactory; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.ComponentScan; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.context.annotation.PropertySource; import
 * org.springframework.jdbc.datasource.DriverManagerDataSource; import
 * org.springframework.orm.hibernate5.HibernateTransactionManager; import
 * org.springframework.orm.hibernate5.LocalSessionFactoryBean; import
 * org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean; import
 * org.springframework.transaction.PlatformTransactionManager; import
 * org.springframework.transaction.annotation.EnableTransactionManagement;
 * 
 * @Configuration
 * 
 * @ComponentScan(basePackages = {
 * "com.people10.assignment.AssignmentPeople10.controller",
 * "com.people10.assignment.AssignmentPeople10.DAO",
 * "com.people10.assignment.AssignmentPeople10.model",
 * "com.people10.assignment.AssignmentPeople10.service",
 * "com.people10.assignment.AssignmentPeople10.util" })
 * 
 * @EnableTransactionManagement
 * 
 * @PropertySource({ "classpath:application.properties" }) public class
 * HibernateConfiguration {
 * 
 * @Bean public LocalSessionFactoryBean sessionFactory() {
 * 
 * LocalSessionFactoryBean localSessionFactoryBean = new
 * LocalSessionFactoryBean();
 * localSessionFactoryBean.setDataSource(dataSource());
 * localSessionFactoryBean.setHibernateProperties(hibernateProperties());
 * localSessionFactoryBean.setPackagesToScan(new String[] {
 * "com.people10.assignment.AssignmentPeople10",
 * "com.people10.assignment.AssignmentPeople10.DAO",
 * "com.people10.assignment.AssignmentPeople10.model",
 * "com.people10.assignment.AssignmentPeople10.service",
 * "com.people10.assignment.AssignmentPeople10.util" }); return
 * localSessionFactoryBean; }
 * 
 * @Bean public DataSource dataSource() { DriverManagerDataSource
 * driverManagerDataSource = new DriverManagerDataSource();
 * driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
 * driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/HotelDb");
 * driverManagerDataSource.setPassword("root");
 * driverManagerDataSource.setUsername("root"); return driverManagerDataSource;
 * 
 * }
 * 
 * private Properties hibernateProperties() {
 * 
 * Properties prop = new Properties(); prop.put("hibernate.dialect",
 * "org.hibernate.dialect.MySQL5Dialect"); prop.put("hibernate.format_sql",
 * "true"); prop.put("hibernate.show_sql", "true");
 * prop.put("hibernate.hbm2ddl.auto", "create-drop"); return prop;
 * 
 * }
 * 
 * @Bean
 * 
 * @Autowired public HibernateTransactionManager
 * hibernateTransactionManager(SessionFactory s) {
 * 
 * HibernateTransactionManager hibernateTransactionManager = new
 * HibernateTransactionManager();
 * hibernateTransactionManager.setSessionFactory(s); return
 * hibernateTransactionManager; }
 * 
 * 
 * 
 * }
 */