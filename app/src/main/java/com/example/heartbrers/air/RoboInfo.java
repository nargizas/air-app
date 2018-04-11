package com.example.heartbrers.air;

/**
 * Created by nrgz on 10.04.2018.
 */

public class RoboInfo {
    private int iconId;
    private String r_name;

    public RoboInfo(int iconId, String r_name) {
        this.iconId = iconId;
        this.r_name= r_name;
    }


    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public String getTitle() {
        return r_name;
    }

    public void setR_name(String title) {
        this.r_name = title;
    }
}

