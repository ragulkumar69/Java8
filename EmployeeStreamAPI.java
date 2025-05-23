package com.java8.streams;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeStreamAPI {
	String name;
    String department;
    double salary;
	public EmployeeStreamAPI(String name, String department, double salary) {
		super();
		this.name = name;
		this.department = department;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

    public static void main(String[] args) {
    	List<EmployeeStreamAPI> employees = Arrays.asList(
    		    new EmployeeStreamAPI("Alice", "HR", 50000),
    		    new EmployeeStreamAPI("Bob", "IT", 70000),
    		    new EmployeeStreamAPI("Charlie", "IT", 80000),
    		    new EmployeeStreamAPI("David", "HR", 55000),
    		    new EmployeeStreamAPI("Eve", "Finance", 60000)
    		);
    	
    	//Write a Stream API expression to group employees by department and find the average salary in each department.
    	Map<String, Double> avgSalary = employees.stream().collect(Collectors.groupingBy(EmployeeStreamAPI::getDepartment, Collectors.averagingDouble(EmployeeStreamAPI::getSalary)));
    	System.out.println("avgSalary: "+avgSalary);
    	//Write a Stream API expression to group employees by department, and for each group, collect a list of employee names (not objects, just names).
    	Map<String, List<String>> departmentToNames = employees.stream().collect(Collectors.groupingBy(EmployeeStreamAPI::getDepartment, Collectors.mapping(EmployeeStreamAPI::getName, Collectors.toList())));
    	System.out.println("departmentToNames: "+departmentToNames);
    	
    	List<EmployeeStreamAPI> employeesDept = Arrays.asList(
    		    new EmployeeStreamAPI("Alice", "IT", 30),
    		    new EmployeeStreamAPI("Bob", "HR", 45),
    		    new EmployeeStreamAPI("Charlie", "IT", 25),
    		    new EmployeeStreamAPI("David", "Finance", 40),
    		    new EmployeeStreamAPI("Eve", "HR", 50)
    		);
    	//Write a Stream API expression to find the oldest employee in each department, and return a Map<String, String> where:
    	// #the key is the department name, #the value is the name of the oldest employee in that department
    	Map<String, String> empDept = employeesDept.stream().collect(Collectors.groupingBy(EmployeeStreamAPI::getDepartment, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(EmployeeStreamAPI::getSalary)), Optional -> Optional.get().getName())));
    	System.out.println("empDept result: "+empDept);
    	
    }
}
