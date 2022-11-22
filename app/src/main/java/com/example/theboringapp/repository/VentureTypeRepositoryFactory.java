package com.example.theboringapp.repository;

public class VentureTypeRepositoryFactory {
    public static VentureTypesRepository getVentureTypesRepository() {
        return new HardcodedVentureTypesRepository();
    }
}
