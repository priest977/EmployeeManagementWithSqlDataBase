package com.example.EMP.Controller;

import com.example.EMP.Entity.Employee;
import com.example.EMP.Services.EmployeeServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {

    @Autowired
    private EmployeeServicesImpl employeeServices;
    @GetMapping("/AllEmp")
    public ResponseEntity<?> getAllEmp(){
        List<Employee> allEmployee = employeeServices.getAllEmployee();
        return new ResponseEntity<>(allEmployee, HttpStatus.OK);
    }
    @GetMapping("/SingleEmp/{empId}")
    public ResponseEntity<?> getSingleEmp (@PathVariable int empId){
        Employee singleEmployee = employeeServices.getSingleEmployee(empId);
        return new ResponseEntity<>(singleEmployee , HttpStatus.NOT_FOUND);
    }
    @PostMapping("/PostAllEmp")
    public ResponseEntity<?> postEmp(@RequestBody Employee employee){
        Employee empCreated = employeeServices.createEmployee(employee);
        return new ResponseEntity<>(empCreated , HttpStatus.CREATED);
    }

    @DeleteMapping ("/DeleteEmp/{empId}")
    public ResponseEntity<?> delSingleEmp (@PathVariable int empId){
        boolean b = employeeServices.deleteEmployee(empId);
        return new ResponseEntity<>(b , HttpStatus.OK);
    }

    @PutMapping("/updateEmp/{empId}")
    public ResponseEntity<?> updatedEmployee(@RequestBody Employee employee ,@PathVariable int empId ){
        Employee updatedEmp = employeeServices.updateEmployee(employee, empId);
        return new ResponseEntity<>(updatedEmp , HttpStatus.CREATED);
    }
}
