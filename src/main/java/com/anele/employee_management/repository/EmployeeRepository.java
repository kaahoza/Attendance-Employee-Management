package com.anele.employee_management.repository;

import com.anele.employee_management.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EmployeeRepository extends  JpaRepository<EmployeeEntity,String>{
}
