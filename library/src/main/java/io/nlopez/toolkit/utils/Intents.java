package io.nlopez.toolkit.utils;

import android.content.Intent;
import android.net.Uri;

/**
 * Created by mrm on 05/06/14.
 */
public class Intents {

    private Intents() {
    }

    public static Intent newShareTextIntent(String text, String chooserText) {
        return Intent.createChooser(newShareTextIntent(text), chooserText);
    }

    private static Intent newShareTextIntent(String text) {
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT, text);
        shareIntent.setType("text/*");
        return shareIntent;
    }

    private static Intent newShareBinaryIntent(Uri uri, String mimeType, String chooserText) {
        return Intent.createChooser(newShareBinaryIntent(uri, mimeType), chooserText);
    }

    private static Intent newShareBinaryIntent(Uri uri, String mimeType) {
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
        shareIntent.setType(mimeType);
        return shareIntent;
    }

    private static Intent newOpenUrlIntent(String url) {
        Intent urlIntent = new Intent();
        urlIntent.setAction(Intent.ACTION_VIEW);
        urlIntent.setData(Uri.parse(url));
        return urlIntent;
    }

}
