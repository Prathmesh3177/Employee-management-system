package com.empdemo.emp_project;

import java.util.List;

import org.springframework.stereotype.Service;


public interface EmployeeServie {
    String creatEmployee(Employee employee);
    List<Employee>readEmployees();
    Boolean deleteEmplyoee(Long id);
    String updateEmployee(Long id, Employee employee);
    Employee readEmployee(Long id);
}
