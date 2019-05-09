package com.example.awesome.space_app_v12;

import com.example.awesome.space_app_v12.history.HistoryModel;
import com.example.awesome.space_app_v12.info.InfoModel;
import com.example.awesome.space_app_v12.rockets.RocketsModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface ApiService {

    @GET("/v3/{historyLink}")
    Call<List<HistoryModel>> getHistory(@Path("historyLink") String historyLink);

    @GET("/v3/{infoLink}")
    Call<List<InfoModel>> getInfo(@Path("infoLink") String infoLink);

    @GET("/v3/{rocketsLink}")
    Call<List<RocketsModel>> getRockets(@Path("rocketsLink") String rocketsLink);
}
