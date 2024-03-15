package com.example.EMP.Services;

import com.example.EMP.Entity.Employee;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public interface EmployeeServices {
     Employee createEmployee(Employee employee);
     List<Employee> getAllEmployee();
     Employee getSingleEmployee(int empId);
     boolean deleteEmployee(int empId);
     Employee updateEmployee(Employee employee , int empId);


}
