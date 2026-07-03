package com.anele.employee_management.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data

public class EmployeeDTO {
    private Long id;

    @NotBlank(message = "First name is required")
    @Size(min = 2, max = 100, message = "Employee first name must be grater than 2 characters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(min = 2, max = 100, message = "employee last name must be grater than 2 characters")
    private String lastName;

    @Email(message = "Invalid email")
    @NotBlank
    private String email;

    @Size
    private String phone;

    @NotBlank(message = "Department is required")
    private String department;

    @NotBlank(message = "Position is required")
    private String position;

    @NotBlank(message = "Salary must be positive")
    private String  salary;

    public EmployeeDTO(){}

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
