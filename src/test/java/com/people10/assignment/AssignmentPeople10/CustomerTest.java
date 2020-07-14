/*
 * package com.people10.assignment.AssignmentPeople10;
 * 
 * import org.junit.jupiter.api.Test; import org.junit.runner.RunWith; import
 * org.mockito.InjectMocks; import org.mockito.Mock; import
 * org.mockito.junit.MockitoJUnitRunner;
 * 
 * import com.people10.assignment.AssignmentPeople10.DAO.CustomerRepo; import
 * com.people10.assignment.AssignmentPeople10.controller.CustometController;
 * import com.people10.assignment.AssignmentPeople10.model.Customer;
 * 
 * import static org.mockito.Mockito.when; // ...or...
 * 
 * import java.util.Optional;
 * 
 * import static org.junit.jupiter.api.Assertions.assertEquals; import static
 * org.mockito.Mockito.*;
 * 
 * @RunWith(MockitoJUnitRunner.class) class CustomerTest {
 * 
 * @InjectMocks CustometController c;
 * 
 * @Mock CustomerRepo ccrr;
 * 
 * @Test public void test1() { when(c.getCustomerbyId(5)).thenReturn(new
 * Customer(1,"muttu","raj","deval","password")); Optional<Customer> cu=
 * ccrr.findById((long) 1); //assertEquals("muttu", cu.);
 * 
 * 
 * }
 * 
 * 
 * }
 */