package com.abc.demo.repository;

import com.abc.demo.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

@SpringBootTest
public class EmployeeRepositoryTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void test() {

        String name = "Andy";
        int age = 20;

        employeeRepository.findAll(new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                Predicate predicate = cb.and(
                        cb.equal(root.get("name"), name),
                        cb.greaterThan(root.get("age"), age));
                cq.orderBy(cb.desc(root.get("id")));
                return predicate;
            }
        });

    }

}
