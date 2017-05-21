package fr.geronimo.listsimple;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Julien on 04/05/2017.
 */

public class KingViewHolder {
    public TextView name;
    public TextView details;
    public ImageView picture;

    public Button details_toast;

    public ImageView getPicture() { return picture; }

    public void setPicture(ImageView picture) {
        this.picture = picture;
    }

    public TextView getName() {
        return name;
    }

    public void setName(TextView name) {
        this.name = name;
    }

    public TextView getDetails() {
        return details;
    }

    public void setDetails(TextView details) {
        this.details = details;
    }

    public Button getDetails_toast() {
        return details_toast;
    }

    public void setDetails_toast(Button details_toast) {
        this.details_toast = details_toast;
    }

}
