package com.example.theboringapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.theboringapp.repository.ApiHelper;
import com.example.theboringapp.repository.boring_models.SearchResponse;
import com.example.theboringapp.repository.callbacks.GetVentureCallback;

import java.util.Locale;

//Activity to display a random Activity or Venture depending on options picked by user
public class VentureDetails extends AppCompatActivity implements GetVentureCallback<SearchResponse> {

    private Context context;
    private ImageView ventureDetailsTypeImageView;
    private TextView ventureCardDetailsNameTextView;
    private TextView ventureCardDetailsTypeTextView;
    private TextView ventureCardDetailsParticipantsTextView;
    private TextView ventureCardDetailsPriceTextView;
    private TextView ventureCardDetailsLinkTextView;
    private TextView ventureCardDetailsAccessibilityTextView;
    private ProgressBar loadingProgressBar;
    private Button tryAgainButton;
    private Button goBackButton;
    private String ventureTypeName;
    private int ventureTypeImage;
    private ProgressBar accessibilityProgressBar;
    private ProgressBar priceProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venture_details);

        setUpUi();
        loadingProgressBar.setVisibility(View.VISIBLE);
        ventureTypeName = getVentureDetails();
        ventureTypeImage = getVentureImage();

        ApiHelper apiHelper = new ApiHelper();
        apiHelper.searchVenture(ventureTypeName, this);

        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                context.startActivity(intent);
                finish();
            }
        });

        tryAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(getIntent());
            }
        });
    }

    private void setUpUi() {
        loadingProgressBar = findViewById(R.id.loadingProgressBar);
        ventureDetailsTypeImageView = findViewById(R.id.ventureDetailsTypeImageView);
        ventureCardDetailsNameTextView = findViewById(R.id.ventureCardDetailsNameTextView);
        ventureCardDetailsTypeTextView = findViewById(R.id.ventureCardDetailsTypeTextView);
        ventureCardDetailsParticipantsTextView = findViewById(R.id.ventureCardDetailsParticipantsTextView);
        ventureCardDetailsPriceTextView = findViewById(R.id.ventureCardDetailsPriceTextView);
        ventureCardDetailsLinkTextView = findViewById(R.id.ventureCardDetailsLinkTextView);
        ventureCardDetailsAccessibilityTextView = findViewById(R.id.ventureCardDetailsAccessibilityTextView);
        accessibilityProgressBar = findViewById(R.id.accessibilityProgressBar);
        priceProgressBar = findViewById(R.id.priceProgressBar);
        tryAgainButton = findViewById(R.id.tryAgainButton);
        goBackButton = findViewById(R.id.goBackButton);

    }

    @NonNull
    private String getVentureDetails() {
        Intent intent = getIntent();
        String ventureTypeName = intent.getStringExtra("Venture");
        ventureTypeName = ventureTypeName.toLowerCase(Locale.ROOT);
        ventureTypeName = ventureTypeName.replaceAll("\\s+", "");
        if(ventureTypeName.equalsIgnoreCase("random")) {
            ventureTypeName = null;
        }
        return ventureTypeName;
    }
    private int getVentureImage() {
        Intent intent = getIntent();
        int ventureTypeImage = intent.getIntExtra("VentureImage", R.drawable.ic_baseline_tag_faces_24);
        return ventureTypeImage;
    }


    @Override
    public void onSuccess(SearchResponse data) {
        loadingProgressBar.setVisibility(View.GONE);
        ventureDetailsTypeImageView.setImageResource(ventureTypeImage);
        ventureCardDetailsNameTextView.setText(data.getVenture());
        ventureCardDetailsTypeTextView.setText(data.getType());
        ventureCardDetailsParticipantsTextView.setText("Participants: " + data.getParticipants());
        setPriceProgressBar(data);
        if (data.getLink() != null) {
            ventureCardDetailsLinkTextView.setText(data.getLink());
        }
        setAccessibilityProgress(data);

    }

    private void setPriceProgressBar(SearchResponse data) {
        double price = data.getPrice() * 100;
        priceProgressBar.setProgress((int) price);
    }

    private void setAccessibilityProgress(SearchResponse data) {
        double accessibility = data.getAccessibility() * 100;
        double invertedAccessibility = 100 - accessibility;
        accessibilityProgressBar.setProgress((int)invertedAccessibility);
    }

    @Override
    public void onFailure(String message) {
        loadingProgressBar.setVisibility(View.GONE);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}