package io.nlopez.toolkit.utils;

import android.content.Context;

import io.nlopez.toolkit.views.BindableLayout;

/**
 * Created by mrm on 18/05/14.
 */
public interface BindableLayoutBuilder<T, Q extends BindableLayout<T>> {
    Q build(Context context, T item, int position);
}
