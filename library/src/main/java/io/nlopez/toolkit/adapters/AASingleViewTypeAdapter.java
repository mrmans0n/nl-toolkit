package io.nlopez.toolkit.adapters;

import java.util.List;

import io.nlopez.toolkit.utils.AABindableLayoutBuilder;
import io.nlopez.toolkit.utils.BindableLayoutBuilder;
import io.nlopez.toolkit.views.BindableLayout;

/**
 * Created by mrm on 18/05/14.
 */
public class AASingleViewTypeAdapter<T, Q extends BindableLayout<T>> extends SingleViewTypeAdapter {
    public AASingleViewTypeAdapter(Class viewClass, List listItems) {
        super(viewClass, listItems, new AABindableLayoutBuilder(viewClass));
    }

    public AASingleViewTypeAdapter(Class viewClass, List listItems, BindableLayoutBuilder builder) {
        super(viewClass, listItems, builder);
    }
}
