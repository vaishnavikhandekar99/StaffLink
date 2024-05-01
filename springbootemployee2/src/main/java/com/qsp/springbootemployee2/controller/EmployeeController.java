package com.qsp.springbootemployee2.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.springbootemployee2.dao.EmployeeDao;
import com.qsp.springbootemployee2.dto.Employee;
import com.qsp.springbootemployee2.service.EmployeeService;
import com.qsp.springbootemployee2.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class EmployeeController 
{
		@Autowired                                                        
		private EmployeeService service;
		                                                                  
		                                                                 
		@PostMapping("/save") 
		@ApiOperation(value = "Save Employee", notes= "This API is used to save the employee data in database")
		@ApiResponses(value = {@ApiResponse(code=201 , message="data saved successfully")})          
		public ResponseEntity<ResponseStructure<Employee>> saveEmployee(@Valid @RequestBody Employee employee) {
			return service.saveEmployee(employee);       
		}
		
		@ApiOperation(value ="Get Employee By Id",notes ="This API is used to fetch employee data using employee_id")
		@ApiResponses(value={@ApiResponse(code=302,message="Data Found"), @ApiResponse(code=404,message="Id not found")})  
		@GetMapping("/fetchById")   
		public ResponseEntity<ResponseStructure<Employee>> findById(@RequestParam int id) {
			return service.findById(id);
		}
        
		@ApiOperation(value ="Get AllEmployee",notes ="This API is used to fetch all the employee data")
		@ApiResponses(value={@ApiResponse(code=302,message="Data Found"), @ApiResponse(code=404,message="Data not found")})
		@GetMapping("/fetchAll") 
		public ResponseEntity<ResponseStructure<List<Employee>>> fetchAllEmployee() {
			return service.fetchAllEmployee();
		}
        
		@ApiOperation(value ="Delete Employee",notes ="This API is used to delete employee data using employee_id")
		@ApiResponses(value={@ApiResponse(code=201,message="Data deleted successfully"), @ApiResponse(code=404,message="Id not found")})
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<ResponseStructure<Employee>> deleteEmployee(@PathVariable int id) {
			return service.deleteEmployee(id);
		}
 
		@ApiOperation(value ="Update Employee",notes ="This API is used to update employee data using employee_id")
		@ApiResponses(value={@ApiResponse(code=200,message="Data Updated Successfully"), @ApiResponse(code=404,message="Id not found")})
		@PutMapping("/updateEmployee")   
		public ResponseEntity<ResponseStructure<Employee>> updateEmployee(@RequestParam int id,
				@Valid @RequestBody Employee employee) {
			return service.updateEmployee(id, employee);    
		}
        
		@ApiOperation(value ="Update Email",notes ="This API is used to update email using employee_id")
		@ApiResponses(value={@ApiResponse(code=200,message="Email Updated Sucessfully"), @ApiResponse(code=404,message="Id not found")})
		@PatchMapping("/updateEmail/{id}")                                                 
		public ResponseEntity<ResponseStructure<Employee>> updateEmail(@PathVariable int id, @Valid @RequestParam String email) {
			return service.updateEmail(id, email);
		}

		@ApiOperation(value ="Update Phone",notes ="This API is used to update phone using employee_id")
		@ApiResponses(value={@ApiResponse(code=200,message="Phone Updated Sucessfully"), @ApiResponse(code=404,message="Id not found")})
		@PatchMapping("/updatePhone/{id}")
		public ResponseEntity<ResponseStructure<Employee>> updatePhone(@PathVariable int id, @Valid @RequestParam long phone) {
			return service.updatePhone(id, phone);
		}

		@ApiOperation(value ="Update Name",notes ="This API is used to update name using employee_id")
		@ApiResponses(value={@ApiResponse(code=200,message="Name Updated Sucessfully"), @ApiResponse(code=404,message="Id not found")})
		@PatchMapping("/updateName/{id}") 
		public ResponseEntity<ResponseStructure<Employee>> updateName(@PathVariable int id, @Valid @RequestParam String name) {
			return service.updateName(id, name);
		}
        
		@ApiOperation(value ="Update Salary",notes ="This API is used to update salary using employee_id")
		@ApiResponses(value={@ApiResponse(code=200,message="Salary Updated Sucessfully"), @ApiResponse(code=404,message="Id not found")})
		@PatchMapping("/updateSalary/{id}")       
		public ResponseEntity<ResponseStructure<Employee>> updateSalary(@PathVariable int id, @Valid @RequestParam double salary) {
			return service.updateSalary(id, salary);
		}
        
		@ApiOperation(value ="Find Employee By Email",notes ="This API is used to find employee by email")
		@ApiResponses(value={@ApiResponse(code=302,message="Data Found"), @ApiResponse(code=404,message="Email not found")})
		@GetMapping("/findByEmail")     
		public ResponseEntity<ResponseStructure<Employee>> findByEmail( @RequestParam String email) {
			return service.findByEmail(email);
		}
        
		@ApiOperation(value ="Find Employee By Phone",notes ="This API is used to find employee by phone")
		@ApiResponses(value={@ApiResponse(code=302,message="Data Found"), @ApiResponse(code=404,message="Phone not found")})
		@GetMapping("/findByPhone/{phone}")
		public ResponseEntity<ResponseStructure<Employee>> findByPhone(@PathVariable long phone) {
			return service.findByPhone(phone);
		}
       
		@ApiOperation(value ="find Employee By Salary GreaterThan",notes ="This API is used to find the employee by salary greater than")
		@ApiResponses(value={@ApiResponse(code=302,message="Data Found"), @ApiResponse(code=404,message="Data not found")})
		@GetMapping("/findBySalaryGreaterThan")
		public ResponseEntity<ResponseStructure<List<Employee>>> findEmployeeBySalaryGreaterThan(@RequestParam double salary) {
			return service.findBySalaryGreaterThan(salary);
		}

		@ApiOperation(value ="find Employee By Salary LessThan",
				notes ="This API is used to find the employee by salary less than")
		@ApiResponses(value={@ApiResponse(code=302,message="Data Found"), @ApiResponse(code=404,message="Data not found")})
		@GetMapping("/findBySalaryLessThan")
		public ResponseEntity<ResponseStructure<List<Employee>>> findEmployeeBySalaryLessThan(@RequestParam double salary) 
		 {
			return service.findBySalaryLessThan(salary);
	     }
		
}


	
		

	
