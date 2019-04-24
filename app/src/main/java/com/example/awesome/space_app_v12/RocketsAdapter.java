package com.example.awesome.space_app_v12;

import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RocketsAdapter extends RecyclerView.Adapter<RocketsAdapter.RocketsViewHolder>{

    private List<RocketsModel> posts;

    public RocketsAdapter(List<RocketsModel> posts) {
        this.posts = posts;
    }

    @Override
    public RocketsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rockets,
                parent, false);
        return new RocketsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RocketsViewHolder holder, int position) {
        RocketsModel rockets1 = posts.get(position);
        holder.tvRocketsName.setText(rockets1.getRocketName());
        holder.tvRocketsFirstFlight.setText(rockets1.getFirstFlight());

    }

    @Override
    public int getItemCount() {
        if (posts == null)
            return 0;
        return posts.size();
    }


    class RocketsViewHolder extends RecyclerView.ViewHolder {
        TextView tvRocketsName;
        TextView tvRocketsFirstFlight;

        public RocketsViewHolder(View itemView) {
            super(itemView);
            tvRocketsName = (TextView) itemView.findViewById(R.id.tvRocketsName);
            tvRocketsFirstFlight = (TextView) itemView.findViewById(R.id.tvRocketsFirstFlight);
        }
    }

}