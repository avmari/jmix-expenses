package com.company.jmixexpenses.screen.employee;

import io.jmix.ui.component.Button;
import io.jmix.ui.component.HasValue;
import io.jmix.ui.component.SingleSelectList;
import io.jmix.ui.component.Table;
import io.jmix.ui.screen.*;
import com.company.jmixexpenses.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

@UiController("Employee.browse")
@UiDescriptor("employee-browse.xml")
@LookupComponent("employeesTable")
public class EmployeeBrowse extends StandardLookup<Employee> {
}