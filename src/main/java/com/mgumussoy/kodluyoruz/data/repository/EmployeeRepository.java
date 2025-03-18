package com.mgumussoy.kodluyoruz.data.repository;

import com.mgumussoy.kodluyoruz.data.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//JpaRepository>CrudRepository (JpaRepository is more comprehensive)
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
}
