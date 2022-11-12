package com.example.theboringapp.repository.services;

import com.example.theboringapp.repository.boring_models.SearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ActivitiesService {
    @GET("api/activity")
    Call<SearchResponse> searchActivities(@Query("?") String searchTerm);
}
