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

    public void createEmployee(@RequestBody EmployeeDto employeeDto) { //@RequestBody
        EmployeeEntity employeeEntity = DtoToEntity(employeeDto);//ModelMapper
        employeeRepository.save(employeeEntity);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable(name = "id") Long id) {
        EmployeeEntity employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable(name = "id") Long id, @RequestBody EmployeeDto employeeDetails) {
        EmployeeEntity employeeEntity = DtoToEntity(employeeDetails);//ModelMapper

        EmployeeEntity employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        employee.setFirstName(employeeEntity.getFirstName());
        employee.setLastName(employeeEntity.getLastName());
        employee.setEmailId(employeeEntity.getEmailId());

        EmployeeEntity updatedEmployee = employeeRepository.save(employee);
        EmployeeDto employeeDto = EntityToDto(updatedEmployee);//model
        return ResponseEntity.ok(employeeDto);
    }

    @Override
    public EmployeeDto EntityToDto(EmployeeEntity employeeEntity) {
        return modelMapper.map(employeeEntity, EmployeeDto.class);
    }

    @Override
    public EmployeeEntity DtoToEntity(EmployeeDto employeeDto) {
        return modelMapper.map(employeeDto, EmployeeEntity.class);
    }
}