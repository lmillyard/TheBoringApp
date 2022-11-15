package com.example.theboringapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.theboringapp.adapters.VentureAdapter;
import com.example.theboringapp.models.VentureModel;
import com.example.theboringapp.repository.ApiHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView activityTypeRecyclerView = findViewById(R.id.activityTypeRecyclerView);


        ArrayList<VentureModel> ventureModelArrayList = getActivityTypeModels();

        VentureAdapter ventureAdapter = new VentureAdapter(this, ventureModelArrayList);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        activityTypeRecyclerView.setLayoutManager(linearLayoutManager);
        activityTypeRecyclerView.setAdapter(ventureAdapter);

        ApiHelper apiHelper = new ApiHelper();
        apiHelper.searchVenture("recreational");
    }

    @NonNull
    private ArrayList<VentureModel> getActivityTypeModels() {
        ArrayList<VentureModel> ventureModelArrayList = new ArrayList<VentureModel>();
        ventureModelArrayList.add(new VentureModel("Education", R.drawable.ic_baseline_adb_24));
        ventureModelArrayList.add(new VentureModel("Recreational", R.drawable.ic_baseline_local_florist_24));
        ventureModelArrayList.add(new VentureModel("Social", R.drawable.ic_baseline_people_outline_24));
        ventureModelArrayList.add(new VentureModel("DIY", R.drawable.ic_baseline_handyman_24));
        ventureModelArrayList.add(new VentureModel("Charity", R.drawable.ic_baseline_emoji_people_24));
        ventureModelArrayList.add(new VentureModel("Cooking", R.drawable.ic_baseline_fastfood_24));
        ventureModelArrayList.add(new VentureModel("Relaxation", R.drawable.ic_baseline_single_bed_24));
        ventureModelArrayList.add(new VentureModel("Music", R.drawable.ic_baseline_music_note_24));
        ventureModelArrayList.add(new VentureModel("Busy Work", R.drawable.ic_baseline_cleaning_services_24));
        return ventureModelArrayList;
    }
}