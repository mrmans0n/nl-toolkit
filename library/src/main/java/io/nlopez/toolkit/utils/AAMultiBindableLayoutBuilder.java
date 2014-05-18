package io.nlopez.toolkit.utils;

import android.content.Context;

import java.lang.reflect.Method;
import java.util.Map;

import io.nlopez.toolkit.views.BindableLayout;

/**
 * Created by mrm on 18/05/14.
 */
public class AAMultiBindableLayoutBuilder implements BindableLayoutBuilder {

    private Map<Class, Class<? extends BindableLayout>> itemViewMapping;

    public AAMultiBindableLayoutBuilder(Map<Class, Class<? extends BindableLayout>> itemViewMapping) {
        this.itemViewMapping = itemViewMapping;
    }

    @Override
    public BindableLayout build(Context context, Object item) {
        try {
            Class viewClass = itemViewMapping.get(item.getClass());
            Method method = viewClass.getMethod("build", Context.class);
            return (BindableLayout) method.invoke(null, context);
        } catch (Exception e) {
            throw new RuntimeException("Something went wrong creating the views", e);
        }
    }
}
