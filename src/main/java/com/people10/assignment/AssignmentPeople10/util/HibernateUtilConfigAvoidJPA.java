/*
 * package com.people10.assignment.AssignmentPeople10.util;
 * 
 * import javax.persistence.EntityManagerFactory;
 * 
 * import org.hibernate.SessionFactory; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.stereotype.Component;
 * 
 * @Configuration //@Component public class HibernateUtilConfigAvoidJPA {
 * 
 * @Autowired private EntityManagerFactory entityManagerFactory;
 * 
 * @Bean //@Autowired public SessionFactory getSessionFactory() { if
 * (entityManagerFactory.unwrap(SessionFactory.class) == null) { throw new
 * NullPointerException("Hibernate factory not set"); } return
 * entityManagerFactory.unwrap(SessionFactory.class); }
 * 
 * }
 */