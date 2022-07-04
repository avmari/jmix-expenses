package com.company.jmixexpenses.screen.typeofexpense;

import io.jmix.ui.screen.*;
import com.company.jmixexpenses.entity.TypeOfExpense;

@UiController("TypeOfExpense.browse")
@UiDescriptor("type-of-expense-browse.xml")
@LookupComponent("typeOfExpensesTable")
public class TypeOfExpenseBrowse extends StandardLookup<TypeOfExpense> {
}