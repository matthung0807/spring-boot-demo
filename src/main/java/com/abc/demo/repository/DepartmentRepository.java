package com.abc.demo.repository;

import com.abc.demo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query("SELECT d FROM Department d " +
            " JOIN d.employeeList " +
            " WHERE d.id = :id")
    Optional<Department> findByIdJoinEmployee(@Param("id") Long id);


    @Query("SELECT d FROM Department d " +
            " JOIN d.employeeList e " +
            " WHERE e.id = :id")
    Optional<Department> findByEmployeeIdJoinEmployee(@Param("id") long id);
}
