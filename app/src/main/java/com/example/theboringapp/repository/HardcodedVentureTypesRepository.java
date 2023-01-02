package com.example.theboringapp.repository;

import com.example.theboringapp.R;
import com.example.theboringapp.models.HardcodedVentureType;
import com.example.theboringapp.models.VentureType;

import java.util.ArrayList;
import java.util.List;

public class HardcodedVentureTypesRepository implements VentureTypesRepository {
    private List<VentureType> list = new ArrayList<>();
    {
        list.add(new HardcodedVentureType("Random", R.drawable.random));
        list.add(new HardcodedVentureType("Education", R.drawable.education));
        list.add(new HardcodedVentureType("Recreational", R.drawable.recreational));
        list.add(new HardcodedVentureType("Social", R.drawable.social));
        list.add(new HardcodedVentureType("DIY", R.drawable.diy));
        list.add(new HardcodedVentureType("Charity", R.drawable.charity));
        list.add(new HardcodedVentureType("Cooking", R.drawable.cooking));
        list.add(new HardcodedVentureType("Relaxation", R.drawable.relaxation));
        list.add(new HardcodedVentureType("Music", R.drawable.music));
        list.add(new HardcodedVentureType("Busy Work", R.drawable.busywork));
    }
    @Override
    public List<VentureType> getVentureTypes() {
        return list;
    }
}
