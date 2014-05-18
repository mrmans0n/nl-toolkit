package io.nlopez.toolkit.models;

import android.app.Fragment;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by mrm on 18/05/14.
 */
public class MenuFragmentEntry implements Parcelable {

    private int title;
    private int image;
    private Class<? extends Fragment> fragmentClass;
    private boolean selected;

    public MenuFragmentEntry(int title, int image, Class<? extends Fragment> fragmentClass) {
        this.title = title;
        this.image = image;
        this.selected = false;
        this.fragmentClass = fragmentClass;
    }

    public MenuFragmentEntry(Parcel in) {
        this.title = in.readInt();
        this.image = in.readInt();
        try {
            this.fragmentClass = (Class<? extends Fragment>) Class.forName(in.readString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int getTitle() {
        return title;
    }

    public int getImage() {
        return image;
    }

    public Class<? extends Fragment> getFragmentClass() {
        return fragmentClass;
    }

    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.title);
        dest.writeInt(this.image);
        dest.writeString(this.fragmentClass.getName());
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public MenuFragmentEntry createFromParcel(Parcel in) {
            return new MenuFragmentEntry(in);
        }

        public MenuFragmentEntry[] newArray(int size) {
            return new MenuFragmentEntry[size];
        }
    };

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

}
