package com.mgumussoy.kodluyoruz.business.service;

import com.mgumussoy.kodluyoruz.business.dto.EmployeeDto;
import com.mgumussoy.kodluyoruz.data.entity.EmployeeEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface EmployeeServices {

    List<EmployeeDto> getAllEmployees();

    void createEmployee(EmployeeDto employeeDto);

    ResponseEntity<EmployeeDto> getEmployeeById(Long id);

    ResponseEntity<EmployeeDto> updateEmployee(Long id, EmployeeDto employeeDto);

    ResponseEntity<Map<String, Boolean>> deleteEmployee(Long id);


    EmployeeDto EntityToDto(EmployeeEntity employeeEntity);

    EmployeeEntity DtoToEntity(EmployeeDto employeeDto);
}
