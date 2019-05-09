package com.example.awesome.space_app_v12.rockets;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.awesome.space_app_v12.App;
import com.example.awesome.space_app_v12.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RocketsFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<RocketsModel> posts;
    private String link = "rockets";
    private LinearLayoutManager layoutManager;
    private RocketsAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_layout, null);

        posts = new ArrayList<>();
        layoutManager = new LinearLayoutManager(getActivity());
        adapter = new RocketsAdapter(posts);
        initView(view);

        return view;
    }


    @Override
    public void onResume() {
        super.onResume();

        App.getApiService().getRockets(link).enqueue(new Callback<List<RocketsModel>>() {
            @Override
            public void onResponse(Call<List<RocketsModel>> call, Response<List<RocketsModel>> response) {
                posts.addAll(response.body());
                recyclerView.getAdapter().notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<List<RocketsModel>> call, Throwable t) {
                //Произошла ошибка
                if (t instanceof IOException) {
                    Toast.makeText(getActivity(), "this is an actual network failure", Toast.LENGTH_SHORT).show();
                } else Toast.makeText(getActivity(), "conversion issue! big problems :(", Toast.LENGTH_SHORT).show();
                //Toast.makeText(getActivity(), "An error occurred during networking", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView(View rootView) {
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
