package com.example.EmployeeManagement.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;


    @Column(name="Role", nullable = false,updatable=false)
    private String role;

    @Column(name="password",nullable = false)
    private String password;





    @Column(name = "username", nullable = false)
    private String username;


    @Column(name = "salary", nullable = false)
    private int salary;
}
