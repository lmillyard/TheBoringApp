package com.example.theboringapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.theboringapp.R;
import com.example.theboringapp.models.VentureType;

import java.util.List;

public class VentureTypeAdapter extends RecyclerView.Adapter<VentureTypeAdapter.ViewHolder> {

    private final Context context;
    private final List<VentureType> ventureTypeList;

    public VentureTypeAdapter(Context context, List<VentureType> ventureTypeList) {
        this.context = context;
        this.ventureTypeList = ventureTypeList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        VentureType model = ventureTypeList.get(position);
        holder.ventureTextView.setText(model.getVentureName());
        holder.ventureImageView.setImageResource(model.getVentureImage());
    }

    @Override
    public int getItemCount() {
        return ventureTypeList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView ventureTextView;
        private final ImageView ventureImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ventureTextView = itemView.findViewById(R.id.ventureTextView);
            ventureImageView = itemView.findViewById(R.id.ventureImageVIew);
        }
    }
}
