package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.luv2code.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.luv2code.springboot.thymeleafdemo.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	//constructor injection
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}

	@Override
	// handles transaction management so we don't have to manually start and commit
	// transaction
	//@Transactional:AS jpaRepository provides this functionality
	public List<Employee> findAll() {
		
		return employeeRepository.findAllByOrderByFirstNameAsc();
	}

	@Override
	// handles transaction management so we don't have to manually start and commit
	// transaction
	//@Transactional:AS jpaRepository provides this functionality
	public Employee findById(int theId) {
		
		Optional<Employee> result = employeeRepository.findById(theId);
		
		Employee theEmployee=null;
		
		if(result.isPresent()) {
			
			theEmployee=result.get();
		}
		else {
			throw new RuntimeException("Did not find employee id - " +  theId);
		}
		return theEmployee;
	}

	@Override
	// handles transaction management so we don't have to manually start and commit
	// transaction
	//@Transactional:AS jpaRepository provides this functionality
	public void save(Employee theEmployee) {
		
		employeeRepository.save(theEmployee);

	}

	@Override
	// handles transaction management so we don't have to manually start and commit
	// transaction
	//@Transactional:AS jpaRepository provides this functionality
	public void deleteById(int theId) {
		
		employeeRepository.deleteById(theId);

	}

}
