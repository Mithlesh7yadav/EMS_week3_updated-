package com.EMS.service1;

import com.EMS.entity.Employee;
import com.EMS.exception.ResourceNotFoundException;
import com.EMS.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EmployeeService1 {
    private final EmployeeRepository repository;

    public List<Employee> getAll() {
        return repository.findAll();
    }

    public Employee getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
    }

    public Employee create(Employee employee) {
        try {
            return repository.save(employee);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create employee", e);
        }
    }

    public Employee update(Long id, Employee employeeDetails) {
        Employee employee = getById(id);
        try {
            employee.setName(employeeDetails.getName());
            employee.setProject(employeeDetails.getProject());
            employee.setAge(employeeDetails.getAge());
            employee.setSalary(employeeDetails.getSalary());
            employee.setManager(employeeDetails.getManager());
            employee.setDepartment(employeeDetails.getDepartment());
            return repository.save(employee);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update employee", e);
        }
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete employee", e);
        }
    }
}
