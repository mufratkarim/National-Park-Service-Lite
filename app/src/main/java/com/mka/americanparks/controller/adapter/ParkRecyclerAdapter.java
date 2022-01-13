package com.mka.americanparks.controller.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mka.americanparks.R;
import com.mka.americanparks.model.Park;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ParkRecyclerAdapter extends RecyclerView.Adapter<ParkRecyclerAdapter.ParkViewHolder> {

    private List<Park> parkList;
    private final OnParkClickListener parkClickListener;

    public ParkRecyclerAdapter(List<Park> parkList, OnParkClickListener parkClickListener) {
        this.parkList = parkList;
        this.parkClickListener = parkClickListener;
    }

    @NonNull
    @Override
    public ParkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.park_recycle, parent, false);

        return new ParkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParkViewHolder holder, int position) {

        Park park = parkList.get(position);
        holder.name.setText(park.getFullName());
        holder.url.setText(park.getUrl());
        if (park.getDesignation().equals("")) {
            holder.type.setText("N/A");
        }
        else {
            holder.type.setText(String.format("Designation: %s", park.getDesignation()));
        }
        holder.state.setText(String.format("State: %s", park.getStates()));

        if (park.getImages().size() > 0) {
            Picasso.get()
                    .load(park.getImages().get(0).getUrl())
                    .placeholder(android.R.drawable.stat_sys_download)
                    .error(android.R.drawable.stat_notify_error)
                    .resize(150, 200)
                    .centerCrop()
                    .into(holder.imageView);
            ;
        }

    }

    @Override
    public int getItemCount() {
        return parkList.size();
    }

    public class ParkViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imageView;
        private TextView name;
        private TextView type;
        private TextView state;
        private TextView url;
        private OnParkClickListener onParkClickListener;

        public ParkViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.recycle_name);
            type = itemView.findViewById(R.id.recycle_type);
            state = itemView.findViewById(R.id.recycle_state);
            url = itemView.findViewById(R.id.recycle_url);
            imageView = itemView.findViewById(R.id.recycle_imageView);

            this.onParkClickListener = parkClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Park currPark = parkList.get(getAdapterPosition());
            onParkClickListener.onParkClicked(currPark);
        }
    }
}
