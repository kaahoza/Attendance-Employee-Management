package com.anele.employee_management.repository;

import com.anele.employee_management.entity.EmployeeEntity;
import com.anele.employee_management.entity.EmployeeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends  JpaRepository<EmployeeEntity,Long>{
    List<EmployeeEntity> findByStatus(EmployeeStatus status) ;

    boolean existsByEmail(String email) ;
}
