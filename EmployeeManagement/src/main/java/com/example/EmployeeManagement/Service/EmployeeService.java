package com.example.EmployeeManagement.Service;

import com.example.EmployeeManagement.Entity.Employee;
import com.example.EmployeeManagement.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder; // ✅ Inject PasswordEncoder

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // ✅ Add Employee with Hashed Password
    public Employee addEmployee(Employee employee) {
        employee.setPassword(passwordEncoder.encode(employee.getPassword())); // Hash password
        return repository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Optional<Employee> optionalEmployee = repository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setUsername(employeeDetails.getUsername());
            employee.setSalary(employeeDetails.getSalary());

            // ✅ Update password only if provided & not blank
            if (employeeDetails.getPassword() != null && !employeeDetails.getPassword().trim().isEmpty()) {
                employee.setPassword(passwordEncoder.encode(employeeDetails.getPassword()));
            }

            return repository.save(employee);
        }
        return null;
    }

    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}
