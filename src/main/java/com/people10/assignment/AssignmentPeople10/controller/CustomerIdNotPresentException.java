package com.people10.assignment.AssignmentPeople10.controller;

public class CustomerIdNotPresentException extends RuntimeException {
	

	public CustomerIdNotPresentException(long cid) {
	super("could not find Customer  :"  +cid);
		//this.id = id;
		
	}

}
