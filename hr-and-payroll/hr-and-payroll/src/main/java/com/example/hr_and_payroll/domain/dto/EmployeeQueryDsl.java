package com.example.hr_and_payroll.domain.dto;

import com.example.hr_and_payroll.domain.entity.QEmployee;
import com.example.hr_and_payroll.domain.hr.EmployeeFilter;
import com.example.hr_and_payroll.repository.QueryDsl;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class EmployeeQueryDsl implements QueryDsl<EmployeeFilter> {
    QEmployee qEmployee = QEmployee.employee;

    @Override
    public Predicate filter(EmployeeFilter filter) {
        BooleanBuilder query = new BooleanBuilder();

        //employee first name
        if (StringUtils.hasText(filter.getFirstName())) {
            query.and(qEmployee.firstName.containsIgnoreCase(filter.getFirstName()));
        }

        //employee last name
        if (StringUtils.hasText(filter.getLastName())) {
            query.and(qEmployee.lastName.containsIgnoreCase(filter.getLastName()));
        }

        return query;
    }

}
