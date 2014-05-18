package io.nlopez.toolkit.sample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.nlopez.toolkit.adapters.SingleViewTypeAdapter;
import io.nlopez.toolkit.sample.model.TextAndImageItem;
import io.nlopez.toolkit.sample.views.TextAndImageItemView;
import io.nlopez.toolkit.utils.ViewEventListener;

/**
 * Created by Nacho Lopez on 28/10/13.
 */
public class MainActivity extends Activity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list);

        initAdapter();
    }

    private void initAdapter() {
        List<TextAndImageItem> items = new ArrayList<TextAndImageItem>();
        for (int i = 1; i < 50; i++) {
            items.add(new TextAndImageItem("Item #" + i, R.drawable.ic_launcher));
        }

        SingleViewTypeAdapter<TextAndImageItem, TextAndImageItemView> adapter = new SingleViewTypeAdapter<TextAndImageItem, TextAndImageItemView>(TextAndImageItemView.class, items);
        adapter.setViewEventListener(new ViewEventListener<TextAndImageItem>() {
            @Override
            public void onViewEvent(int actionId, TextAndImageItem item, View view) {
                Toast.makeText(MainActivity.this, item.getText(), Toast.LENGTH_LONG).show();
            }
        });

        listView.setAdapter(adapter);
    }

}