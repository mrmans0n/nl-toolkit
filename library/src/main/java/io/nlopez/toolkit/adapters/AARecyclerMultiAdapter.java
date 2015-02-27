package io.nlopez.toolkit.adapters;

import io.nlopez.toolkit.utils.BindableLayoutBuilder;
import io.nlopez.toolkit.views.BindableLayout;

import java.util.List;
import java.util.Map;

/**
 * Created by mrm on 18/05/14.
 */
public class AARecyclerMultiAdapter extends RecyclerMultiAdapter {

    public AARecyclerMultiAdapter(Map<Class, Class<? extends BindableLayout>> itemViewMapping, List listItems) {
        super(itemViewMapping, listItems, new AAMultiBindableLayoutBuilder(itemViewMapping));
    }

    public AARecyclerMultiAdapter(Mapper mapper, List listItems) {
        this(mapper.asMap(), listItems);
    }

    public AARecyclerMultiAdapter(Map<Class, Class<? extends BindableLayout>> itemViewMapping, List listItems,
                                  BindableLayoutBuilder builder) {
        super(itemViewMapping, listItems, builder);
    }

    public AARecyclerMultiAdapter(Mapper mapper, List listItems, BindableLayoutBuilder builder) {
        super(mapper, listItems, builder);
    }
}
