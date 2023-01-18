package com.example.theboringapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.theboringapp.repository.ApiHelper;
import com.example.theboringapp.repository.boring_models.SearchResponse;
import com.example.theboringapp.repository.callbacks.GetVentureCallback;

import java.util.Locale;

//Activity to display a random Venture depending on options picked by user in the main activity
public class VentureDetails extends AppCompatActivity implements GetVentureCallback<SearchResponse> {

    public static final double FREE_MIN_PRICE = 0.0;
    public static final double FREE_MAX_PRICE = 0.0;
    public static final double CHEAP_MIN_PRICE = 0.0;
    public static final double CHEAP_MAX_PRICE = 0.33;
    public static final double MIDDLE_MIN_PRICE = 0.33;
    public static final double MIDDLE_MAX_PRICE = 0.66;
    public static final double EXPENSIVE_MIN_PRICE = 0.66;
    public static final double EXPENSIVE_MAX_PRICE = 1.0;

    private ImageView ventureDetailsTypeImageView;
    private TextView ventureCardDetailsNameTextView;
    private TextView ventureCardDetailsTypeTextView;
    private TextView ventureCardDetailsLinkTextView;
    private TextView xCloseTextView;
    private TextView ventureCardDetailsParticipantsAmountTextView;
    private Button tryAgainButton;
    private int ventureTypeImage;
    private ProgressBar accessibilityProgressBar;
    private ProgressBar priceProgressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venture_details);

        setUpUi();
        String ventureTypeName = getVentureDetails();
        ventureTypeImage = getVentureImage();

        ApiHelper apiHelper = new ApiHelper();
        Intent intent = getIntent();
        String filterType = intent.getStringExtra("PriceFilter");
        if (filterType.equalsIgnoreCase("all")) {
            apiHelper.searchVenture(ventureTypeName, this);
        } else {
            switch (filterType.toLowerCase(Locale.ROOT)) {
                case "free":
                    apiHelper.searchVentureByPrice(ventureTypeName, FREE_MIN_PRICE, FREE_MAX_PRICE, this);
                case "cheap":
                    apiHelper.searchVentureByPrice(ventureTypeName, CHEAP_MIN_PRICE, CHEAP_MAX_PRICE, this);
                case "middle":
                    apiHelper.searchVentureByPrice(ventureTypeName, MIDDLE_MIN_PRICE, MIDDLE_MAX_PRICE, this);
                case "expensive":
                    apiHelper.searchVentureByPrice(ventureTypeName, EXPENSIVE_MIN_PRICE, EXPENSIVE_MAX_PRICE, this);

            }

        }


        xCloseTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VentureDetails.this, MainActivity.class);
                startActivity(intent);
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

// Checks if user has used the price filter radio buttons in main activity and returns boolean (false if non selected)


    private void setUpUi() {
        ventureDetailsTypeImageView = findViewById(R.id.ventureDetailsTypeImageView);
        ventureCardDetailsNameTextView = findViewById(R.id.ventureCardDetailsNameTextView);
        ventureCardDetailsTypeTextView = findViewById(R.id.ventureCardDetailsTypeTextView);
        ventureCardDetailsParticipantsAmountTextView = findViewById(R.id.ventureCardDetailsParticipantsAmountTextView);
        ventureCardDetailsLinkTextView = findViewById(R.id.ventureCardDetailsLinkTextView);
        accessibilityProgressBar = findViewById(R.id.accessibilityProgressBar);
        priceProgressBar = findViewById(R.id.priceProgressBar);
        tryAgainButton = findViewById(R.id.tryAgainButton);
        xCloseTextView = findViewById(R.id.xCloseTextView);

    }

    //Gets the type of activity chosen
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

//gets image from selected venture type
    private int getVentureImage() {
        Intent intent = getIntent();
        return intent.getIntExtra("VentureImage", R.drawable.default_image);
    }

    private String makeCapital(String text){
        return text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase();
    }

    @Override
    public void onSuccess(SearchResponse data) {
        String ventureError = data.getVentureError();
        //checks if there is a venture available with given parameters (I.E the filter options) if not it displays an error message
        if (ventureError != null) {
            ventureDetailsTypeImageView.setImageResource(R.drawable.default_image);
            ventureCardDetailsNameTextView.setText(data.getVentureError());
        } else {
            ventureDetailsTypeImageView.setImageResource(ventureTypeImage);
            ventureCardDetailsNameTextView.setText(data.getVenture());
            String ventureType = data.getType();
            if (((ventureType != null))) {
                if (ventureType.equalsIgnoreCase("busywork")) {
                    ventureType = "Busy Work";
                } else if (ventureType.equalsIgnoreCase("diy")) {
                    ventureType = "DIY";
                } else {
                    ventureType = makeCapital(ventureType);
                }
                ventureCardDetailsTypeTextView.setText(ventureType);
            }
            ventureCardDetailsParticipantsAmountTextView.setText("" + data.getParticipants());
            setPriceProgressBar(data);
            String link = data.getLink();
            if ((link != null)) {
                ventureCardDetailsLinkTextView.setText(link);
                ventureCardDetailsLinkTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
                        startActivity(intent);
                    }
                });
            }
            setAccessibilityProgress(data);
        }


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
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


}