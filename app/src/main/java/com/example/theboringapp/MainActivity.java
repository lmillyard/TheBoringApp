package com.example.theboringapp;

import android.os.Bundle;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.theboringapp.adapters.VentureTypeAdapter;
import com.example.theboringapp.models.VentureType;
import com.example.theboringapp.repository.VentureTypeRepositoryFactory;

import java.util.List;

public class MainActivity extends AppCompatActivity  {

    public String filterType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RadioGroup radioGroup = findViewById(R.id.radioGroup);

        setFilterType(radioGroup);


        RecyclerView ventureTypeRecyclerView = findViewById(R.id.ventureTypeRecyclerView);
        List<VentureType> ventureTypeList = VentureTypeRepositoryFactory.getVentureTypesRepository().getVentureTypes();

        VentureTypeAdapter ventureTypeAdapter = new VentureTypeAdapter(this, ventureTypeList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);

        ventureTypeRecyclerView.setLayoutManager(gridLayoutManager);
        ventureTypeRecyclerView.setAdapter(ventureTypeAdapter);

    }

    private void setFilterType(RadioGroup radioGroup) {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.freeRadioButton) {
                    filterType = "free";
                } else if (checkedId == R.id.cheapRadioButton) {
                    filterType = "cheap";
                } else if (checkedId == R.id.middleRadioButton) {
                    filterType = "middle";
                }  else if (checkedId == R.id.expensiveRadioButton) {
                    filterType = "expensive";
                }  else {
                    filterType = "all";
                }
            }
        });

        if (filterType == null) {
            filterType = "all";
        }
    }


}