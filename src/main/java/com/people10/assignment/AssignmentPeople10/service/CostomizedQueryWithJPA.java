package com.people10.assignment.AssignmentPeople10.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.people10.assignment.AssignmentPeople10.DAO.CustomerRepo;
import com.people10.assignment.AssignmentPeople10.model.Customer;
import com.people10.assignment.AssignmentPeople10.model.Format;

@Service
public class CostomizedQueryWithJPA {

	@Autowired
	CustomerRepo repo;
	
	@Autowired
	@Qualifier("fooBar")
	Format form;

	public List<Customer> getListCostomer(String fname,String email) {

		//@Query("")
		List<Customer> list = repo.findbymailAndFirstName(fname,email);
		form.hello();
		form.hey();
		return list;

	}

}
