package com.example.theboringapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
//Activity to display a random Activity or Venture depending on options picked by user
public class VentureDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venture_details);
    }
}