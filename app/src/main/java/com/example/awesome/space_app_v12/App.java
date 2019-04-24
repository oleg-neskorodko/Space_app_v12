package com.example.awesome.space_app_v12;

import android.app.Application;
import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application{

    private static HistoryGetter historyGetter;
    private static InfoGetter infoGetter;
    private static RocketsGetter rocketsGetter;
    private Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.spacexdata.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        historyGetter = retrofit.create(HistoryGetter.class);
        infoGetter = retrofit.create(InfoGetter.class);
        rocketsGetter = retrofit.create(RocketsGetter.class);
    }

    public static HistoryGetter getHistory() {
        return historyGetter;
    }
    public static InfoGetter getInfo() {
        return infoGetter;
    }
    public static RocketsGetter getRockets() {
        return rocketsGetter;
    }
}
