package io.nlopez.toolkit.sample.model;

import java.util.ArrayList;
import java.util.List;

import io.nlopez.toolkit.mvp.ModelBusinessObject;
import io.nlopez.toolkit.sample.R;

/**
 * Created by mrm on 5/4/15.
 */
public class ListItemsBusinessObject implements ModelBusinessObject {
    public List<TextAndImageItem> generateRandomTextImageItems() {
        List<TextAndImageItem> items = new ArrayList<TextAndImageItem>();
        for (int i = 1; i < 50; i++) {
            items.add(new TextAndImageItem("Item #" + i, R.drawable.ic_launcher));
        }
        return items;
    }

    public List generateRandomItems() {
        List items = new ArrayList();
        for (int i = 1; i < 50; i++) {
            if (i % 2 == 0) {
                items.add(new TextAndImageItem("Item #" + i, R.drawable.ic_launcher));
            } else {
                items.add(new TextImageAndButtonItem("Item #" + i, "Button #" + i, R.drawable.ic_launcher));
            }
        }
        return items;
    }
}
