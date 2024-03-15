package com.example.EMP.Services;

import com.example.EMP.Entity.Employee;
import com.example.EMP.Repository.EmployeeRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServicesImpl implements EmployeeServices {
    Logger logger = LoggerFactory.getLogger(EmployeeServicesImpl.class);
    @Autowired
    private EmployeeRepo employeeRepo;
    @Override
    public Employee createEmployee(Employee employee) {
        // First Way
//        Employee saveEmp = employeeRepo.save(employee);
//        return saveEmp;

        // Second Way
        return employeeRepo.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee getSingleEmployee(int empId) {
        Employee employeeeIdIsNotFound = employeeRepo.findById(empId).orElseThrow(() -> new RuntimeException("Employee Id is Not Found"));
        return employeeeIdIsNotFound;
    }

    @Override
    public boolean deleteEmployee(int empId) {
        Employee employee = employeeRepo.findById(empId).get();
        employeeRepo.delete(employee);
        return true;
    }

    @Override
    public Employee updateEmployee(Employee employee, int empId) {
        Employee empFound = employeeRepo.findById(empId).orElseThrow(() -> new RuntimeException("User Not Found !!!"));
        empFound.setName(employee.getName());
        empFound.setEmail(employee.getEmail());
        empFound.setSalery(employee.getSalery());
        Employee updatedEmp = employeeRepo.save(empFound);
        return updatedEmp;
    }
}
