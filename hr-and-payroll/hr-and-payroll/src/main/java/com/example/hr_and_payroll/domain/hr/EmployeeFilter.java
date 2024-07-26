package com.example.hr_and_payroll.domain.hr;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeFilter {
    String firstName;
    String lastName;

    //String email;
    //String standardIds;
    //String iafCodeIds;
    //Long age;
}
