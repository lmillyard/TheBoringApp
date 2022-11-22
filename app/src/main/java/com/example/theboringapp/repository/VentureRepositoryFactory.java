package com.example.theboringapp.repository;

public class VentureRepositoryFactory {
    public static VentureRepository getVentureRepository() {
        return new HardcodedVentureRepository();
    }
}
