package com.anele.employee_management.service;

import com.anele.employee_management.entity.EmployeeEntity;
import com.anele.employee_management.dto.EmployeeResponse;
import com.anele.employee_management.dto.EmployeeDTO;
import com.anele.employee_management.entity.EmployeeStatus;
import com.anele.employee_management.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional(readOnly = true)
    public List<EmployeeResponse> getAllActiveEmployees() {
        return employeeRepository.findByStatus(EmployeeStatus.ACTIVE)
                .stream()
                .map(this::convertToResponseDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public EmployeeResponse addEmployee(EmployeeDTO dto) {
        if (employeeRepository.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("An employee with this email already exists");
        }

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setFirstName(dto.getFirstName());
        employeeEntity.setLastName(dto.getLastName());
        employeeEntity.setEmail(dto.getEmail());
        employeeEntity.setPhone(dto.getPhone());
        employeeEntity.setDepartment(dto.getDepartment());
        employeeEntity.setPosition(dto.getPosition());
        employeeEntity.setSalary(dto.getSalary());

        // Assign the Enum directly to prevent runtime crashes
        employeeEntity.setStatus(EmployeeStatus.ACTIVE);

        EmployeeEntity savedEntity = employeeRepository.save(employeeEntity);
        return convertToResponseDto(savedEntity);
    }


    private EmployeeResponse convertToResponseDto(EmployeeEntity employeeEntity) {
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setId(employeeEntity.getId());
        employeeResponse.setFirstName(employeeEntity.getFirstName());
        employeeResponse.setLastName(employeeEntity.getLastName());
        employeeResponse.setEmail(employeeEntity.getEmail());
        employeeResponse.setPhone(employeeEntity.getPhone());
        employeeResponse.setDepartment(employeeEntity.getDepartment());

        if (employeeEntity.getStatus() != null) {
            employeeResponse.setStatus(employeeEntity.getStatus().name());
        }

        return employeeResponse;
    }
}
