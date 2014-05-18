package io.nlopez.toolkit.sample.model;

/**
 * Created by mrm on 18/05/14.
 */
public class TextAndImageItem {

    private String text;
    private int imageId;

    public TextAndImageItem(String text, int imageId) {
        this.text = text;
        this.imageId = imageId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
