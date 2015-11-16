package com.example.administrator.BaiDuWaiMai.Bean;

/**
 * Created by Administrator on 2015/10/4 0004.
 */
public class StoreInfo {
    public String title;
    public String des;
    public float ratingbar;
    public String firstprice;
    public String secondprice;
    public String thirdprice;

    public String firsttitle;
    public String secondtitle;
    public String thirdtitle;

    public int firsticon;

    public StoreInfo(String title, String des, float ratingbar, String firstprice, String secondprice, String thirdprice, String secondtitle, String firsttitle, String
            thirdtitle , int firsticon, int secondicon, int thirdicon) {
        this.title = title;
        this.des = des;
        this.ratingbar = ratingbar;
        this.firstprice = firstprice;
        this.secondprice = secondprice;
        this.thirdprice = thirdprice;
        this.secondtitle = secondtitle;
        this.firsttitle = firsttitle;
        this.thirdtitle = thirdtitle;
        this.firsticon = firsticon;
        this.secondicon = secondicon;
        this.thirdicon = thirdicon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public float getRatingbar() {
        return ratingbar;
    }

    public void setRatingbar(float ratingbar) {
        this.ratingbar = ratingbar;
    }

    public String getFirstprice() {
        return firstprice;
    }

    public void setFirstprice(String firstprice) {
        this.firstprice = firstprice;
    }

    public String getSecondprice() {
        return secondprice;
    }

    public void setSecondprice(String secondprice) {
        this.secondprice = secondprice;
    }

    public String getThirdprice() {
        return thirdprice;
    }

    public void setThirdprice(String thirdprice) {
        this.thirdprice = thirdprice;
    }

    public String getFirsttitle() {
        return firsttitle;
    }

    public void setFirsttitle(String firsttitle) {
        this.firsttitle = firsttitle;
    }

    public String getSecondtitle() {
        return secondtitle;
    }

    public void setSecondtitle(String secondtitle) {
        this.secondtitle = secondtitle;
    }

    public String getThirdtitle() {
        return thirdtitle;
    }

    public void setThirdtitle(String thirdtitle) {
        this.thirdtitle = thirdtitle;
    }

    public int getFirsticon() {
        return firsticon;
    }

    public void setFirsticon(int firsticon) {
        this.firsticon = firsticon;
    }

    public int getSecondicon() {
        return secondicon;
    }

    public void setSecondicon(int secondicon) {
        this.secondicon = secondicon;
    }

    public int getThirdicon() {
        return thirdicon;
    }

    public void setThirdicon(int thirdicon) {
        this.thirdicon = thirdicon;
    }

    public int secondicon;
    public int thirdicon;


}
