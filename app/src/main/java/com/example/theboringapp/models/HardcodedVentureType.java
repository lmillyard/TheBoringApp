package com.example.theboringapp.models;

public class HardcodedVentureType implements VentureType {
    private String name;
    private int image;

    public HardcodedVentureType(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public String getVentureName() {
        return name;
    }

    public void setVentureName(String name) {
        this.name = name;
    }

    public int getVentureImage() {
        return image;
    }

    public void setVentureImage(int image) {
        this.image = image;
    }
}
