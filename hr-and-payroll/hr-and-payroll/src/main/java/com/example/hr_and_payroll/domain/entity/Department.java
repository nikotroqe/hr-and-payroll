package com.example.hr_and_payroll.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "departments")
public class Department extends BaseDomain {
    @Column(name = "name", nullable = false)
    private String name;
    @OneToMany(mappedBy = "department")
    private Set<Employee> employees;

    public Department(String name) {
        this.name = name;
    }

    // Constructors, getters, setters


}
