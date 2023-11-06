package com.java1.springBootdemo.service;

import com.java1.springBootdemo.entity.Employee;
import com.java1.springBootdemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {this.repository = repository;}

    public Employee saveEmployee(Employee employee){
        return repository.save(employee);
    }
    public List<Employee> saveEmployees(List<Employee> employees){
        return repository.saveAll(employees);
    }

    public List<Employee> getEmployees(){
        return repository.findAll();
    }
    public Employee getEmployeeById(int id){
        return repository.findById(id).orElse(null);
    }
    public Employee getEmployeeByName(String name){
        return repository.findByName(name);
    }

    public String deleteEmployee(int id){
        repository.deleteById(id);
        return "!!! Employee information is Deleted !!! "+id;
    }

    public Employee updateEmployee(Employee employee){
        Employee existingEmployee=repository.findById(employee.getId()).orElse(null);
        assert existingEmployee != null;
        existingEmployee.setName(employee.getName());
        existingEmployee.setGender(employee.getGender());
        existingEmployee.setAge(employee.getAge());
        return repository.save(existingEmployee);
    }


}
