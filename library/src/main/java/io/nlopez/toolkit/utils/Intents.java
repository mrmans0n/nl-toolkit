package io.nlopez.toolkit.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;

/**
 * Created by mrm on 05/06/14.
 */
public class Intents {

    private Intents() {
    }

    /**
     * Share text intent
     *
     * @param context
     * @param text
     * @return the desired intent, or null if the system cannot handle it
     */
    public static Intent newShareTextIntent(Context context, String text) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT, text);
        shareIntent.setType("text/*");
        if (shareIntent.resolveActivity(context.getPackageManager()) != null) {
            return shareIntent;
        }
        return null;
    }

    /**
     * Share binary file based on mimetype
     *
     * @param context
     * @param uri
     * @param mimeType
     * @return the desired intent, or null if the system cannot handle it
     */
    public static Intent newShareBinaryIntent(Context context, Uri uri, String mimeType) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
        shareIntent.setType(mimeType);
        if (shareIntent.resolveActivity(context.getPackageManager()) != null) {
            return shareIntent;
        }
        return null;
    }

    /**
     * Open URL in the default browser
     *
     * @param context
     * @param url
     * @return the desired intent, or null if the system cannot handle it
     */
    public static Intent newOpenUrlIntent(Context context, String url) {
        Intent urlIntent = new Intent(Intent.ACTION_VIEW);
        urlIntent.setData(Uri.parse(url));
        if (urlIntent.resolveActivity(context.getPackageManager()) != null) {
            return urlIntent;
        }
        return null;
    }

    /**
     * Send email to various destinations using the default email app
     *
     * @param context
     * @param emails
     * @param subject
     * @param text
     * @return the desired intent, or null if the system cannot handle it
     */
    public static Intent newSendEmailsIntent(Context context, String[] emails, String subject, String text) {
        Intent mailIntent = new Intent(Intent.ACTION_SENDTO);
        mailIntent.setType("message/rfc822");
        mailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        mailIntent.putExtra(Intent.EXTRA_EMAIL, emails);
        mailIntent.putExtra(Intent.EXTRA_TEXT, text);
        if (mailIntent.resolveActivity(context.getPackageManager()) != null) {
            return mailIntent;
        }
        return null;
    }

    /**
     * Send email to one destination using the default email app
     *
     * @param context
     * @param email
     * @param subject
     * @param text
     * @return the desired intent, or null if the system cannot handle it
     */
    public static Intent newSendEmailIntent(Context context, String email, String subject, String text) {
        return newSendEmailsIntent(context, new String[]{email}, subject, text);
    }

    /**
     * Launch the dialer with an already dialed phone (less intrusive than calling directly)
     *
     * @param context
     * @param phone
     * @return the desired intent, or null if the system cannot handle it
     */
    public static Intent newDialerIntent(Context context, String phone) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phone));
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            return intent;
        }
        return null;
    }

    /**
     * Open the navigator to a destination
     *
     * @param context
     * @param latitude
     * @param longitude
     * @param name
     * @return the desired intent, or null if the system cannot handle it
     */
    public static Intent newNavigatorIntent(Context context, double latitude, double longitude, String name) {
        String format = "geo:0,0?q=" + Double.toString(latitude) + "," + Double.toString(longitude) + "(" + name + ")";
        Uri uri = Uri.parse(format);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            return intent;
        }
        return null;
    }

    /**
     * Take a picture with the camera and return it as a thumbnail
     *
     * @param context
     * @return the desired intent, or null if the system cannot handle it
     */
    public static Intent newTakePictureIntent(Context context) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(context.getPackageManager()) != null) {
            return takePictureIntent;
        }
        return null;
    }

    /**
     * Take a picture and store it in its original form in the given Uri
     *
     * @param context
     * @param destinationImageUri
     * @return the desired intent, or null if the system cannot handle it
     */
    public static Intent newTakePictureIntent(Context context, Uri destinationImageUri) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(context.getPackageManager()) != null) {
            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, destinationImageUri);
            return takePictureIntent;
        }
        return null;
    }

}
