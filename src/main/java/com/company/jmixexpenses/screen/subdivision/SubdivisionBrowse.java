package com.company.jmixexpenses.screen.subdivision;

import io.jmix.core.DataManager;
import io.jmix.core.entity.KeyValueEntity;
import io.jmix.ui.ScreenBuilders;
import io.jmix.ui.action.Action;
import io.jmix.ui.component.Button;
import io.jmix.ui.component.GroupTable;
import io.jmix.ui.model.KeyValueCollectionLoader;
import io.jmix.ui.screen.*;
import com.company.jmixexpenses.entity.Subdivision;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Consumer;

@UiController("Subdivision.browse")
@UiDescriptor("subdivision-browse.xml")
@LookupComponent("subdivisionsTable")
public class SubdivisionBrowse extends StandardLookup<Subdivision> {
    @Autowired
    private GroupTable subdivisionsTable;
    @Autowired
    private KeyValueCollectionLoader subdivisionsDl;
    @Autowired
    private ScreenBuilders screenBuilders;
    @Autowired
    private DataManager dataManager;

    @Subscribe("subdivisionsTable.edit")
    public void onSubdivisionsTableEdit(Action.ActionPerformedEvent event) {
        Subdivision subdivision = ((KeyValueEntity) subdivisionsTable.getSingleSelected()).getValue("subdivision");
        screenBuilders.editor(Subdivision.class, this)
                .editEntity(subdivision)
                .build()
                .show()
                .addAfterCloseListener(afterCloseEvent -> {
                    subdivisionsDl.load();
                });
    }

    @Subscribe("subdivisionsTable.create")
    public void onSubdivisionsTableCreate(Action.ActionPerformedEvent event) {
        screenBuilders.editor(Subdivision.class, this)
                .newEntity()
                .build()
                .show()
                .addAfterCloseListener(afterCloseEvent -> {
                    subdivisionsDl.load();
                });
    }

    @Subscribe("subdivisionsTable.remove")
    public void onSubdivisionsTableRemove(Action.ActionPerformedEvent event) {
        Subdivision subdivision = ((KeyValueEntity) subdivisionsTable.getSingleSelected()).getValue("subdivision");
        dataManager.remove(subdivision);
        subdivisionsDl.load();
    }


}