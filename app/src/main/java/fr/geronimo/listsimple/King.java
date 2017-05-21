package fr.geronimo.listsimple;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by Julien on 02/05/2017.
 */

public class King {
    private Bitmap picture;
    private String name;
    private String detail;

    public King(Bitmap picture, String name, String detail) {
        this.picture = picture;
        this.name = name;
        this.detail = detail;
    }

    public void setPicture(Bitmap picture) {
        this.picture = picture;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Bitmap getPicture() {

        return picture;
    }

    public String getName() {
        return name;
    }

    public String getDetail() {
        return detail;
    }
}
