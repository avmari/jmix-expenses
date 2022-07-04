package com.company.jmixexpenses.screen.subdivision;

import io.jmix.ui.screen.*;
import com.company.jmixexpenses.entity.Subdivision;

@UiController("Subdivision.browse")
@UiDescriptor("subdivision-browse.xml")
@LookupComponent("subdivisionsTable")
public class SubdivisionBrowse extends StandardLookup<Subdivision> {
}