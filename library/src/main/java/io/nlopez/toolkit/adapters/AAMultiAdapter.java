package io.nlopez.toolkit.adapters;

import java.util.List;
import java.util.Map;

import io.nlopez.toolkit.utils.AAMultiBindableLayoutBuilder;
import io.nlopez.toolkit.utils.BindableLayoutBuilder;

/**
 * Created by mrm on 18/05/14.
 */
public class AAMultiAdapter extends MultiAdapter {

    public AAMultiAdapter(Map<Class, Class> itemViewMapping, List listItems) {
        super(itemViewMapping, listItems, new AAMultiBindableLayoutBuilder(itemViewMapping));
    }

    public AAMultiAdapter(Map<Class, Class> itemViewMapping, List listItems, BindableLayoutBuilder builder) {
        super(itemViewMapping, listItems, builder);
    }
}
