package com.example.hr_and_payroll.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
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

    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Employee> employees;

    public Department(String name) {
        this.name = name;
    }

    // Constructors, getters, setters


}
