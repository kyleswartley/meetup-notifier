package com.chariotsolutions.intern.meetupnotifier.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Meta {
    private String next;
    private String method;
    @JsonProperty("total_count")
    private int totalCount;
    private String link;
    private int count;
    private String description;
    private String lon;
    private String title;
    private String url;
    private String id;
    private double updated;
    private String lat;

}
