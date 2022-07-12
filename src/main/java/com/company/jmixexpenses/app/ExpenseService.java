package com.company.jmixexpenses.app;

import com.company.jmixexpenses.entity.Employee;
import com.company.jmixexpenses.entity.Expense;
import com.company.jmixexpenses.entity.TypeOfExpense;
import com.company.jmixexpenses.exception.ExceedingFundsLimitException;
import io.jmix.core.DataManager;
import io.jmix.core.FluentValueLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.UUID;


@Service
public class ExpenseService {

    @Autowired
    private DataManager dataManager;

    public boolean canProduceAnExpense(Expense expense){
        YearMonth month = YearMonth.from(expense.getDate());
        LocalDate start = month.atDay(1);
        LocalDate end = month.atEndOfMonth();

        Integer limitFunds = dataManager.load(TypeOfExpense.class)
                .id(expense.getTypeOfExpense().getId()).one().getFundsLimit();
        Integer sumOfPreviousExpenses = dataManager.loadValue("select sum(ex.amount) from " +
                "Expense ex where ex.employee.id = :employeeId and ex.typeOfExpense.id = :typeOfExpenseId and " +
                "ex.date between :start and :end", Integer.class)
                .parameter("employeeId", expense.getEmployee().getId())
                .parameter("typeOfExpenseId", expense.getTypeOfExpense().getId())
                .parameter("start", start)
                .parameter("end", end)
                .one();
        if (sumOfPreviousExpenses == null && expense.getAmount() <= limitFunds || sumOfPreviousExpenses + expense.getAmount() <= limitFunds){
            dataManager.save(expense);
            return true;
        }
        return false;
    }
}