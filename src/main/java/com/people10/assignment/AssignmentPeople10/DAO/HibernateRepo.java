package com.people10.assignment.AssignmentPeople10.DAO;

import org.springframework.stereotype.Repository;

import com.people10.assignment.AssignmentPeople10.model.Customer;

@Repository
public interface HibernateRepo {
	void saveCustomer(Customer c);

}
