package com.mgumussoy.kodluyoruz.ui.rest;

import com.mgumussoy.kodluyoruz.business.dto.EmployeeDto;
import com.mgumussoy.kodluyoruz.business.service.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

    @Autowired
    EmployeeServices employoeeServices;

    //http://localhost:8080/api/v1/index
    @GetMapping({"/index", "/"})
    public String getRoot() {
        return "index";
    }

    //http://localhost:8080/api/v1/employees
    @GetMapping("/employees")
    public List<EmployeeDto> getAllEmployees() {
        return employoeeServices.getAllEmployees();
    }

    //http://localhost:8080/api/v1/employees/1
    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {
        return employoeeServices.getEmployeeById(id);
    }

    //http://localhost:8080/api/v1/employees
    @PostMapping("/employees")
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto) {
        employoeeServices.createEmployee(employeeDto);
        return employeeDto;
    }

    //http://localhost:8080/api/v1/employees/1
    @PutMapping("/employees/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) {
        return employoeeServices.updateEmployee(id, employeeDto);
    }

    //http://localhost:8080/api/v1/employees/1
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {
        return employoeeServices.deleteEmployee(id);
    }


}
