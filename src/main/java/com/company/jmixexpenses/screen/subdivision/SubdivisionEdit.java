package com.company.jmixexpenses.screen.subdivision;

import io.jmix.ui.screen.*;
import com.company.jmixexpenses.entity.Subdivision;

@UiController("Subdivision.edit")
@UiDescriptor("subdivision-edit.xml")
@EditedEntityContainer("subdivisionDc")
public class SubdivisionEdit extends StandardEditor<Subdivision> {
}