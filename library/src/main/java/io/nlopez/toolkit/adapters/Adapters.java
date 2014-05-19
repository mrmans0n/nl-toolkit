package io.nlopez.toolkit.adapters;

import java.util.List;
import java.util.Map;

import io.nlopez.toolkit.utils.BindableLayoutBuilder;
import io.nlopez.toolkit.views.BindableLayout;

/**
 * Created by mrm on 19/05/14.
 */
public class Adapters {

    public static <T, Q extends BindableLayout<T>> SingleAdapter<T, Q> newSingleAdapter(Class viewClass, List listItems) {
        return new SingleAdapter<T, Q>(viewClass, listItems);
    }

    public static <T, Q extends BindableLayout<T>> SingleAdapter<T, Q> newSingleAdapter(Class viewClass, List listItems, BindableLayoutBuilder<T, Q> builder) {
        return new SingleAdapter<T, Q>(viewClass, listItems, builder);
    }

    public static <T, Q extends BindableLayout<T>> AASingleAdapter<T, Q> newAASingleAdapter(Class viewClass, List listItems) {
        return new AASingleAdapter<T, Q>(viewClass, listItems);
    }

    public static <T, Q extends BindableLayout<T>> SingleAdapter<T, Q> newAASingleAdapter(Class viewClass, List listItems, BindableLayoutBuilder<T, Q> builder) {
        return new SingleAdapter<T, Q>(viewClass, listItems, builder);
    }

    public static MultiAdapter newMultiAdapter(Map<Class, Class<? extends BindableLayout>> itemViewMapping, List listItems) {
        return new MultiAdapter(itemViewMapping, listItems);
    }

    public static MultiAdapter newMultiAdapter(Map<Class, Class<? extends BindableLayout>> itemViewMapping, List listItems, BindableLayoutBuilder builder) {
        return new MultiAdapter(itemViewMapping, listItems, builder);
    }

    public static AAMultiAdapter newAAMultiAdapter(Map<Class, Class<? extends BindableLayout>> itemViewMapping, List listItems) {
        return new AAMultiAdapter(itemViewMapping, listItems);
    }

    public static AAMultiAdapter newAAMultiAdapter(Map<Class, Class<? extends BindableLayout>> itemViewMapping, List listItems, BindableLayoutBuilder builder) {
        return new AAMultiAdapter(itemViewMapping, listItems, builder);
    }
}
