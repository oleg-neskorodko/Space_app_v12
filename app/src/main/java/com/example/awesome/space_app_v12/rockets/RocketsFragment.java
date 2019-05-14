package com.example.awesome.space_app_v12.rockets;

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
    private FragmentListener listener;

    public void setListener(FragmentListener listener) {
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_layout, null);

        posts = new ArrayList<>();
        layoutManager = new LinearLayoutManager(getActivity());
        adapter = new RocketsAdapter(new UrlClickListener() {

            @Override
            public void onClickUrl(String url) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(browserIntent);
            }
        }, posts);
        initView(view);

        adapter.setClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = recyclerView.getChildAdapterPosition(v);
                String text = posts.get(position).getDescription();
                Log.d(MainActivity.TAG, "onClick");
                listener.onDetails(text);
            }
        });
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
            }
        });
    }

    private void initView(View rootView) {
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    public void onStop() {
        super.onStop();
        posts = new ArrayList<>();
        recyclerView.getAdapter().notifyDataSetChanged();
    }
}
