package com.company.jmixexpenses.screen.typeofexpense;

import io.jmix.ui.screen.*;
import com.company.jmixexpenses.entity.TypeOfExpense;

@UiController("TypeOfExpense.edit")
@UiDescriptor("type-of-expense-edit.xml")
@EditedEntityContainer("typeOfExpenseDc")
public class TypeOfExpenseEdit extends StandardEditor<TypeOfExpense> {
}