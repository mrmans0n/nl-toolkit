package io.nlopez.toolkit.sample;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.nlopez.toolkit.adapters.Adapters;
import io.nlopez.toolkit.adapters.MultiAdapter;
import io.nlopez.toolkit.adapters.SingleAdapter;
import io.nlopez.toolkit.sample.model.TextAndImageItem;
import io.nlopez.toolkit.sample.model.TextImageAndButtonItem;
import io.nlopez.toolkit.sample.views.TextAndImageItemView;
import io.nlopez.toolkit.sample.views.TextImageAndButtonItemView;
import io.nlopez.toolkit.utils.ViewEventListener;
import io.nlopez.toolkit.views.BindableLayout;

/**
 * Created by Nacho Lopez on 28/10/13.
 */
public class MainActivity extends Activity implements ActionBar.OnNavigationListener, ViewEventListener {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list);

        initNavigationList();
    }

    private void initNavigationList() {
        ActionBar bar = getActionBar();
        bar.setDisplayShowTitleEnabled(false);
        bar.setDisplayUseLogoEnabled(false);
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        String[] dropdownValues = getResources().getStringArray(R.array.navigation_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(bar.getThemedContext(),
                android.R.layout.simple_spinner_item, android.R.id.text1,
                dropdownValues);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        bar.setListNavigationCallbacks(adapter, this);
    }

    private void showSingleViewAdapter() {
        List<TextAndImageItem> items = new ArrayList<TextAndImageItem>();
        for (int i = 1; i < 50; i++) {
            items.add(new TextAndImageItem("Item #" + i, R.drawable.ic_launcher));
        }

        SingleAdapter<TextAndImageItem, TextAndImageItemView> adapter = Adapters.newSingleAdapter(TextAndImageItemView.class, items);

        adapter.setViewEventListener(this);

        listView.setAdapter(adapter);
    }

    private void showMultiViewAdapter() {
        List items = new ArrayList();
        for (int i = 1; i < 50; i++) {
            if (i % 2 == 0) {
                items.add(new TextAndImageItem("Item #" + i, R.drawable.ic_launcher));
            } else {
                items.add(new TextImageAndButtonItem("Item #" + i, "Button #" + i, R.drawable.ic_launcher));
            }
        }

        Map<Class, Class<? extends BindableLayout>> mapping = new HashMap<Class, Class<? extends BindableLayout>>();
        mapping.put(TextAndImageItem.class, TextAndImageItemView.class);
        mapping.put(TextImageAndButtonItem.class, TextImageAndButtonItemView.class);

        MultiAdapter adapter = Adapters.newMultiAdapter(mapping, items);
        adapter.setViewEventListener(this);

        listView.setAdapter(adapter);
    }

    @Override
    public boolean onNavigationItemSelected(int itemPosition, long itemId) {
        switch (itemPosition) {
            case 0:
                showSingleViewAdapter();
                break;
            case 1:
                showMultiViewAdapter();
                break;
        }
        return true;
    }

    @Override
    public void onViewEvent(int actionId, Object item, View view) {
        switch (actionId) {
            case TextAndImageItemView.ITEM_CLICKED_ACTION_ID:
                Toast.makeText(this, "SINGLE TYPE ROW CLICKED", Toast.LENGTH_SHORT).show();
                break;
            case TextImageAndButtonItemView.ITEM_CLICKED_ACTION_ID:
                Toast.makeText(this, "MULTI TYPE ROW CLICKED", Toast.LENGTH_SHORT).show();
                break;
            case TextImageAndButtonItemView.BUTTON_ITEM_CLICKED_ACTION_ID:
                Toast.makeText(this, "MULTI TYPE BUTTON CLICKED", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}