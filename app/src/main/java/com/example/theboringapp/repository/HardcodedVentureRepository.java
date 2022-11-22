package com.example.theboringapp.repository;

import com.example.theboringapp.models.HardcodedVentures;
import com.example.theboringapp.models.Venture;

public class HardcodedVentureRepository implements VentureRepository {
    @Override
    public Venture getVenture() {
        return new HardcodedVentures("Learn a new recipe", 0.05, "cooking", 1, 0, "3136036");
    }

    @Override
    public Venture getVentureByAccessibility(int accessibilityFactor) {
        return null;
    }

    @Override
    public Venture getVentureByType(String type) {
        return null;
    }

    @Override
    public Venture getVentureByParticipants(int participants) {
        return null;
    }

    @Override
    public Venture GetVentureByPrice(int priceFactor) {
        return null;
    }
}
