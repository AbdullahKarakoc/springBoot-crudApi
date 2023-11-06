package com.java1.springBootdemo.repository;

import com.java1.springBootdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Employee findByName(String name);
}
