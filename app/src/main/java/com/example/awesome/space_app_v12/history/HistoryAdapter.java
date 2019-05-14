package com.example.awesome.space_app_v12.history;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.awesome.space_app_v12.MainActivity;
import com.example.awesome.space_app_v12.R;
import com.example.awesome.space_app_v12.UrlClickListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {

    private List<HistoryModel> posts;
    private SimpleDateFormat sdf;
    private View.OnClickListener mClickListener;

    private UrlClickListener listener;

    public HistoryAdapter(UrlClickListener listener, List<HistoryModel> posts) {
        this.listener = listener;
        this.posts = posts;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(MainActivity.TAG, "onCreateViewHolder");
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history,
                parent, false);

        ViewHolder holder = new ViewHolder(v);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mClickListener.onClick(view);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Log.d(MainActivity.TAG, "onBindViewHolder");

        HistoryModel history1 = posts.get(position);
        sdf = new SimpleDateFormat("dd.MM.yyyy");
        holder.tvHistoryTitle.setText(history1.getTitle());
        holder.tvHistoryID.setText(String.valueOf(history1.getId()));
        holder.tvHistoryDate.setText(sdf.format(new Date(history1.getEventDateUnix()*1000L)));
        holder.tvHistoryWiki.setText(history1.getLinks().getWikipedia());
        holder.tvHistoryWiki.setTextColor(Color.BLUE);
        holder.tvHistoryWiki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClickUrl(holder.tvHistoryWiki.getText().toString());
            }
        });
        holder.tvHistoryDetails.setText(history1.getDetails());
    }

    public void setClickListener(View.OnClickListener callback) {
        mClickListener = callback;
    }

    @Override
    public int getItemCount() {
        if (posts == null)
            return 0;
        return posts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvHistoryID;
        TextView tvHistoryTitle;
        TextView tvHistoryDate;
        TextView tvHistoryWiki;
        TextView tvHistoryDetails;

        public ViewHolder(View convertView) {
            super(convertView);
            tvHistoryID = (TextView) itemView.findViewById(R.id.tvHistoryID);
            tvHistoryTitle = (TextView) itemView.findViewById(R.id.tvHistoryTitle);
            tvHistoryDate = (TextView) itemView.findViewById(R.id.tvHistoryDate);
            tvHistoryWiki = (TextView) itemView.findViewById(R.id.tvHistoryWiki);
            tvHistoryDetails = (TextView) itemView.findViewById(R.id.tvHistoryDetails);
        }
    }
}

