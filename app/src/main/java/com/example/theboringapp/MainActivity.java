package com.example.theboringapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.theboringapp.adapters.VentureTypeAdapter;
import com.example.theboringapp.models.VentureType;
import com.example.theboringapp.repository.VentureTypeRepositoryFactory;

import java.util.List;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView ventureTypeRecyclerView = findViewById(R.id.ventureTypeRecyclerView);
        List<VentureType> ventureTypeList = VentureTypeRepositoryFactory.getVentureTypesRepository().getVentureTypes();

        VentureTypeAdapter ventureTypeAdapter = new VentureTypeAdapter(this, ventureTypeList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);

        ventureTypeRecyclerView.setLayoutManager(gridLayoutManager);
        ventureTypeRecyclerView.setAdapter(ventureTypeAdapter);

    }
}