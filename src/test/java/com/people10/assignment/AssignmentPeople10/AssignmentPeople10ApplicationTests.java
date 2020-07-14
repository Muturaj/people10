/*
 * package com.people10.assignment.AssignmentPeople10;
 * 
 * import
 * org.hibernate.query.criteria.internal.expression.SearchedCaseExpression.
 * WhenClause; import org.junit.jupiter.api.Test; import
 * org.mockito.InjectMocks; import org.mockito.Mock; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.context.SpringBootTest;
 * 
 * import com.people10.assignment.AssignmentPeople10.DAO.CustomerRepo; import
 * com.people10.assignment.AssignmentPeople10.controller.CustometController;
 * import com.people10.assignment.AssignmentPeople10.model.Customer; import
 * static org.mockito.Mockito.when; // ...or... import static
 * org.junit.jupiter.api.Assertions.assertEquals; import static
 * org.mockito.Mockito.*;
 * 
 * @SpringBootTest class AssignmentPeople10ApplicationTests {
 * 
 * // @Mock // @Autowired
 * 
 * @InjectMocks private CustometController custm;
 * 
 * @Mock CustomerRepo repo;
 * 
 * @Test void contextLoads() {
 * 
 * // when(methodCall) }
 * 
 * @Test public void getCustomerDetailsByid() {
 * 
 * Customer c = new Customer(); c.setCid(5);
 * c.setEmail("mutturajdeval@gmail.com"); String s = "mutturajdeval@gmail.com";
 * // when(custm.getCustomerbyId(5)).then(repo.findById((long)
 * 5)).thenReturn(c); assertEquals(c.getCid(), 5); assertEquals(c.getEmail(),
 * s);
 * 
 * // c.getCid(); c.setCid(5); c.setFirstName("Mutturaj"); //
 * given(custm.getCustomerbyId(c.getCid())).willReturn(c); // assertth
 * 
 * }
 * 
 * }
 */