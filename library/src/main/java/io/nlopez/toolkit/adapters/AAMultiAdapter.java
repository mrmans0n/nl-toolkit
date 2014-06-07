package io.nlopez.toolkit.adapters;

import java.util.List;
import java.util.Map;

import io.nlopez.toolkit.utils.AAMultiBindableLayoutBuilder;
import io.nlopez.toolkit.utils.BindableLayoutBuilder;
import io.nlopez.toolkit.views.BindableLayout;

/**
 * Created by mrm on 18/05/14.
 */
public class AAMultiAdapter extends MultiAdapter {

    public AAMultiAdapter(Map<Class, Class<? extends BindableLayout>> itemViewMapping, List listItems) {
        super(itemViewMapping, listItems, new AAMultiBindableLayoutBuilder(itemViewMapping));
    }

    public AAMultiAdapter(Map<Class, Class<? extends BindableLayout>> itemViewMapping, List listItems, BindableLayoutBuilder builder) {
        super(itemViewMapping, listItems, builder);
    }

    public AAMultiAdapter(Mapper mapper, List listItems, BindableLayoutBuilder builder) {
        super(mapper, listItems, builder);
    }
}
