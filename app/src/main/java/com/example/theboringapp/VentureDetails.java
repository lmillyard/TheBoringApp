package com.example.theboringapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.theboringapp.repository.ApiHelper;
import com.example.theboringapp.repository.boring_models.SearchResponse;
import com.example.theboringapp.repository.callbacks.GetVentureCallback;

import java.util.Locale;

//Activity to display a random Activity or Venture depending on options picked by user
public class VentureDetails extends AppCompatActivity implements GetVentureCallback<SearchResponse> {

    private TextView ventureNameDetailsTextView;
    private TextView ventureTypeDetailsTextView;
    private TextView ventureParticipantsDetailsTextView;
    private TextView venturePriceDetailsTextView;
    private TextView ventureLinkDetailsTextView;
    private TextView ventureAccessibilityDetailsTextView;
    private String ventureTypeName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venture_details);
        ventureNameDetailsTextView = findViewById(R.id.ventureNameDetailsTextView);
        ventureTypeDetailsTextView = findViewById(R.id.ventureTypeDetailsTextView);
        ventureParticipantsDetailsTextView = findViewById(R.id.ventureParticipantsDetailsTextView);
        venturePriceDetailsTextView = findViewById(R.id.venturePriceDetailsTextView);
        ventureLinkDetailsTextView = findViewById(R.id.ventureLinkDetailsTextView);
        ventureAccessibilityDetailsTextView = findViewById(R.id.ventureAccessibilityDetailsTextView);

        ventureTypeName = getVentureDetails();

        ApiHelper apiHelper = new ApiHelper();
        apiHelper.searchVenture(ventureTypeName, this);
    }

    @NonNull
    private String getVentureDetails() {
        Intent intent = getIntent();
        String ventureTypeName = intent.getStringExtra("Venture");
        ventureTypeName = ventureTypeName.toLowerCase(Locale.ROOT);
        return ventureTypeName;
    }


    @Override
    public void onSuccess(SearchResponse data) {
        ventureNameDetailsTextView.setText(data.getVenture());
        ventureTypeDetailsTextView.setText(data.getType());
        ventureParticipantsDetailsTextView.setText(String.valueOf(data.getParticipants()));
        venturePriceDetailsTextView.setText(String.valueOf(data.getPrice()));
        if (data.getLink() != null) {
            ventureLinkDetailsTextView.setText(data.getLink());
        }
        ventureAccessibilityDetailsTextView.setText(String.valueOf(data.getAccessibility()));

    }

    @Override
    public void onFailure(String message) {

    }
}