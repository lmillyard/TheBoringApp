package com.example.theboringapp.models;

/**
 * Activity types are different categories of things to do - like recreational/social/DIY
 */
public class VentureModel {

    private String ventureName;
    private int ventureImage;

    public VentureModel(String ventureName, int ventureImage) {
        this.ventureName = ventureName;
        this.ventureImage = ventureImage;
    }

    public String getVentureName() {
        return ventureName;
    }

    public void setVentureName(String ventureName) {
        this.ventureName = ventureName;
    }

    public int getVentureImage() {
        return ventureImage;
    }

    public void setVentureImage(int ventureImage) {
        this.ventureImage = ventureImage;
    }
}
