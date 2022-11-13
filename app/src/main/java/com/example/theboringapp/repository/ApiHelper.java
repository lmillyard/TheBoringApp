package com.example.theboringapp.repository;

import android.util.Log;

import com.example.theboringapp.repository.boring_models.SearchResponse;
import com.example.theboringapp.repository.services.ActivitiesService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiHelper {
    public static final String TAG = "API_HELPER";
    private final Retrofit retrofit;

    public ApiHelper() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        retrofit = new Retrofit.Builder()
            .baseUrl("https://www.boredapi.com/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public void searchActivityType(String searchTerm) {
        ActivitiesService activitiesService = retrofit.create(ActivitiesService.class);
        Call<SearchResponse> call = activitiesService.searchActivities("type=" + searchTerm);
        call.enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                if(response.isSuccessful()) {
                } else {
                }
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
