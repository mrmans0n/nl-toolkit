package io.nlopez.toolkit.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import io.nlopez.toolkit.utils.BindableLayoutBuilder;
import io.nlopez.toolkit.utils.ThreadHelper;
import io.nlopez.toolkit.utils.ViewEventListener;
import io.nlopez.toolkit.views.BindableLayout;
import io.nlopez.toolkit.views.BindableViewHolder;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by mrm on 27/02/15.
 */
public class RecyclerMultiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    protected Map<Class, Class<? extends BindableLayout>> itemViewMapping;
    protected List<Class> itemClassArray;
    protected List listItems;
    protected ViewEventListener viewEventListener;
    protected BindableLayoutBuilder builder;

    public RecyclerMultiAdapter(Map<Class, Class<? extends BindableLayout>> itemViewMapping, List listItems) {
        this(itemViewMapping, listItems, createDefaultBuilder(itemViewMapping));
    }

    public RecyclerMultiAdapter(Mapper mapper, List listItems) {
        this(mapper.asMap(), listItems);
    }

    public RecyclerMultiAdapter(Map<Class, Class<? extends BindableLayout>> itemViewMapping, List listItems,
                                BindableLayoutBuilder builder) {
        this.listItems = listItems;
        this.itemViewMapping = itemViewMapping;
        this.builder = builder;
        this.itemClassArray = new ArrayList<Class>(itemViewMapping.keySet());
    }

    public RecyclerMultiAdapter(Mapper mapper, List listItems, BindableLayoutBuilder builder) {
        this(mapper.asMap(), listItems, builder);
    }

    public void setItems(List items) {
        ThreadHelper.crashIfBackgroundThread();
        listItems = items;
        notifyDataSetChanged();
    }

    public void addItem(Object item) {
        ThreadHelper.crashIfBackgroundThread();
        listItems.add(item);
        notifyDataSetChanged();
    }

    public void delItem(Object item) {
        ThreadHelper.crashIfBackgroundThread();
        listItems.remove(item);
        notifyDataSetChanged();
    }

    public void addItems(List items) {
        ThreadHelper.crashIfBackgroundThread();
        listItems.addAll(items);
        notifyDataSetChanged();
    }

    public void clearItems() {
        ThreadHelper.crashIfBackgroundThread();
        listItems.clear();
        notifyDataSetChanged();
    }

    public ViewEventListener getViewEventListener() {
        return viewEventListener;
    }

    public void setViewEventListener(ViewEventListener viewEventListener) {
        this.viewEventListener = viewEventListener;
    }

    public void notifyAction(int actionId, Object object, View view) {
        if (viewEventListener != null) {
            viewEventListener.onViewEvent(actionId, object, view);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BindableLayout viewGroup = builder.build(parent.getContext(), itemClassArray.get(viewType), null);
        return new BindableViewHolder(viewGroup);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        BindableViewHolder bindableViewHolder = (BindableViewHolder) holder;
        bindableViewHolder.setViewEventListener(viewEventListener);
        Object item = listItems.get(position);
        if (item != null) {
            bindableViewHolder.bind(item, position);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (listItems == null) {
            return 0;
        }
        Object object = listItems.get(position);
        int itemClassIndex = itemClassArray.indexOf(object.getClass());
        if (itemClassIndex == -1) {
            throw new RuntimeException("Object "+object.getClass().getCanonicalName()+" doesn't have an associated mapping");
        }
        return itemClassIndex;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return listItems == null ? 0 : listItems.size();
    }

    private static BindableLayoutBuilder createDefaultBuilder(
            final Map<Class, Class<? extends BindableLayout>> itemViewMapping) {
        return new BindableLayoutBuilder() {
            @Override
            public BindableLayout build(Context context, Class aClass, Object item) {
                try {
                    Class modelClass = (item == null) ? aClass : item.getClass();
                    Class viewClass = itemViewMapping.get(modelClass);
                    Constructor constructor = viewClass.getConstructor(Context.class);
                    return (BindableLayout) constructor.newInstance(context);
                } catch (Exception e) {
                    throw new RuntimeException("Something went wrong creating the views", e);
                }
            }
        };
    }
}
