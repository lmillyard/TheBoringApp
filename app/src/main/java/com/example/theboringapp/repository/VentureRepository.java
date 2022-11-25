package com.example.theboringapp.repository;

import com.example.theboringapp.models.Venture;

import java.util.List;

public interface VentureRepository {
    List<Venture> getVenture();
    Venture getVentureByAccessibility(int accessibilityFactor);
    Venture getVentureByType(String type);
    Venture getVentureByParticipants(int participants);
    Venture GetVentureByPrice(int priceFactor);

}
