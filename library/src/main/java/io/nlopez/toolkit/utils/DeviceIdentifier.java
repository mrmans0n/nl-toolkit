package io.nlopez.toolkit.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.telephony.TelephonyManager;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

import io.nlopez.toolkit.Toolkit;

/**
 * Created by mrm on 19/05/14.
 */
public class DeviceIdentifier {

    private static final String PREFS_DEVICE_ID = "deviceId";

    private String storeKey;
    private Context context;

    private DeviceIdentifier(Context context) {
        this.context = context;
        this.storeKey = PREFS_DEVICE_ID;
    }

    public static DeviceIdentifier with(Context context) {
        return new DeviceIdentifier(context);
    }

    public DeviceIdentifier storeWithKey(String storeKey) {
        this.storeKey = storeKey;
        return this;
    }

    /**
     * Obtain an unique identifier for the device.
     * NOTE: By using this method, you should know you will need to add the android.permission.READ_PHONE_STATE permission.
     *
     * @return
     * @deprecated You should really not ask that kind of permissions in your apps. Use the UUID version instead!
     */
    public String identifierWithAndroidId() {

        final SharedPreferences prefs = context.getSharedPreferences(Toolkit.PREFERENCES_FILE, 0);
        final String id = prefs.getString(storeKey, null);

        UUID uuid;

        if (id != null) {
            uuid = UUID.fromString(id);

        } else {
            final String androidId = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);

            // Use ANDROID_ID unless it is not effective.
            try {
                if (!"9774d56d682e549c".equals(androidId)) {
                    uuid = UUID.nameUUIDFromBytes(androidId.getBytes("utf8"));
                } else {
                    final String deviceId = ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
                    uuid = deviceId != null ? UUID.nameUUIDFromBytes(deviceId.getBytes("utf8")) : UUID.randomUUID();
                }
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);

            }
            prefs.edit().putString(storeKey, uuid.toString()).commit();
        }

        return uuid.toString();
    }

    /**
     * Obtain an unique identifier for the device, using a randomly generated UUID the first time.
     *
     * @return
     */
    public String identifierWithUUID() {
        final SharedPreferences prefs = context.getSharedPreferences(Toolkit.PREFERENCES_FILE, 0);
        final String id = prefs.getString(storeKey, null);

        UUID uuid;

        if (id != null) {
            uuid = UUID.fromString(id);
        } else {
            uuid = UUID.randomUUID();
            prefs.edit().putString(storeKey, uuid.toString()).commit();
        }

        return uuid.toString();
    }

}
