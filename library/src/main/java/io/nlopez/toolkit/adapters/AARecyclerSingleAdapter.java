package io.nlopez.toolkit.adapters;

import io.nlopez.toolkit.utils.BindableLayoutBuilder;
import io.nlopez.toolkit.views.BindableLayout;

import java.util.List;

/**
 * Created by mrm on 18/05/14.
 */
public class AARecyclerSingleAdapter<T, Q extends BindableLayout<T>> extends RecyclerSingleAdapter {
    public AARecyclerSingleAdapter(Class viewClass, List listItems) {
        super(viewClass, listItems, new AASingleBindableLayoutBuilder(viewClass));
    }

    public AARecyclerSingleAdapter(Class viewClass, List listItems, BindableLayoutBuilder builder) {
        super(viewClass, listItems, builder);
    }
}
