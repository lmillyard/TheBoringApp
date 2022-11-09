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
import com.example.theboringapp.models.ActivityTypeModel;

import java.util.ArrayList;

public class ActivityTypeAdapter extends RecyclerView.Adapter<ActivityTypeAdapter.ViewHolder> {

    private final Context context;
    private final ArrayList<ActivityTypeModel> activityTypeModelArrayList;

    public ActivityTypeAdapter(Context context, ArrayList<ActivityTypeModel> activityTypeModelArrayList) {
        this.context = context;
        this.activityTypeModelArrayList = activityTypeModelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // to set data to textview and imageview of each card layout
        ActivityTypeModel model = activityTypeModelArrayList.get(position);
        holder.activityTypeTextView.setText(model.getActivityTypeName());
        holder.activityTypeImageView.setImageResource(model.getActivityTypeImage());
    }

    @Override
    public int getItemCount() {
        // this method is used for showing number of card items in recycler view
        return activityTypeModelArrayList.size();
    }

    // View holder class for initializing of your views such as TextView and Imageview
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView activityTypeTextView;
        private final ImageView activityTypeImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            activityTypeTextView = itemView.findViewById(R.id.activityTypeTextView);
            activityTypeImageView = itemView.findViewById(R.id.activityTypeImageVIew);
        }
    }
}
