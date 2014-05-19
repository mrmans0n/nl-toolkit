package io.nlopez.toolkit.adapters;

import java.util.HashMap;
import java.util.Map;

import io.nlopez.toolkit.views.BindableLayout;

/**
 * Created by mrm on 19/05/14.
 */
public class Mapper {

    private Map<Class, Class<? extends BindableLayout>> mapping;

    public Mapper() {
        mapping = new HashMap<Class, Class<? extends BindableLayout>>();
    }

    /**
     * Associates an object with its representing view, to be used with {@link io.nlopez.toolkit.adapters.MultiAdapter}
     * @param objectClass
     * @param viewClass
     * @return this, so you can chain calls
     */
    public Mapper add(Class objectClass, Class<? extends BindableLayout> viewClass) {
        mapping.put(objectClass, viewClass);
        return this;
    }

    /**
     * Returns the object to view mapping as a Map object
     * @return
     */
    public Map<Class, Class<? extends BindableLayout>> asMap() {
        return mapping;
    }
}
