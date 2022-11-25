package com.example.theboringapp.repository;

import com.example.theboringapp.models.HardcodedVentures;
import com.example.theboringapp.models.Venture;

import java.util.ArrayList;
import java.util.List;

public class HardcodedVentureRepository implements VentureRepository {
    private List<Venture> list = new ArrayList<>(); {
        list.add(new HardcodedVentures("Learn a new recipe", 0.05, "cooking", 1, 0, "", "43036"));
        list.add(new HardcodedVentures("Learn Express.js", 0.25, "education", 1, 0.1, "https://expressjs.com/", "3943506"));
        list.add(new HardcodedVentures("Do a jigsaw puzzle", 1, "recreational", 1, 0.1, "https://en.wikipedia.org/wiki/Jigsaw_puzzle", "8550768"));
        list.add(new HardcodedVentures("Organize your music collection", 0, "social", 1, 0.1, "", "2237769"));
        list.add(new HardcodedVentures("Take your dog on a walk", 0.2, "relaxation", 1, 0, "", "9318514"));
        list.add(new HardcodedVentures("Donate to your local food bank", 0.8, "charity", 1, 0.5, "", "4150284"));

    }
    @Override
    public List<Venture> getVenture() {
        return list;
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
