package com.java8.streams;
// File: FindSecondHighestSalary.java
import java.util.*;
import java.util.stream.Collectors;

public class FindSecondHighestSalary {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Aditi", 30, 100000, "F", "HR", "Mumbai", 1995),
            new Employee(2, "Rahul", 25, 130000, "M", "Engineering", "Bangalore", 2000),
            new Employee(3, "Vishal", 34, 110000, "M", "Engineering", "Mumbai", 1998),
            new Employee(4, "Lakshmi", 28, 150000, "F", "HR", "Bangalore", 1992),
            new Employee(5, "Priya", 24, 90000, "F", "Marketing", "Delhi", 2005),
            new Employee(6, "Rohit", 29, 150000, "M", "Engineering", "Bangalore", 1999)
        );

        long secondHighestSalary = employees.stream()
                                            .mapToLong(Employee::getSalary)
                                            .boxed()
                                            .distinct()
                                            .sorted(Comparator.reverseOrder())
                                            .skip(1)
                                            .findFirst()
                                            .get();
        
        System.out.println("The second highest salary in the organization is: " + secondHighestSalary);
        //The second highest salary in the organization is: 130000


        Employee simple = employees.stream().sorted(Comparator.comparingLong(Employee::getSalary).reversed()).skip(1).findFirst().get();
        System.out.println("simple: "+simple);
        //because of toString method it is printing all
        //simple: Employee [id=6, name=Rohit, age=29, salary=150000, gender=M, deptName=Engineering, city=Bangalore, yearOfJoining=1999]
    }
}
