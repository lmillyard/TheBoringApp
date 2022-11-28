package com.example.theboringapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.theboringapp.adapters.VentureTypeAdapter;
import com.example.theboringapp.models.VentureType;
import com.example.theboringapp.repository.ApiHelper;
import com.example.theboringapp.repository.VentureTypeRepositoryFactory;
import com.example.theboringapp.repository.boring_models.SearchResponse;
import com.example.theboringapp.repository.callbacks.GetVentureCallback;
import java.util.List;

public class MainActivity extends AppCompatActivity implements GetVentureCallback<SearchResponse> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView ventureTypeRecyclerView = findViewById(R.id.ventureTypeRecyclerView);

        List<VentureType> ventureTypeList = VentureTypeRepositoryFactory.getVentureTypesRepository().getVentureTypes();

        VentureTypeAdapter ventureTypeAdapter = new VentureTypeAdapter(this, ventureTypeList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        ventureTypeRecyclerView.setLayoutManager(linearLayoutManager);
        ventureTypeRecyclerView.setAdapter(ventureTypeAdapter);

        ApiHelper apiHelper = new ApiHelper();
        apiHelper.searchVenture("recreational", this);
    }


    @Override
    public void onSuccess(SearchResponse data) {

    }

    @Override
    public void onFailure(String message) {

    }
}