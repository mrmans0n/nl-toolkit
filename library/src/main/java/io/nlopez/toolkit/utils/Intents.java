package io.nlopez.toolkit.utils;

import android.content.Intent;
import android.net.Uri;

/**
 * Created by mrm on 05/06/14.
 */
public class Intents {

    private Intents() {
    }

    public static Intent newShareTextIntent(String text) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT, text);
        shareIntent.setType("text/*");
        return shareIntent;
    }

    public static Intent newShareBinaryIntent(Uri uri, String mimeType) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
        shareIntent.setType(mimeType);
        return shareIntent;
    }

    public static Intent newOpenUrlIntent(String url) {
        Intent urlIntent = new Intent(Intent.ACTION_VIEW);
        urlIntent.setData(Uri.parse(url));
        return urlIntent;
    }

    public static Intent newSendEmailsIntent(String[] emails, String subject, String text) {
        Intent mailIntent = new Intent(Intent.ACTION_SENDTO);
        mailIntent.setType("message/rfc822");
        mailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        mailIntent.putExtra(Intent.EXTRA_EMAIL, emails);
        mailIntent.putExtra(Intent.EXTRA_TEXT, text);
        return mailIntent;
    }

    public static Intent newSendEmailIntent(String email, String subject, String text) {
        return newSendEmailsIntent(new String[]{email}, subject, text);
    }

}
