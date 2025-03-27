package com.example.EmployeeManagement.Entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="username", nullable = false, unique = true)
    private String username;

    @Column(name="password", nullable = false)
    private String password; // Must be encoded

    @Column(name="gmail", nullable= false)
    private String email;

    @Column(name="DOB", nullable = false)
    private Integer DOB;

}
