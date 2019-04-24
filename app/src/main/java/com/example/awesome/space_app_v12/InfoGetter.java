package com.example.awesome.space_app_v12;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

public interface InfoGetter {

    @GET("/v3/{link}")
    Call<List<InfoModel>> getData(@Path("link") String link);
}
