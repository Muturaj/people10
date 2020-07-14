package com.people10.assignment.AssignmentPeople10.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.people10.assignment.AssignmentPeople10.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long> {
	// boolean existsByEmail(String email);

	boolean existsByEmail(String email);

	
	
	@Query("SELECT u FROM Customer u WHERE u.firstName= :firstName and u.email= :email")
	//@Query("select u from User u where u.firstname = :#{#customer.firstname}")
	 List<Customer> findbymailAndFirstName(@Param(value = "firstName")   String firstName,@Param(value = "email") String email);
	

//	Customer findById(int cid);

}
