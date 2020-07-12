package com.luv2code.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.thymeleafdemo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	//no need to write any code,,no need for implementation class
	
	//add a method to sort by last name
	public List<Employee> findAllByOrderByFirstNameAsc();

}
