package com.zorba.exam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zorba.exam.entities.Department;
import com.zorba.exam.repositories.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public List<Department> getDepartments() {
		log.info("Get All Department List of DepartmentService ");
		return departmentRepository.findAll();
	}

	@Override
	public Department saveDepartment(Department department) {
		log.info("Save Department Details of DepartmentService ");
		return departmentRepository.save(department);
	}

	@Override
	public Department getDepartmentById(Long id) {
		log.info("Get Department Details By Id of DepartmentService ");
		return departmentRepository.findByDepartmentId(id);
	}
}
