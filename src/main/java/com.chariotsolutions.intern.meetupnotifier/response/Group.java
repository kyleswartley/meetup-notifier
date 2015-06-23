package com.chariotsolutions.intern.meetupnotifier.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Group {
    @JsonProperty("join_mode")
    private String joinMode;
    private double created;
    private String name;
    @JsonProperty("group_lon")
    private int groupLon;
    private int id;
    private String urlname;
    @JsonProperty("group_lat")
    private int groupLat;
    private String who;

    public String getJoinMode() {
        return joinMode;
    }

    public void setJoinMode(String joinMode) {
        this.joinMode = joinMode;
    }

    public double getCreated() {
        return created;
    }

    public void setCreated(double created) {
        this.created = created;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroupLon() {
        return groupLon;
    }

    public void setGroupLon(int groupLon) {
        this.groupLon = groupLon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrlname() {
        return urlname;
    }

    public void setUrlname(String urlname) {
        this.urlname = urlname;
    }

    public int getGroupLat() {
        return groupLat;
    }

    public void setGroupLat(int groupLat) {
        this.groupLat = groupLat;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    @Override
    public String toString() {
        return "Group{" +
                "joinMode='" + joinMode + '\'' +
                ", created=" + created +
                ", name='" + name + '\'' +
                ", groupLon=" + groupLon +
                ", id=" + id +
                ", urlname='" + urlname + '\'' +
                ", groupLat=" + groupLat +
                ", who='" + who + '\'' +
                '}';
    }
}
