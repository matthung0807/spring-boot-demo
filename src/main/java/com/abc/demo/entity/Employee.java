package com.abc.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Employee implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Long departmentId;

    private String name;

    private Integer age;

    /**
     * 姓名等於
     * @param name 名稱
     * @return 名稱等於spec
     */
    public static Specification<Employee> nameEquals(String name) {
        return (root, query, builder) ->
                builder.equal(root.get("name"), name);

    }

    /**
     * 年齡大於
     * @param age 年齡
     * @return 年齡大於spec
     */
    public static Specification<Employee> ageGreaterThan(int age) {
        return (root, query, builder) ->
                builder.greaterThan(root.get("age"), age);
    }

}
