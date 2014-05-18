package io.nlopez.toolkit.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.lang.reflect.Constructor;
import java.util.List;

import io.nlopez.toolkit.utils.BindableLayoutBuilder;
import io.nlopez.toolkit.utils.ThreadHelper;
import io.nlopez.toolkit.utils.ViewEventListener;
import io.nlopez.toolkit.views.BindableLayout;

/**
 * Created by mrm on 18/05/14.
 */
public class SingleViewTypeAdapter<T, Q extends BindableLayout<T>> extends BaseAdapter {

    protected Class viewClass;
    protected List<T> listItems;
    protected ViewEventListener<T> viewEventListener;
    protected BindableLayoutBuilder<T, Q> builder;

    public SingleViewTypeAdapter(Class<Q> viewClass, List<T> listItems) {
        this(viewClass, listItems, SingleViewTypeAdapter.<T, Q>createDefaultBuilder(viewClass));
    }

    public SingleViewTypeAdapter(Class<Q> viewClass, List<T> listItems, BindableLayoutBuilder<T, Q> builder) {
        this.listItems = listItems;
        this.viewClass = viewClass;
        this.builder = builder;
    }

    public void setItems(List<T> items) {
        ThreadHelper.crashIfBackgroundThread();
        listItems = items;
        notifyDataSetChanged();
    }

    public void addItem(T item) {
        ThreadHelper.crashIfBackgroundThread();
        listItems.add(item);
        notifyDataSetChanged();
    }

    public void delItem(T item) {
        ThreadHelper.crashIfBackgroundThread();
        listItems.remove(item);
        notifyDataSetChanged();
    }

    public void addItems(List<T> items) {
        ThreadHelper.crashIfBackgroundThread();
        listItems.addAll(items);
        notifyDataSetChanged();
    }

    public void clearItems() {
        ThreadHelper.crashIfBackgroundThread();
        listItems.clear();
        notifyDataSetChanged();
    }

    public ViewEventListener<T> getViewEventListener() {
        return viewEventListener;
    }

    public void setViewEventListener(ViewEventListener<T> viewEventListener) {
        this.viewEventListener = viewEventListener;
    }

    public void notifyAction(int actionId, T object, View view) {
        if (viewEventListener != null) {
            viewEventListener.onViewEvent(actionId, object, view);
        }
    }

    @Override
    public int getCount() {
        return listItems == null ? 0 : listItems.size();
    }

    @Override
    public T getItem(int position) {
        return listItems == null ? null : listItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BindableLayout<T> viewGroup = (BindableLayout<T>) convertView;
        if (viewGroup == null) {
            viewGroup = builder.build(parent.getContext(), getItem(position));
        }

        if (viewGroup != null) {
            viewGroup.setViewEventListener(viewEventListener);
            viewGroup.bind(getItem(position), position);
        }
        return viewGroup;
    }

    private static <T, Q extends BindableLayout<T>> BindableLayoutBuilder<T, Q> createDefaultBuilder(final Class viewClass) {
        return new BindableLayoutBuilder<T, Q>() {
            @Override
            public Q build(Context context, T item) {
                try {
                    Constructor constructor = viewClass.getConstructor(Context.class);
                    return (Q) constructor.newInstance(context);
                } catch (Exception e) {
                    throw new RuntimeException("Something went wrong creating the views", e);
                }
            }
        };
    }
}
