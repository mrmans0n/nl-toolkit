package io.nlopez.toolkit.sample;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.nlopez.toolkit.adapters.Adapters;
import io.nlopez.toolkit.adapters.Mapper;
import io.nlopez.toolkit.adapters.MultiAdapter;
import io.nlopez.toolkit.adapters.RecyclerMultiAdapter;
import io.nlopez.toolkit.adapters.RecyclerSingleAdapter;
import io.nlopez.toolkit.adapters.SingleAdapter;
import io.nlopez.toolkit.sample.model.TextAndImageItem;
import io.nlopez.toolkit.sample.model.TextImageAndButtonItem;
import io.nlopez.toolkit.sample.views.TextAndImageItemView;
import io.nlopez.toolkit.sample.views.TextImageAndButtonItemView;
import io.nlopez.toolkit.utils.ViewEventListener;

/**
 * Created by Nacho Lopez on 28/10/13.
 */
public class MainActivity extends Activity implements ActionBar.OnNavigationListener, ViewEventListener {

    private ListView listView;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        initNavigationList();
    }

    private void initNavigationList() {
        ActionBar bar = getActionBar();
        bar.setDisplayShowTitleEnabled(false);
        bar.setDisplayUseLogoEnabled(false);
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        String[] dropdownValues = getResources().getStringArray(R.array.navigation_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(bar.getThemedContext(),
                android.R.layout.simple_spinner_item,
                android.R.id.text1,
                dropdownValues);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        bar.setListNavigationCallbacks(adapter, this);
    }

    private void showSingleViewAdapter() {
        listView.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
        List<TextAndImageItem> items = generateRandomTextImageItems();

        SingleAdapter<TextAndImageItem, TextAndImageItemView> adapter = Adapters.newSingleAdapter(
                TextAndImageItemView.class, items);

        adapter.setViewEventListener(this);

        listView.setAdapter(adapter);
    }

    private void showMultiViewAdapter() {
        listView.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);

        List items = generateRandomItems();

        Mapper map = new Mapper()
                .add(TextAndImageItem.class, TextAndImageItemView.class)
                .add(TextImageAndButtonItem.class, TextImageAndButtonItemView.class);

        MultiAdapter adapter = Adapters.newMultiAdapter(map, items);
        adapter.setViewEventListener(this);

        listView.setAdapter(adapter);
    }

    private void showRecyclerSingleViewAdapter() {
        listView.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);

        List<TextAndImageItem> items = generateRandomTextImageItems();

        RecyclerSingleAdapter<TextAndImageItem, TextAndImageItemView> adapter = Adapters.newRecyclerSingleAdapter(
                TextAndImageItemView.class, items);

        adapter.setViewEventListener(this);

        recyclerView.setAdapter(adapter);
    }

    private void showRecyclerMultiViewAdapter() {
        listView.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);

        List items = generateRandomItems();

        Mapper map = new Mapper()
                .add(TextAndImageItem.class, TextAndImageItemView.class)
                .add(TextImageAndButtonItem.class, TextImageAndButtonItemView.class);

        RecyclerMultiAdapter adapter = Adapters.newRecyclerMultiAdapter(map, items);
        adapter.setViewEventListener(this);
        recyclerView.setAdapter(adapter);
    }

    private List<TextAndImageItem> generateRandomTextImageItems() {
        List<TextAndImageItem> items = new ArrayList<TextAndImageItem>();
        for (int i = 1; i < 50; i++) {
            items.add(new TextAndImageItem("Item #" + i, R.drawable.ic_launcher));
        }
        return items;
    }

    private List generateRandomItems() {
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

    @Override
    public boolean onNavigationItemSelected(int itemPosition, long itemId) {
        switch (itemPosition) {
            case 0:
                showSingleViewAdapter();
                break;
            case 1:
                showMultiViewAdapter();
                break;
            case 2:
                showRecyclerSingleViewAdapter();
                break;
            case 3:
                showRecyclerMultiViewAdapter();
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