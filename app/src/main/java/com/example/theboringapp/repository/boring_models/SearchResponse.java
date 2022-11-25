package com.example.theboringapp.repository.boring_models;

import com.google.gson.annotations.SerializedName;

public class SearchResponse {
    @SerializedName("activity")
    private String venture;
    @SerializedName("accessibility")
    private double accessibility;
    @SerializedName("type")
    private String type;
    @SerializedName("participants")
    private int participants;
    @SerializedName("price")
    private double price;
    @SerializedName("link")
    private String link;
    @SerializedName("key")
    private String key;

    public String getVenture() {
        return venture;
    }

    public double getAccessibility() {
        return accessibility;
    }

    public String getType() {
        return type;
    }

    public int getParticipants() {
        return participants;
    }

    public double getPrice() {
        return price;
    }

    public String getLink() {
        return link;
    }

    public String getKey() {
        return key;
    }
}
