package com.example.awesome.space_app_v12.history;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.awesome.space_app_v12.App;
import com.example.awesome.space_app_v12.FragmentListener;
import com.example.awesome.space_app_v12.MainActivity;
import com.example.awesome.space_app_v12.R;
import com.example.awesome.space_app_v12.UrlClickListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistoryFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<HistoryModel> posts;
    private String link = "history";
    private LinearLayoutManager layoutManager;
    private HistoryAdapter adapter;
    private FragmentListener listener;

    public void setListener(FragmentListener listener) {
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        Log.d(MainActivity.TAG, "onCreateView");

        View view = inflater.inflate(R.layout.fragment_layout, null);
        posts = new ArrayList<>();
        layoutManager = new LinearLayoutManager(getActivity());
        adapter = new HistoryAdapter(new UrlClickListener() {
            @Override
            public void onClickUrl(String url) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(browserIntent);
            }
        }
                , posts);
        initView(view);

        adapter.setClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = recyclerView.getChildAdapterPosition(v);
                Log.d(MainActivity.TAG, "position = " + position);
                String text = posts.get(position).getDetails();
                Log.d(MainActivity.TAG, "text = " + text);
                listener.onDetails(text);
            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        App.getApiService().getHistory(link).enqueue(new Callback<List<HistoryModel>>() {
            @Override
            public void onResponse(Call<List<HistoryModel>> call, Response<List<HistoryModel>> response) {
                posts.addAll(response.body());
                recyclerView.getAdapter().notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<List<HistoryModel>> call, Throwable t) {
                //Произошла ошибка
                Toast.makeText(getActivity(), "An error occurred during networking",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView(View rootView) {
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onStop() {
        super.onStop();
        posts = new ArrayList<>();
        recyclerView.getAdapter().notifyDataSetChanged();
    }
}
