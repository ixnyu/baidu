package com.example.administrator.BaiDuWaiMai.Bean;

/**
 * Created by jabin on 6/1/15.
 */
public class Info {

    public String name;
    public int icon;

    public Info(String name, int icon) {
        this.name = name;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
