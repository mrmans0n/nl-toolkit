package io.nlopez.toolkit.adapters;

import java.util.List;
import java.util.Map;

import io.nlopez.toolkit.utils.BindableLayoutBuilder;
import io.nlopez.toolkit.views.BindableLayout;

/**
 * Created by mrm on 19/05/14.
 */
public class Adapters {

    // SingleAdapters

    public static <T, Q extends BindableLayout<T>> SingleAdapter<T, Q> newSingleAdapter(Class viewClass, List listItems) {
        return new SingleAdapter<T, Q>(viewClass, listItems);
    }

    public static <T, Q extends BindableLayout<T>> SingleAdapter<T, Q> newSingleAdapter(Class viewClass, List listItems, BindableLayoutBuilder<T, Q> builder) {
        return new SingleAdapter<T, Q>(viewClass, listItems, builder);
    }

    public static <T, Q extends BindableLayout<T>> AASingleAdapter<T, Q> newAASingleAdapter(Class viewClass, List listItems) {
        return new AASingleAdapter<T, Q>(viewClass, listItems);
    }

    public static <T, Q extends BindableLayout<T>> AASingleAdapter<T, Q> newAASingleAdapter(Class viewClass, List listItems, BindableLayoutBuilder<T, Q> builder) {
        return new AASingleAdapter<T, Q>(viewClass, listItems, builder);
    }

    // RecyclerSingleAdapters

    public static <T, Q extends BindableLayout<T>> RecyclerSingleAdapter<T, Q> newRecyclerSingleAdapter(Class viewClass, List listItems) {
        return new RecyclerSingleAdapter<T, Q>(viewClass, listItems);
    }

    public static <T, Q extends BindableLayout<T>> RecyclerSingleAdapter<T, Q> newRecyclerSingleAdapter(Class viewClass, List listItems, BindableLayoutBuilder<T, Q> builder) {
        return new RecyclerSingleAdapter<T, Q>(viewClass, listItems, builder);
    }

    public static <T, Q extends BindableLayout<T>> AARecyclerSingleAdapter<T, Q> newAARecyclerSingleAdapter(Class viewClass, List listItems) {
        return new AARecyclerSingleAdapter<T, Q>(viewClass, listItems);
    }

    public static <T, Q extends BindableLayout<T>> AARecyclerSingleAdapter<T, Q> newAARecyclerSingleAdapter(Class viewClass, List listItems, BindableLayoutBuilder<T, Q> builder) {
        return new AARecyclerSingleAdapter<T, Q>(viewClass, listItems, builder);
    }

    // MultiAdapters

    public static MultiAdapter newMultiAdapter(Map<Class, Class<? extends BindableLayout>> itemViewMapping, List listItems) {
        return new MultiAdapter(itemViewMapping, listItems);
    }

    public static MultiAdapter newMultiAdapter(Mapper mapper, List listItems) {
        return new MultiAdapter(mapper, listItems);
    }

    public static MultiAdapter newMultiAdapter(Map<Class, Class<? extends BindableLayout>> itemViewMapping, List listItems, BindableLayoutBuilder builder) {
        return new MultiAdapter(itemViewMapping, listItems, builder);
    }

    public static MultiAdapter newMultiAdapter(Mapper mapper, List listItems, BindableLayoutBuilder builder) {
        return new MultiAdapter(mapper, listItems, builder);
    }

    public static AAMultiAdapter newAAMultiAdapter(Map<Class, Class<? extends BindableLayout>> itemViewMapping, List listItems) {
        return new AAMultiAdapter(itemViewMapping, listItems);
    }

    public static AAMultiAdapter newAAMultiAdapter(Mapper mapper, List listItems) {
        return new AAMultiAdapter(mapper, listItems);
    }

    public static AAMultiAdapter newAAMultiAdapter(Map<Class, Class<? extends BindableLayout>> itemViewMapping, List listItems, BindableLayoutBuilder builder) {
        return new AAMultiAdapter(itemViewMapping, listItems, builder);
    }

    public static AAMultiAdapter newAAMultiAdapter(Mapper mapper, List listItems, BindableLayoutBuilder builder) {
        return new AAMultiAdapter(mapper, listItems, builder);
    }

    // RecyclerMultiAdapters

    public static RecyclerMultiAdapter newRecyclerMultiAdapter(Map<Class, Class<? extends BindableLayout>> itemViewMapping, List listItems) {
        return new RecyclerMultiAdapter(itemViewMapping, listItems);
    }

    public static RecyclerMultiAdapter newRecyclerMultiAdapter(Mapper mapper, List listItems) {
        return new RecyclerMultiAdapter(mapper, listItems);
    }

    public static RecyclerMultiAdapter newRecyclerMultiAdapter(Map<Class, Class<? extends BindableLayout>> itemViewMapping, List listItems, BindableLayoutBuilder builder) {
        return new RecyclerMultiAdapter(itemViewMapping, listItems, builder);
    }

    public static RecyclerMultiAdapter newRecyclerMultiAdapter(Mapper mapper, List listItems, BindableLayoutBuilder builder) {
        return new RecyclerMultiAdapter(mapper, listItems, builder);
    }

    public static AARecyclerMultiAdapter newAARecyclerMultiAdapter(Map<Class, Class<? extends BindableLayout>> itemViewMapping, List listItems) {
        return new AARecyclerMultiAdapter(itemViewMapping, listItems);
    }

    public static AARecyclerMultiAdapter newAARecyclerMultiAdapter(Mapper mapper, List listItems) {
        return new AARecyclerMultiAdapter(mapper, listItems);
    }

    public static AARecyclerMultiAdapter newAARecyclerMultiAdapter(Map<Class, Class<? extends BindableLayout>> itemViewMapping, List listItems, BindableLayoutBuilder builder) {
        return new AARecyclerMultiAdapter(itemViewMapping, listItems, builder);
    }

    public static AARecyclerMultiAdapter newAARecyclerMultiAdapter(Mapper mapper, List listItems, BindableLayoutBuilder builder) {
        return new AARecyclerMultiAdapter(mapper, listItems, builder);
    }
}
