package com.example.theboringapp.repository.services;

import com.example.theboringapp.repository.boring_models.SearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface VentureTypeService {
    @GET("api/activity")
    Call<SearchResponse> searchVentures(@Query("type") String ventureType);

}

