package com.example.theboringapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.theboringapp.R;
import com.example.theboringapp.VentureDetails;
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.venture_type_card_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        bindVentureType(holder,  ventureTypeList.get(position));
    }

    private void bindVentureType(ViewHolder holder, VentureType ventureType) {
        holder.ventureTextView.setText(ventureType.getVentureName());
        holder.ventureImageView.setImageResource(ventureType.getVentureImage());

        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), VentureDetails.class);
                intent.putExtra("Venture", ventureType.getVentureName());
                intent.putExtra("VentureImage", ventureType.getVentureImage());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return ventureTypeList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView ventureTextView;
        private final ImageView ventureImageView;
        private final CardView container;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ventureTextView = itemView.findViewById(R.id.ventureTypeTextView);
            ventureImageView = itemView.findViewById(R.id.ventureTypeImageView);
            container = itemView.findViewById(R.id.container);

        }
    }
}
