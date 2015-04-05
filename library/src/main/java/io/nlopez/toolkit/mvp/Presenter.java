package io.nlopez.toolkit.mvp;

/**
 * Created by mrm on 5/4/15.
 */
public interface Presenter<V extends ViewComponent> {
    void takeView(V view);

    void dropView();
}
