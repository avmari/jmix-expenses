package com.company.jmixexpenses.screen.expense;

import io.jmix.core.FileRef;
import io.jmix.ui.component.GroupTable;
import io.jmix.ui.screen.*;
import com.company.jmixexpenses.entity.Expense;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("Expense.browse")
@UiDescriptor("expense-browse.xml")
@LookupComponent("expensesTable")
public class ExpenseBrowse extends StandardLookup<Expense> {
    @Autowired
    private GroupTable<Expense> expensesTable;
    @Subscribe
    public void onInit(InitEvent event) {
        expensesTable.getColumn("document").setFormatter(value -> {
            return ((FileRef)value).getFileName();
        });
    }
}