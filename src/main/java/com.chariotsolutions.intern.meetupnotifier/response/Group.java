package com.chariotsolutions.intern.meetupnotifier.response;

public class Group {
    private String join_mode;
    private double created;
    private String name;
    private int group_lon;
    private int id;
    private String urlname;
    private int group_lat;
    private String who;

    public String getJoin_mode() {
        return join_mode;
    }

    public void setJoin_mode(String join_mode) {
        this.join_mode = join_mode;
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

    public int getGroup_lon() {
        return group_lon;
    }

    public void setGroup_lon(int group_lon) {
        this.group_lon = group_lon;
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

    public int getGroup_lat() {
        return group_lat;
    }

    public void setGroup_lat(int group_lat) {
        this.group_lat = group_lat;
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
                "join_mode='" + join_mode + '\'' +
                ", created=" + created +
                ", name='" + name + '\'' +
                ", group_lon=" + group_lon +
                ", id=" + id +
                ", urlname='" + urlname + '\'' +
                ", group_lat=" + group_lat +
                ", who='" + who + '\'' +
                '}';
    }
}
