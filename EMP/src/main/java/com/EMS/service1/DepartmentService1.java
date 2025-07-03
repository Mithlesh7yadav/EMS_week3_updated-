package com.EMS.service1;

import com.EMS.entity.Department;
import com.EMS.exception.ResourceNotFoundException;
import com.EMS.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService1 {
    private final DepartmentRepository repository;

    public List<Department> getAll() {
        return repository.findAll();
    }

    public Department getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found"));
    }

    public Department create(Department department) {
        try {
            return repository.save(department);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create department", e);
        }
    }

    public Department update(Long id, Department updated) {
        Department existing = getById(id);
        try {
            existing.setName(updated.getName());
            return repository.save(existing);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update department", e);
        }
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete department", e);
        }
    }
}
