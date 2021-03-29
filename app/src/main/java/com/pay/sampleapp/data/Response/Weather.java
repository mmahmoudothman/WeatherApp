package com.pay.sampleapp.data.Response;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

public class Weather {
    private int id;

    private String main;

    private String description;

    private String icon;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getMain() {
        return this.main;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        String ss = "@Drawable/ic_" + this.icon;
        return ss;
    }

    @BindingAdapter("BrandImage")
    public static void setImage(ImageView imageView, int resource) {
        imageView.setImageResource(resource);
    }

}
