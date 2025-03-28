package com.example.EmployeeManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class EmployeeManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);



		//use this only if u dont have any users in the db this is an pre existing admin with hashed password which is randomly hashed everytime u run this aplication
		String hashedPassword = new BCryptPasswordEncoder().encode("admin123");
		System.out.println("Hashed Password: " + hashedPassword);

	}

}
