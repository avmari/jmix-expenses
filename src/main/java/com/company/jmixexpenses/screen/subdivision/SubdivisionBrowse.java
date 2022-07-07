package com.company.jmixexpenses.screen.subdivision;

import io.jmix.core.DataManager;
import io.jmix.ui.component.Component;
import io.jmix.ui.component.Table;
import io.jmix.ui.screen.*;
import com.company.jmixexpenses.entity.Subdivision;
import org.springframework.beans.factory.annotation.Autowired;


@UiController("Subdivision.browse")
@UiDescriptor("subdivision-browse.xml")
@LookupComponent("subdivisionsTable")
public class SubdivisionBrowse extends StandardLookup<Subdivision> {
    @Autowired
    private DataManager dataManager;

    @Install(to = "subdivisionsTable.amountOfStaff", subject = "columnGenerator")
    private Component tableGeneratedColumnAmountOfStaffColumnGenerator(Subdivision subdivision) {
        return new Table.PlainTextCell(dataManager.loadValue("select count(em) from Employee em where " +
                "em.subdivision.name = :subdivisionName", Integer.class)
                .parameter("subdivisionName", subdivision.getName())
                .one().toString());
    }

}