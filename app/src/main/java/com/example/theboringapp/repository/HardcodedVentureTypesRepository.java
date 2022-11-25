package com.example.theboringapp.repository;

import com.example.theboringapp.R;
import com.example.theboringapp.models.HardcodedVentureType;
import com.example.theboringapp.models.VentureType;

import java.util.ArrayList;
import java.util.List;

public class HardcodedVentureTypesRepository implements VentureTypesRepository {
    private List<VentureType> list = new ArrayList<>();
    {
        list.add(new HardcodedVentureType("Random", R.drawable.ic_baseline_adb_24));
        list.add(new HardcodedVentureType("Education", R.drawable.ic_baseline_cast_for_education_24));
        list.add(new HardcodedVentureType("Recreational", R.drawable.ic_baseline_local_florist_24));
        list.add(new HardcodedVentureType("Social", R.drawable.ic_baseline_people_outline_24));
        list.add(new HardcodedVentureType("DIY", R.drawable.ic_baseline_handyman_24));
        list.add(new HardcodedVentureType("Charity", R.drawable.ic_baseline_emoji_people_24));
        list.add(new HardcodedVentureType("Cooking", R.drawable.ic_baseline_fastfood_24));
        list.add(new HardcodedVentureType("Relaxation", R.drawable.ic_baseline_single_bed_24));
        list.add(new HardcodedVentureType("Music", R.drawable.ic_baseline_music_note_24));
        list.add(new HardcodedVentureType("Busy Work", R.drawable.ic_baseline_cleaning_services_24));
    }
    @Override
    public List<VentureType> getVentureTypes() {
        return list;
    }
}
