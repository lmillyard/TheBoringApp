package com.example.theboringapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.theboringapp.adapters.ActivityTypeAdapter;
import com.example.theboringapp.models.ActivityTypeModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView activityTypeRecyclerView = findViewById(R.id.activityTypeRecyclerView);

        // Crating a new array list and added data to it
        ArrayList<ActivityTypeModel> activityTypeModelArrayList = new ArrayList<ActivityTypeModel>();
        activityTypeModelArrayList.add(new ActivityTypeModel("Social", R.drawable.ic_baseline_people_outline_24));
        activityTypeModelArrayList.add(new ActivityTypeModel("Education", R.drawable.ic_baseline_cast_for_education_24));

        // Initializing our adapter class and passing our arraylist to it.
        ActivityTypeAdapter activityTypeAdapter = new ActivityTypeAdapter(this, activityTypeModelArrayList);

        // below line is for setting a layout manager for our recycler view.
        // creating vertical list so I will provide orientation as vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        // in below two lines I am setting layoutmanager and adapter to my recycler view.
        activityTypeRecyclerView.setLayoutManager(linearLayoutManager);
        activityTypeRecyclerView.setAdapter(activityTypeAdapter);
    }
}