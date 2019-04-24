package com.example.awesome.space_app_v12;
import android.util.Log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HistoryModel {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("event_date_utc")
    @Expose
    private String eventDateUtc;
    @SerializedName("event_date_unix")
    @Expose
    private Integer eventDateUnix;
    @SerializedName("flight_number")
    @Expose
    private Integer flightNumber;
    @SerializedName("details")
    @Expose
    private String details;
    @SerializedName("links")
    @Expose
    private LinksModel links;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEventDateUtc() {
        return eventDateUtc;
    }

    public void setEventDateUtc(String eventDateUtc) {
        this.eventDateUtc = eventDateUtc;
    }

    public Integer getEventDateUnix() {
        return eventDateUnix;
    }

    public void setEventDateUnix(Integer eventDateUnix) {
        this.eventDateUnix = eventDateUnix;
    }

    public Integer getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(Integer flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LinksModel getLinks() {
        return links;
    }

    public void setLinks(LinksModel links) {
        this.links = links;
    }
}