package io.nlopez.toolkit.utils;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;

import io.nlopez.toolkit.R;

/**
 * Created by mrm on 03/05/14.
 */
public class ActivityTransitions {

    private ActivityTransitions() {
    }

    public static void start(Activity from, Class clazz) {
        start(from, new Intent(from, clazz));
    }

    public static void start(Activity from, Class clazz, int oldViewAnimId, int newViewAnimId) {
        start(from, new Intent(from, clazz), oldViewAnimId, newViewAnimId);
    }

    public static void start(Activity from, Intent intent) {
        start(from, intent, R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public static void start(Activity from, Intent intent, int oldViewAnimId, int newViewAnimId) {
        Bundle options = ActivityOptionsCompat.makeCustomAnimation(from, oldViewAnimId, newViewAnimId).toBundle();
        ActivityCompat.startActivity(from, intent, options);
    }

    public static void start(Fragment from, Class clazz) {
        start(from, new Intent(from.getActivity(), clazz));
    }

    public static void start(Fragment from, Class clazz, int oldViewAnimId, int newViewAnimId) {
        start(from, new Intent(from.getActivity(), clazz), oldViewAnimId, newViewAnimId);
    }

    public static void start(Fragment from, Intent intent) {
        start(from, intent, R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public static void start(Fragment from, Intent intent, int oldViewAnimId, int newViewAnimId) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            Bundle options = ActivityOptionsCompat.makeCustomAnimation(from.getActivity(), oldViewAnimId, newViewAnimId).toBundle();
            from.startActivity(intent, options);
        } else {
            from.startActivity(intent);
        }
    }

    public static void startForResult(Activity from, Class clazz, int requestCode) {
        startForResult(from, new Intent(from, clazz), requestCode);
    }

    public static void startForResult(Activity from, Class clazz, int oldViewAnimId, int newViewAnimId, int requestCode) {
        startForResult(from, new Intent(from, clazz), oldViewAnimId, newViewAnimId, requestCode);
    }

    public static void startForResult(Activity from, Intent intent, int requestCode) {
        startForResult(from, intent, R.anim.slide_in_left, R.anim.slide_out_left, requestCode);
    }

    public static void startForResult(Activity from, Intent intent, int oldViewAnimId, int newViewAnimId, int requestCode) {
        Bundle options = ActivityOptionsCompat.makeCustomAnimation(from, oldViewAnimId, newViewAnimId).toBundle();
        ActivityCompat.startActivityForResult(from, intent, requestCode, options);
    }


    public static void startForResult(Fragment from, Class clazz, int requestCode) {
        startForResult(from, new Intent(from.getActivity(), clazz), requestCode);
    }

    public static void startForResult(Fragment from, Class clazz, int oldViewAnimId, int newViewAnimId, int requestCode) {
        startForResult(from, new Intent(from.getActivity(), clazz), oldViewAnimId, newViewAnimId, requestCode);
    }

    public static void startForResult(Fragment from, Intent intent, int requestCode) {
        startForResult(from, intent, R.anim.slide_in_left, R.anim.slide_out_left, requestCode);
    }

    public static void startForResult(Fragment from, Intent intent, int oldViewAnimId, int newViewAnimId, int requestCode) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            Bundle options = ActivityOptionsCompat.makeCustomAnimation(from.getActivity(), oldViewAnimId, newViewAnimId).toBundle();
            from.startActivityForResult(intent, requestCode, options);
        } else {
            from.startActivityForResult(intent, requestCode);
        }
    }

    public static void finish(Activity from) {
        finish(from, R.anim.slide_in_right, R.anim.slide_out_right);
    }

    public static void finish(Activity from, int oldViewAnimId, int newViewAnimId) {
        from.overridePendingTransition(oldViewAnimId, newViewAnimId);
    }


}
