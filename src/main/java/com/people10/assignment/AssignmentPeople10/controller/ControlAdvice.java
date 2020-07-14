package com.people10.assignment.AssignmentPeople10.controller;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


//if elment not found
@ControllerAdvice
class EmployeeNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(CustomerIdNotPresentException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String customerNotFoundHandler(CustomerIdNotPresentException ex) {
    return ex.getMessage();
  }
}
