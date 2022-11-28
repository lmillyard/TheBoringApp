package com.example.theboringapp.repository;

import com.example.theboringapp.repository.boring_models.SearchResponse;
import com.example.theboringapp.repository.callbacks.GetVentureCallback;
import com.example.theboringapp.repository.services.VentureTypeService;

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
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        retrofit = new Retrofit.Builder()
            .baseUrl("https://www.boredapi.com/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public void searchVenture(String searchTerm, GetVentureCallback<SearchResponse> callback) {
        VentureTypeService ventureTypeService = retrofit.create(VentureTypeService.class);
        Call<SearchResponse> call = ventureTypeService.searchVentures(searchTerm);
        call.enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                if(response.isSuccessful()) {
                    SearchResponse body = response.body();
                    callback.onSuccess(body);
                } else {
                    callback.onFailure("Response not successful:" + response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {
                callback.onFailure("Check connection.");
                t.printStackTrace();
            }
        });
    }
}
