package com.qsp.springbootemployee2.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springbootemployee2.dto.Employee;
import com.qsp.springbootemployee2.repo.EmployeeRepo;
import com.qsp.springbootemployee2.util.ResponseStructure;

@Repository
public class EmployeeDao 
{
        @Autowired
		private EmployeeRepo repo;
		
		public Employee saveEmployee(Employee employee)
		{
			return repo.save(employee);
		}
		
		public Employee findEmployee(int id)
		{
			
			//return repo.findById(id).get();
           //To Avoid NOSuchElementException, we used optional class.
			Optional<Employee> optional=repo.findById(id);
			if(optional.isPresent())
			{
				return optional.get();
				//Employee employee=optional.get();
				//return employee;
			}
			return null;
		}
		
		public List<Employee> fetchAllEmployee()
		{
			return repo.findAll();
		}
		
		public Employee deleteEmployee(int id)
		{
			Optional<Employee> optional=repo.findById(id);
			if(optional.isPresent())
			{
				repo.deleteById(id);
				return optional.get();
			}
			return null;
		}
		
		public Employee updateEmployee(int id, Employee employee)
		{
			Optional <Employee> optional=repo.findById(id);
			if(optional.isPresent())
			{
				employee.setId(id);
				return repo.save(employee);
			}
			return null;			
		}
		
		
		public Employee findByEmail(String email)
		{
			return repo.findEmployeeByEmail(email);
		}
		
		public Employee findByPhone(long phone)
		{
     		return repo.findEmployeeByPhone(phone);
			//return repo.employeeByPhone(phone);
		}
		
		public List<Employee> findEmployeeBySalaryGreaterThan(double salary)
		{
			return repo.findEmployeeBySalaryGreaterThan(salary);
		}
		
		public List<Employee> findEmployeeBySalaryLessThan(double salary)
		{
			return repo.findEmployeeBySalaryLessThan(salary);
		}	
}
