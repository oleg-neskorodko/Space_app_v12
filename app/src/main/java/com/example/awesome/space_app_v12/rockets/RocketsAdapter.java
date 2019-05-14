package com.example.awesome.space_app_v12.rockets;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.awesome.space_app_v12.MainActivity;
import com.example.awesome.space_app_v12.R;
import com.example.awesome.space_app_v12.UrlClickListener;

import java.util.List;

public class RocketsAdapter extends RecyclerView.Adapter<RocketsAdapter.RocketsViewHolder>{

    private List<RocketsModel> posts;
    private UrlClickListener listener;
    private View.OnClickListener mClickListener;

    public RocketsAdapter(UrlClickListener listener, List<RocketsModel> posts) {
        this.posts = posts;
        this.listener = listener;
    }

    public void setClickListener(View.OnClickListener callback) {
        mClickListener = callback;
    }

    @Override
    public RocketsAdapter.RocketsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rockets,
                parent, false);

        RocketsAdapter.RocketsViewHolder holder = new RocketsAdapter.RocketsViewHolder(v);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mClickListener.onClick(view);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(final RocketsViewHolder holder, int position) {
        RocketsModel rockets1 = posts.get(position);
        holder.tvRocketsName.setText(rockets1.getRocketName());
        holder.tvRocketsTypeValue.setText(rockets1.getRocketType());
        holder.tvRocketsCostValue.setText(String.valueOf(rockets1.getCostPerLaunch()));
        holder.tvRocketsWiki.setText(rockets1.getWikipedia());
        holder.tvRocketsWiki.setTextColor(Color.BLUE);
        holder.tvRocketsWiki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = ((TextView) holder.tvRocketsWiki).getText().toString();
                listener.onClickUrl(url);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (posts == null)
            return 0;
        return posts.size();
    }

    class RocketsViewHolder extends RecyclerView.ViewHolder {
         TextView tvRocketsName;
         TextView tvRocketsTypeValue;
         TextView tvRocketsCostValue;
         TextView tvRocketsWiki;

        public RocketsViewHolder(View itemView) {
            super(itemView);
            tvRocketsName = (TextView) itemView.findViewById(R.id.tvRocketsName);
            tvRocketsTypeValue = (TextView) itemView.findViewById(R.id.tvRocketsTypeValue);
            tvRocketsCostValue = (TextView) itemView.findViewById(R.id.tvRocketsCostValue);
            tvRocketsWiki = (TextView) itemView.findViewById(R.id.tvRocketsWiki);
        }
    }
}