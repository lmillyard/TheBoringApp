package com.example.theboringapp.repository.boring_models;

import com.google.gson.annotations.SerializedName;

public class SearchResponse {
    @SerializedName("activity")
    private String activity;
    @SerializedName("type")
    private String type;

    public String getActivity() {
        return activity;
    }
}
