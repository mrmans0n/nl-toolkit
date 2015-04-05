package io.nlopez.toolkit.sample;

import android.app.ActionBar;
import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import io.nlopez.toolkit.mvp.BasePresenter;
import io.nlopez.toolkit.sample.model.ListItemsBusinessObject;

/**
 * Created by mrm on 5/4/15.
 */
public class ExamplePresenter extends BasePresenter<ListItemsBusinessObject, MainActivity> {

    private Context context;

    protected ExamplePresenter(Context context, ListItemsBusinessObject model) {
        super(model);
        this.context = context;
    }

    public void initNavigation(@NonNull ActionBar bar) {
        bar.setDisplayShowTitleEnabled(false);
        bar.setDisplayUseLogoEnabled(false);
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        String[] dropdownValues = bar.getThemedContext().getResources().getStringArray(R.array.navigation_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(bar.getThemedContext(),
                android.R.layout.simple_spinner_item,
                android.R.id.text1,
                dropdownValues);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        bar.setListNavigationCallbacks(adapter, view());
    }

    public void textItemClicked() {
        Toast.makeText(context, "MULTI TYPE ROW CLICKED", Toast.LENGTH_SHORT).show();
    }

    public void textAndImageItemClicked() {
        Toast.makeText(context, "SINGLE TYPE ROW CLICKED", Toast.LENGTH_SHORT).show();
    }

    public void textAndImageButtonClicked() {
        Toast.makeText(context, "MULTI TYPE BUTTON CLICKED", Toast.LENGTH_SHORT).show();
    }
}
