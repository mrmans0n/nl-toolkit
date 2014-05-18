package io.nlopez.toolkit.adapters;

import java.util.List;

import io.nlopez.toolkit.utils.AASingleBindableLayoutBuilder;
import io.nlopez.toolkit.utils.BindableLayoutBuilder;
import io.nlopez.toolkit.views.BindableLayout;

/**
 * Created by mrm on 18/05/14.
 */
public class AASingleAdapter<T, Q extends BindableLayout<T>> extends SingleAdapter {
    public AASingleAdapter(Class viewClass, List listItems) {
        super(viewClass, listItems, new AASingleBindableLayoutBuilder(viewClass));
    }

    public AASingleAdapter(Class viewClass, List listItems, BindableLayoutBuilder builder) {
        super(viewClass, listItems, builder);
    }
}
