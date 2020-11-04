package com.abc.demo.repository;

import com.abc.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByName(String name);

    @Query("select e from Employee e where e.name = :name")
    Optional<Employee> findByNameJPQL(@Param("name") String name);

}
