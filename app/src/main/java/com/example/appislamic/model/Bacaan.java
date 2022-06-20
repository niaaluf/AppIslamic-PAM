package com.example.appislamic.model;

public class Bacaan {
    private String nama;
    private String arab;
    private String latin;
    private String terjemahan;

    public Bacaan(){

    }

    public Bacaan(String nama, String arab, String latin, String terjemahan){
        this.nama = nama;
        this.arab = arab;
        this.latin = latin;
        this.terjemahan = terjemahan;
    }

    public String getNama(){
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
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

}
