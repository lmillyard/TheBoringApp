package com.example.theboringapp.repository.boring_models;

import com.google.gson.annotations.SerializedName;

public class SearchResponse {
    @SerializedName("activity")
    private String activity;
    @SerializedName("accessibility")
    private int accessibility;
    @SerializedName("type")
    private String type;
    @SerializedName("participants")
    private int participants;
    @SerializedName("price")
    private int price;
    @SerializedName("key")
    private int key;

    public String getActivity() {
        return activity;
    }

    public int getAccessibility() {
        return accessibility;
    }

    public String getType() {
        return type;
    }

    public int getParticipants() {
        return participants;
    }

    public int getPrice() {
        return price;
    }

    public int getKey() {
        return key;
    }
}
