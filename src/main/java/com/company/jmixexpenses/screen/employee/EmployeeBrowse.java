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
    static private boolean isStartDatePicked = false;
    static private boolean isEndDatePicked = false;
    static private boolean isTableRowPicked = false;
    static private Employee selectedEmployee;

    @Autowired
    private Button createReportBtn;

    @Subscribe("startDate")
    public void onStartDateValueChange(HasValue.ValueChangeEvent<LocalDate> event) {
        isStartDatePicked = true;
        if(isEndDatePicked && isTableRowPicked)
            createReportBtn.setEnabled(true);
    }

    @Subscribe("endDate")
    public void onEndDateValueChange(HasValue.ValueChangeEvent<LocalDate> event) {
        isEndDatePicked = true;
        if(isStartDatePicked && isTableRowPicked)
            createReportBtn.setEnabled(true);
    }

    @Subscribe("employeesTable")
    public void onEmployeesTableSelection(Table.SelectionEvent<Employee> event) {
        selectedEmployee = event.getSource().getSingleSelected();
        isTableRowPicked = true;
        if(isStartDatePicked && isEndDatePicked)
            createReportBtn.setEnabled(true);
    }


    @Subscribe("createReportBtn")
    protected void onCreateReportButtonClick(Button.ClickEvent event) {
    }
}