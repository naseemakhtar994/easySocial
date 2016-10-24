package com.mcs.easysocialsample;


import android.graphics.drawable.Drawable;

public class SocialApp {

    private String social_title, social_installed, social_version;
    private Drawable social_icon;

    public SocialApp(Drawable social_icon, String social_title, String social_installed, String social_version) {
        this.social_icon = social_icon;
        this.social_title = social_title;
        this.social_installed = social_installed;
        this.social_version = social_version;
    }

    public Drawable getSocial_icon(){return social_icon;}

    public String getSocial_title() {
        return social_title;
    }
    public String getSocial_installed() {
        return social_installed;
    }
    public String getSocial_version() {
        return social_version;
    }

    public void setSocial_Icon(Drawable social_icon) {
        this.social_icon = social_icon;
    }

    public void setSocial_title(String social_title) {
        this.social_title = social_title;
    }
    public void setSocial_installed(String social_installed) {
        this.social_installed = social_installed;
    }
    public void setSocial_version(String social_version) {
        this.social_version = social_version;
    }

}