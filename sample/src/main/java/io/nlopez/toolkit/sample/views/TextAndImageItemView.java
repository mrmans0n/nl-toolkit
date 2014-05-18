package io.nlopez.toolkit.sample.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import io.nlopez.toolkit.sample.R;
import io.nlopez.toolkit.sample.model.TextAndImageItem;
import io.nlopez.toolkit.views.BindableLayout;

/**
 * Created by mrm on 18/05/14.
 */
public class TextAndImageItemView extends BindableLayout<TextAndImageItem> {

    public static final int ITEM_CLICKED_ACTION_ID = 1000;
    private TextView textView;

    public TextAndImageItemView(Context context) {
        super(context);
        initView();
    }

    public TextAndImageItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public TextAndImageItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();
    }

    private void initView() {
        View.inflate(getContext(), R.layout.view_text, this);

        textView = (TextView) findViewById(R.id.text);
    }

    @Override
    public void bind(TextAndImageItem item) {
        textView.setText(item.getText());
        textView.setCompoundDrawablesWithIntrinsicBounds(item.getImageId(), 0, 0, 0);

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                notifyItemAction(ITEM_CLICKED_ACTION_ID, v);
            }
        });
    }
}
