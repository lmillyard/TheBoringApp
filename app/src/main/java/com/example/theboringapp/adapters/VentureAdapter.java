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
import com.example.theboringapp.models.VentureModel;

import java.util.ArrayList;

public class VentureAdapter extends RecyclerView.Adapter<VentureAdapter.ViewHolder> {

    private final Context context;
    private final ArrayList<VentureModel> ventureModelArrayList;

    public VentureAdapter(Context context, ArrayList<VentureModel> ventureModelArrayList) {
        this.context = context;
        this.ventureModelArrayList = ventureModelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        VentureModel model = ventureModelArrayList.get(position);
        holder.ventureTextView.setText(model.getVentureName());
        holder.ventureImageView.setImageResource(model.getVentureImage());
    }

    @Override
    public int getItemCount() {
        return ventureModelArrayList.size();
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
