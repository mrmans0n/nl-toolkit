package io.nlopez.toolkit.mvp;

import java.lang.ref.WeakReference;

/**
 * Created by mrm on 5/4/15.
 */
public abstract class BasePresenter<M extends ModelBusinessObject, V extends ViewComponent> implements Presenter<V> {

    private WeakReference<V> weakView;
    private M model;

    protected BasePresenter(M model) {
        this.model = model;
    }

    @Override
    public void takeView(V view) {
        weakView = new WeakReference<>(view);
        view.setPresenter(this);
    }

    protected boolean isTaken() {
        return weakView != null && weakView.get() != null;
    }

    protected V view() {
        return weakView.get();
    }

    protected M model() {
        return model;
    }

    @Override
    public void dropView() {
        if (isTaken()) {
            weakView.clear();
            weakView = null;
        }
    }
}
