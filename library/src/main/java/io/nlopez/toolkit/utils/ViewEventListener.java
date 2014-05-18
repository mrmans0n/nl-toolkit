package io.nlopez.toolkit.utils;

import android.view.View;

/**
 * Created by mrm on 18/05/14.
 */
public interface ViewEventListener<T> {
    public void onViewEvent(int actionId, T item, View view);
}
