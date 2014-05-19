package io.nlopez.toolkit.utils;

import android.os.Looper;

import io.nlopez.toolkit.BuildConfig;

/**
 * Created by mrm on 18/05/14.
 */
public class ThreadHelper {

    /**
     * Provoke an exception if we are in the main thread
     */
    public static void crashIfMainThread() {
        if (BuildConfig.DEBUG) {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                throw new IllegalStateException("This method should be called from the Main Thread");
            }
        }
    }

    /**
     * Provoke an exception if we are in a background thread
     */
    public static void crashIfBackgroundThread() {
        if (BuildConfig.DEBUG) {
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                throw new IllegalStateException("This method should be called from a Background Thread");
            }
        }
    }
}
