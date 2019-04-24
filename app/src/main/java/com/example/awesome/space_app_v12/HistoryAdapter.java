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

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder>{

    private List<HistoryModel> posts;

    public HistoryAdapter(List<HistoryModel> posts) {
        this.posts = posts;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history,
                parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        HistoryModel history1 = posts.get(position);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            holder.tvTitle.setText(Html.fromHtml(history1.getTitle(),
                    Html.FROM_HTML_MODE_LEGACY));
        } else {
            holder.tvTitle.setText(Html.fromHtml(history1.getTitle()));
        }
        holder.tvDetails.setText(history1.getDetails());
        holder.tvDate.setText(history1.getLinks().getWikipedia());
        holder.tvID.setText(history1.getId().toString());

    }

    @Override
    public int getItemCount() {
        if (posts == null)
            return 0;
        return posts.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvID;
        TextView tvTitle;
        TextView tvDate;
        TextView tvDetails;

        public ViewHolder(View itemView) {
            super(itemView);
            tvID = (TextView) itemView.findViewById(R.id.tvID);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvDate = (TextView) itemView.findViewById(R.id.tvDate);
            tvDetails = (TextView) itemView.findViewById(R.id.tvDetails);
        }
    }

}

