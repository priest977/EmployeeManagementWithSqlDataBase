package com.example.EMP.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Employee_Data")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Emp_Id")
    private int id;
    @Column(name = "Emp_Name")
    private String name ;
    @Column(name = "Emp_Salery")
    private  Long salery;
    @Column(name = "Emp_Email")
    private String email;
}
