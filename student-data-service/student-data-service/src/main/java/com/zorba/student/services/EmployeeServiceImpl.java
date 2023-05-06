package com.zorba.student.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.zorba.student.dtos.Department;
import com.zorba.student.dtos.EmployeeDepartment;
import com.zorba.student.entities.Employee;
import com.zorba.student.repositories.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getEmployees() {
		log.info("Get All Employee List of EmployeeService ");
		return employeeRepository.findAll();
	}

	@Override
	public EmployeeDepartment getEmployeeById(Long id) {
		log.info("Get Employee By Id of EmployeeService ");
		EmployeeDepartment ed= new EmployeeDepartment();
		Employee employee=employeeRepository.findByEmployeeId(id);
		Department department= restTemplate.getForObject("http://EXAM-DATA-SERVICE/departments/"+employee.getDepartmentId(),Department.class);
		ed.setEmployee(employee);
		ed.setDepartment(department);
		return ed;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		log.info("Save Employee of EmployeeService ");
		
		return employeeRepository.save(employee);
	}

}
