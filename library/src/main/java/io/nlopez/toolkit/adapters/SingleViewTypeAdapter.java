package io.nlopez.toolkit.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

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

    public SingleViewTypeAdapter(Class<Q> viewClass, List<T> listItems) {
        this.listItems = listItems;
        this.viewClass = viewClass;
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
            try {
                Constructor constructor = viewClass.getConstructor(Context.class);
                viewGroup = (BindableLayout<T>) constructor.newInstance(parent.getContext());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

        if (viewGroup != null) {
            viewGroup.setViewEventListener(viewEventListener);
            viewGroup.bind(getItem(position), position);
        }
        return viewGroup;
    }
}
