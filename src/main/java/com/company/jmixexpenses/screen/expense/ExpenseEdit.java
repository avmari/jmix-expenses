package com.company.jmixexpenses.screen.expense;

import com.company.jmixexpenses.app.ExpenseService;
import com.company.jmixexpenses.entity.Employee;
import com.company.jmixexpenses.entity.TypeOfExpense;
import com.company.jmixexpenses.exception.ExceedingFundsLimitException;
import io.jmix.core.DataManager;
import io.jmix.ui.component.*;
import io.jmix.ui.screen.*;
import com.company.jmixexpenses.entity.Expense;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

@UiController("Expense.edit")
@UiDescriptor("expense-edit.xml")
@EditedEntityContainer("expenseDc")
public class ExpenseEdit extends StandardEditor<Expense> {
    @Autowired
    private Form form;
    @Autowired
    private ExpenseService expenseService;
    @Autowired
    private TextField<Integer> amountField;
    @Autowired
    private DateField<LocalDate> dateField;
    @Autowired
    private FileStorageUploadField documentField;
    @Autowired
    private EntityPicker<Employee> employeeField;
    @Autowired
    private EntityPicker<TypeOfExpense> typeOfExpenseField;
    @Autowired
    private DataManager dataManager;

    @Subscribe("tryNewExpenseBtn")
    protected void onCommitAndCloseButtonClick(Button.ClickEvent event) {

        Expense newExpense = dataManager.create(Expense.class);
        newExpense.setTypeOfExpense(typeOfExpenseField.getValue());
        newExpense.setAmount(amountField.getValue());
        newExpense.setDate(dateField.getValue());
        newExpense.setDocument(documentField.getValue());
        newExpense.setEmployee(employeeField.getValue());

        if (expenseService.canProduceAnExpense(newExpense)) {
            close(StandardOutcome.CLOSE);
            return;
        } else
            throw new ExceedingFundsLimitException();
    }
}