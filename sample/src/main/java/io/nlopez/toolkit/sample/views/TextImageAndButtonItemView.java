package io.nlopez.toolkit.sample.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import io.nlopez.toolkit.sample.R;
import io.nlopez.toolkit.sample.model.TextImageAndButtonItem;
import io.nlopez.toolkit.views.BindableLayout;

/**
 * Created by mrm on 18/05/14.
 */
public class TextImageAndButtonItemView extends BindableLayout<TextImageAndButtonItem> {

    public static final int ITEM_CLICKED_ACTION_ID = 2000;
    public static final int BUTTON_ITEM_CLICKED_ACTION_ID = 2001;
    private TextView textView;
    private Button buttonView;

    public TextImageAndButtonItemView(Context context) {
        super(context);
        initView();
    }

    public TextImageAndButtonItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public TextImageAndButtonItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();
    }

    private void initView() {
        View.inflate(getContext(), R.layout.view_text_button, this);

        textView = (TextView) findViewById(R.id.text);
        buttonView = (Button) findViewById(R.id.button);
    }

    @Override
    public void bind(TextImageAndButtonItem item) {
        textView.setText(item.getText());
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, item.getImageId(), 0);
        buttonView.setText(item.getButtonText());

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                notifyItemAction(ITEM_CLICKED_ACTION_ID, v);
            }
        });

        buttonView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                notifyItemAction(BUTTON_ITEM_CLICKED_ACTION_ID, v);
            }
        });
    }
}
