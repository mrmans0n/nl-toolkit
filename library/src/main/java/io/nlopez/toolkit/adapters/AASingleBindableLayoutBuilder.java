package io.nlopez.toolkit.adapters;

import android.content.Context;

import java.lang.reflect.Method;

import io.nlopez.toolkit.utils.BindableLayoutBuilder;
import io.nlopez.toolkit.views.BindableLayout;

/**
 * Created by mrm on 18/05/14.
 */
public class AASingleBindableLayoutBuilder<T, Q extends BindableLayout<T>> implements BindableLayoutBuilder<T, Q> {

    protected Class viewClass;

    public AASingleBindableLayoutBuilder(Class viewClass) {
        this.viewClass = viewClass;
    }

    @Override
    public Q build(Context context, Class aClass, T item) {
        try {
            Method method = viewClass.getMethod("build", Context.class);
            return (Q) method.invoke(null, context);
        } catch (Exception e) {
            throw new RuntimeException("Something went wrong creating the views", e);
        }
    }
}
