package com.qsp.springbootemployee2.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Entity
public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message="name can't be blank")      
	@NotNull(message="name can't be null")
	private String name;
	
	@Column(unique = true)  
	@Min(value = 6000000000l)
	@Max(value = 9999999999l)
	//@Pattern(regexp="[6-9][0-9]{9}") 
	private long phone;
	
	@Column(unique = true)
	@NotNull(message="email can't be null")
	@NotBlank(message="email can't be blank")
	@Email(regexp = "[a-z0-9._%$+-]+@[a-z0-9]+\\.[a-z]{2,3}",message = "Invalid Email")   //set validation to email
	private String email;
	
	@Min(value = 1)                                                   
	private double salary;
	
	private char grade;                                                 
	
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", salary=" + salary
				+ ", grade=" + grade + "]";
	}
	
}
