package io.nlopez.toolkit.sample;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;

import java.util.List;

import io.nlopez.toolkit.adapters.Adapters;
import io.nlopez.toolkit.adapters.Mapper;
import io.nlopez.toolkit.adapters.MultiAdapter;
import io.nlopez.toolkit.adapters.RecyclerMultiAdapter;
import io.nlopez.toolkit.adapters.RecyclerSingleAdapter;
import io.nlopez.toolkit.adapters.SingleAdapter;
import io.nlopez.toolkit.mvp.Presenter;
import io.nlopez.toolkit.mvp.ViewComponent;
import io.nlopez.toolkit.sample.model.ListItemsBusinessObject;
import io.nlopez.toolkit.sample.model.TextAndImageItem;
import io.nlopez.toolkit.sample.model.TextImageAndButtonItem;
import io.nlopez.toolkit.sample.views.TextAndImageItemView;
import io.nlopez.toolkit.sample.views.TextImageAndButtonItemView;
import io.nlopez.toolkit.utils.ViewEventListener;

/**
 * Created by Nacho Lopez on 28/10/13.
 */
public class MainActivity extends Activity implements ActionBar.OnNavigationListener, ViewEventListener, ViewComponent {

    private ListView listView;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ListItemsBusinessObject businessObject;
    private ExamplePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        businessObject = new ListItemsBusinessObject();
        presenter = new ExamplePresenter(this, businessObject);
        presenter.takeView(this);

        listView = (ListView) findViewById(R.id.list);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ActionBar bar = getActionBar();
        if (bar != null) {
            presenter.initNavigation(bar);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.dropView();
    }

    private void showSingleViewAdapter() {
        listView.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
        List<TextAndImageItem> items = businessObject.generateRandomTextImageItems();

        SingleAdapter<TextAndImageItem, TextAndImageItemView> adapter = Adapters.newSingleAdapter(
                TextAndImageItemView.class, items);

        adapter.setViewEventListener(this);

        listView.setAdapter(adapter);
    }

    private void showMultiViewAdapter() {
        listView.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);

        List items = businessObject.generateRandomItems();

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

        List<TextAndImageItem> items = businessObject.generateRandomTextImageItems();

        RecyclerSingleAdapter<TextAndImageItem, TextAndImageItemView> adapter = Adapters.newRecyclerSingleAdapter(
                TextAndImageItemView.class, items);

        adapter.setViewEventListener(this);

        recyclerView.setAdapter(adapter);
    }

    private void showRecyclerMultiViewAdapter() {
        listView.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);

        List items = businessObject.generateRandomItems();

        Mapper map = new Mapper()
                .add(TextAndImageItem.class, TextAndImageItemView.class)
                .add(TextImageAndButtonItem.class, TextImageAndButtonItemView.class);

        RecyclerMultiAdapter adapter = Adapters.newRecyclerMultiAdapter(map, items);
        adapter.setViewEventListener(this);
        recyclerView.setAdapter(adapter);
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
                presenter.textAndImageItemClicked();
                break;
            case TextImageAndButtonItemView.ITEM_CLICKED_ACTION_ID:
                presenter.textItemClicked();
                break;
            case TextImageAndButtonItemView.BUTTON_ITEM_CLICKED_ACTION_ID:
                presenter.textAndImageButtonClicked();
                break;
        }
    }

    @Override
    public void setPresenter(Presenter presenter) {
        // Not needed, as we are reusing the activity as viewcomponent and we already know about the presenter
    }
}