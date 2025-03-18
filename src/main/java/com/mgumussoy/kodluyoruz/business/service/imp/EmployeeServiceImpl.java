package com.mgumussoy.kodluyoruz.business.service.imp;

import com.mgumussoy.kodluyoruz.business.dto.EmployeeDto;
import com.mgumussoy.kodluyoruz.business.service.EmployeeServices;
import com.mgumussoy.kodluyoruz.data.entity.EmployeeEntity;
import com.mgumussoy.kodluyoruz.data.repository.EmployeeRepository;
import com.mgumussoy.kodluyoruz.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeServices {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;


    //LIST
    // http://localhost:8080/api/v1/employees
    @GetMapping("/employees")
    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeDto> listDto = new ArrayList<>();
        Iterable<EmployeeEntity> teacherList = employeeRepository.findAll();
        for (EmployeeEntity entity : teacherList) {
            EmployeeDto employeeDto = EntityToDto(entity);//model
            listDto.add(employeeDto);
        }
        return listDto;
    }

    //FIND
    // http://localhost:8080/api/v1/employees/1
    @GetMapping("/employees/{id}")
    @Override
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable(name = "id") Long id) {

        EmployeeEntity employee =
                employeeRepository
                        .findById(id)
                        .orElseThrow(
                                () -> new ResourceNotFoundException("Employee " + id + " numaralı product id bulunamadı !!!!")
                        );

        EmployeeDto employeeDto = EntityToDto(employee);//model
        return ResponseEntity.ok(employeeDto);
    }

    //SAVE
    // http://localhost:8080/api/v1/employees
    @PostMapping("/employees")
    public void createEmployee(@RequestBody EmployeeDto employeeDto) { //@RequestBody
        EmployeeEntity employeeEntity = DtoToEntity(employeeDto);//ModelMapper
        employeeRepository.save(employeeEntity);
    }

    //DELETE
    // http://localhost:8080/api/v1/employees
    @DeleteMapping("/employees/{id}")
    @Override
    public void deleteEmployee(@PathVariable(name = "id") Long id) {
        EmployeeEntity employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        ResponseEntity.ok(response);
    }

    //UPDATE
    // http://localhost:8080/api/v1/employees
    @PutMapping("/employees/{id}")
    @Override
    public void updateEmployee(@PathVariable(name = "id") Long id, @RequestBody EmployeeDto employeeDetails) {
        EmployeeEntity employeeEntity = DtoToEntity(employeeDetails);//ModelMapper

        EmployeeEntity employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        employee.setFirstName(employeeEntity.getFirstName());
        employee.setLastName(employeeEntity.getLastName());
        employee.setEmailId(employeeEntity.getEmailId());

        EmployeeEntity updatedEmployee = employeeRepository.save(employee);
        EmployeeDto employeeDto = EntityToDto(updatedEmployee);//model
        ResponseEntity.ok(employeeDto);
    }


    /// /////////////////////////////////
    //Model Mapper Entity ==> Dto
    @Override
    public EmployeeDto EntityToDto(EmployeeEntity employeeEntity) {
        return modelMapper.map(employeeEntity, EmployeeDto.class);
    }

    //Model Mapper Dto  ==> Entity
    @Override
    public EmployeeEntity DtoToEntity(EmployeeDto employeeDto) {
        return modelMapper.map(employeeDto, EmployeeEntity.class);
    }
}