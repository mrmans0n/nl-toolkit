package io.nlopez.toolkit.sample.model;

/**
 * Created by mrm on 18/05/14.
 */
public class TextImageAndButtonItem {

    private String text;
    private String buttonText;
    private int imageId;

    public TextImageAndButtonItem(String text, String buttonText, int imageId) {
        this.text = text;
        this.buttonText = buttonText;
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

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }
}
