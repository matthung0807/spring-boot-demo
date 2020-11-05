package com.abc.demo.repository;

import com.abc.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e " +
            " JOIN e.department d " +
            " WHERE d.id = :id")
    List<Employee> findByDepartmentIdJoinDepartment(@Param("id") long id);


    @Query("SELECT e FROM Employee e " +
            " LEFT JOIN e.department d " +
            " WHERE e.age < :age")
    List<Employee> findByAgeLessThanLeftJoinDepartment(@Param("age") int age);

}
