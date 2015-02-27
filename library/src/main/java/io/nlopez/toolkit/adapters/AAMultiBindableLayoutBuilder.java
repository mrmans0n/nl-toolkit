package io.nlopez.toolkit.adapters;

import android.content.Context;
import io.nlopez.toolkit.utils.BindableLayoutBuilder;
import io.nlopez.toolkit.views.BindableLayout;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by mrm on 18/05/14.
 */
public class AAMultiBindableLayoutBuilder implements BindableLayoutBuilder {

    protected Map<Class, Class<? extends BindableLayout>> itemViewMapping;

    public AAMultiBindableLayoutBuilder(Map<Class, Class<? extends BindableLayout>> itemViewMapping) {
        this.itemViewMapping = itemViewMapping;
    }

    @Override
    public BindableLayout build(Context context, Class aClass, Object item) {
        try {
            Class modelClass = (item == null) ? aClass : item.getClass();
            Class viewClass = itemViewMapping.get(modelClass);
            Method method = viewClass.getMethod("build", Context.class);
            return (BindableLayout) method.invoke(null, context);
        } catch (Exception e) {
            throw new RuntimeException("Something went wrong creating the views", e);
        }
    }
}
