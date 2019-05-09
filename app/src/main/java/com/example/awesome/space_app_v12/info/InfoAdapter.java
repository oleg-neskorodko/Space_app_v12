package com.example.awesome.space_app_v12.info;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.awesome.space_app_v12.R;

import java.util.List;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.InfoViewHolder>{

    private List<InfoModel> posts;

    public InfoAdapter(List<InfoModel> posts) {
        this.posts = posts;
    }

    @Override
    public InfoAdapter.InfoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history,
                parent, false);
        return new InfoAdapter.InfoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(InfoAdapter.InfoViewHolder holder, int position) {
        InfoModel info1 = posts.get(position);

        holder.tvInfoName.setText(info1.getName());
        //holder.tvInfoFoundedValue.setText(info1.getFounded());
        //holder.tvInfoFounderValue.setText(info1.getFounder());

    }

    @Override
    public int getItemCount() {
        if (posts == null)
            return 0;
        return posts.size();
    }


    class InfoViewHolder extends RecyclerView.ViewHolder {
        TextView tvInfoName;
        TextView tvInfoFoundedValue;
        TextView tvInfoFounderValue;

        public InfoViewHolder(View itemView) {
            super(itemView);
            tvInfoName = (TextView) itemView.findViewById(R.id.tvInfoName);
            tvInfoFoundedValue = (TextView) itemView.findViewById(R.id.tvInfoFoundedValue);
            tvInfoFounderValue = (TextView) itemView.findViewById(R.id.tvInfoFounderValue);
        }
    }

}
