package com.mgumussoy.kodluyoruz.business.service;

import com.mgumussoy.kodluyoruz.business.dto.EmployeeDto;
import com.mgumussoy.kodluyoruz.data.entity.EmployeeEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeServices {

    List<EmployeeDto> getAllEmployees();

    void createEmployee(EmployeeDto employeeDto);

    ResponseEntity<EmployeeDto> getEmployeeById(Long id);

    void updateEmployee(Long id, EmployeeDto employeeDto);

    void deleteEmployee(Long id);


    EmployeeDto EntityToDto(EmployeeEntity employeeEntity);

    EmployeeEntity DtoToEntity(EmployeeDto employeeDto);
}
