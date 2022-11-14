package com.example.theboringapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.theboringapp.adapters.ActivityTypeAdapter;
import com.example.theboringapp.models.ActivityTypeModel;
import com.example.theboringapp.repository.ApiHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView activityTypeRecyclerView = findViewById(R.id.activityTypeRecyclerView);

        // Creating a new array list and adding data to it
        ArrayList<ActivityTypeModel> activityTypeModelArrayList = getActivityTypeModels();

        // Initializing the adapter class and passing our arraylist to it.
        ActivityTypeAdapter activityTypeAdapter = new ActivityTypeAdapter(this, activityTypeModelArrayList);

        // below line is for setting a layout manager for our recycler view.
        // creating vertical list so I will provide orientation as vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        // in below two lines I am setting layoutManager and adapter to my recycler view.
        activityTypeRecyclerView.setLayoutManager(linearLayoutManager);
        activityTypeRecyclerView.setAdapter(activityTypeAdapter);

        ApiHelper apiHelper = new ApiHelper();
        apiHelper.searchActivityType("recreational");
    }

    @NonNull
    private ArrayList<ActivityTypeModel> getActivityTypeModels() {
        ArrayList<ActivityTypeModel> activityTypeModelArrayList = new ArrayList<ActivityTypeModel>();
        activityTypeModelArrayList.add(new ActivityTypeModel("Education", R.drawable.ic_baseline_adb_24));
        activityTypeModelArrayList.add(new ActivityTypeModel("Recreational", R.drawable.ic_baseline_local_florist_24));
        activityTypeModelArrayList.add(new ActivityTypeModel("Social", R.drawable.ic_baseline_people_outline_24));
        activityTypeModelArrayList.add(new ActivityTypeModel("DIY", R.drawable.ic_baseline_handyman_24));
        activityTypeModelArrayList.add(new ActivityTypeModel("Charity", R.drawable.ic_baseline_emoji_people_24));
        activityTypeModelArrayList.add(new ActivityTypeModel("Cooking", R.drawable.ic_baseline_fastfood_24));
        activityTypeModelArrayList.add(new ActivityTypeModel("Relaxation", R.drawable.ic_baseline_single_bed_24));
        activityTypeModelArrayList.add(new ActivityTypeModel("Music", R.drawable.ic_baseline_music_note_24));
        activityTypeModelArrayList.add(new ActivityTypeModel("Busy Work", R.drawable.ic_baseline_cleaning_services_24));
        return activityTypeModelArrayList;
    }
}