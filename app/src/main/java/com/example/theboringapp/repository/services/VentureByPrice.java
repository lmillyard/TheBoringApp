package com.example.theboringapp.repository.services;

import com.example.theboringapp.repository.boring_models.SearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface VentureByPrice {
        @GET("api/activity")
        Call<SearchResponse> searchVenturesByPrice(
                @Query("type") String ventureType,
                @Query("minprice") double ventureMinPrice,
                @Query("maxprice") double ventureMaxPrice
        );

}
