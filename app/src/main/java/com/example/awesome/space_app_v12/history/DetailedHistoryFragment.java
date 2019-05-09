package com.example.awesome.space_app_v12.history;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.awesome.space_app_v12.R;

public class DetailedHistoryFragment extends Fragment {

    private TextView tvDetailedHistory;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.detailed_history, null);
        tvDetailedHistory = view.findViewById(R.id.tvDetailedHistory);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            tvDetailedHistory.setText(bundle.getString("key", "no data"));
        }

    }


}
