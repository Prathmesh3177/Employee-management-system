package com.empdemo.emp_project;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@CrossOrigin("http://localhost:3000/")
public class empController {
    //Dependency Injection
    @Autowired
    EmployeeServie employeeServie;

    //List<Employee> employees = new ArrayList<>();
     //EmployeeServie employeeServie = new EmployeeServieImpl();


    @GetMapping("employees")
    public List<Employee> getAllEmployees() {

        return employeeServie.readEmployees();
    }

    @GetMapping("employees/{id}")
    public Employee getAllEmployeesById(@PathVariable Long id) {

        return employeeServie.readEmployee(id);
    }

    @PostMapping("employees")
    public String createEmployee(@RequestBody Employee employee) {

        employeeServie.creatEmployee(employee);
        return "Saved Succesfully";
    }

    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable Long id){

        if(employeeServie.deleteEmplyoee(id)){
                return "Deleted Successfully";
        }
        return "Not Found";

    }

    @PutMapping("employees/{id}")
    public String updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
       
        
        return employeeServie.updateEmployee(id, employee);
    }
    
    
    
}
