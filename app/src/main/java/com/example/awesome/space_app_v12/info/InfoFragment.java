package com.example.awesome.space_app_v12.info;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.awesome.space_app_v12.App;
import com.example.awesome.space_app_v12.FragmentListener;
import com.example.awesome.space_app_v12.Logger;
import com.example.awesome.space_app_v12.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InfoFragment extends Fragment {

    private static final String TAG = InfoFragment.class.getSimpleName();
    private RecyclerView recyclerView;
    private List<InfoModel> posts;
    private String link = "info";
    private LinearLayoutManager layoutManager;
    private InfoAdapter adapter;

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
        adapter = new InfoAdapter(posts);
        initView(view);

        adapter.setClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = recyclerView.getChildAdapterPosition(v);
                String text = posts.get(position).getSummary();
                listener.onDetails(text);
            }
        });

        return view;
    }


    @Override
    public void onResume() {
        super.onResume();

        App.getApiService().getInfo(link).enqueue(new Callback<InfoModel>() {
            @Override
            public void onResponse(Call<InfoModel> call, Response<InfoModel> response) {
                posts.add(response.body());
                recyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<InfoModel> call, Throwable t) {
                Logger.error(TAG, "onResume", t);

                //Произошла ошибка
                if (t instanceof IOException) {
                    Toast.makeText(getActivity(), "this is an actual network failure", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(getActivity(), "conversion issue! big problems :(", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView(View rootView) {
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
