package com.company.jmixexpenses.screen.employee;

import io.jmix.ui.screen.*;
import com.company.jmixexpenses.entity.Employee;

@UiController("Employee.browse")
@UiDescriptor("employee-browse.xml")
@LookupComponent("employeesTable")
public class EmployeeBrowse extends StandardLookup<Employee> {
}