package com.csuf.cpsc411.enrollmentapp.Model;

public class Vehicle {
    private String mMake;
    private String mModel;
    private int mYear;

    public Vehicle(String make, String model, int year) {
        mMake = make;
        mModel = model;
        mYear = year;
    }

    public String getMake() {
        return mMake;
    }

    public void setMake(String make) {
        mMake = make;
    }

    public String getModel() {
        return mModel;
    }

    public void setModel(String model) {
        mModel = model;
    }

    public int getYear() {
        return mYear;
    }

    public void setYear(int year) {
        mYear = year;
    }
}
