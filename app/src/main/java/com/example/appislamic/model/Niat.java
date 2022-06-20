package com.example.appislamic.model;

public class Niat {
    private String sholat;
    private String arab;
    private String latin;
    private String terjemahan;

    public Niat(){

    }

    public Niat(String arab, String latin, String terjemahan) {
        this.arab = arab;
        this.latin = latin;
        this.terjemahan = terjemahan;
    }

    public String getArab() {
        return arab;
    }

    public void setArab(String arab) {
        this.arab = arab;
    }

    public String getLatin() {
        return latin;
    }

    public void setLatin(String latin) {
        this.latin = latin;
    }

    public String getTerjemahan() {
        return terjemahan;
    }

    public void setTerjemahan(String terjemahan) {
        this.terjemahan = terjemahan;
    }

    public String getSholat() {
        return sholat;
    }

    public void setSholat(String sholat) {
        this.sholat = sholat;
    }
}
