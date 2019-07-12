package com.bluapp.mapview;

public class DoctorModel {
    private int imagePath;
    private String name;
    private String expertise;
    private String address;
    private String exp;
    private String fees;
    private String rank;

    public DoctorModel() {
    }

    public DoctorModel(int imagePath, String name, String expertise, String address, String exp, String fees, String rank) {
        this.imagePath = imagePath;
        this.name = name;
        this.expertise = expertise;
        this.address = address;
        this.exp = exp;
        this.fees = fees;
        this.rank = rank;
    }

    public int getImagePath() {
        return imagePath;
    }

    public String getName() {
        return name;
    }

    public String getExpertise() {
        return expertise;
    }

    public String getAddress() {
        return address;
    }

    public String getExp() {
        return exp;
    }

    public String getFees() {
        return fees;
    }

    public String getRank() {
        return rank;
    }
}
