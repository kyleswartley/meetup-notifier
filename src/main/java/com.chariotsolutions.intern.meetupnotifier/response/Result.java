package com.chariotsolutions.intern.meetupnotifier.response;

public class Result {
    private int utc_offset;
    private Venue venue;
    private int rsvp_limit;
    private int headcount;
    private String visibility;
    private int waitlist_count;
    private double created;
    private int maybe_rsvp_count;
    private String description;
    private String how_to_find_us;
    private String event_url;
    private int yes_rsvp_count;
    private String name;
    private String id;
    private double time;
    private double updated;
    private Group group;
    private String status;

    public int getUtc_offset() {
        return utc_offset;
    }

    public void setUtc_offset(int utc_offset) {
        this.utc_offset = utc_offset;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public int getRsvp_limit() {
        return rsvp_limit;
    }

    public void setRsvp_limit(int rsvp_limit) {
        this.rsvp_limit = rsvp_limit;
    }

    public int getHeadcount() {
        return headcount;
    }

    public void setHeadcount(int headcount) {
        this.headcount = headcount;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public int getWaitlist_count() {
        return waitlist_count;
    }

    public void setWaitlist_count(int waitlist_count) {
        this.waitlist_count = waitlist_count;
    }

    public double getCreated() {
        return created;
    }

    public void setCreated(double created) {
        this.created = created;
    }

    public int getMaybe_rsvp_count() {
        return maybe_rsvp_count;
    }

    public void setMaybe_rsvp_count(int maybe_rsvp_count) {
        this.maybe_rsvp_count = maybe_rsvp_count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHow_to_find_us() {
        return how_to_find_us;
    }

    public void setHow_to_find_us(String how_to_find_us) {
        this.how_to_find_us = how_to_find_us;
    }

    public String getEvent_url() {
        return event_url;
    }

    public void setEvent_url(String event_url) {
        this.event_url = event_url;
    }

    public int getYes_rsvp_count() {
        return yes_rsvp_count;
    }

    public void setYes_rsvp_count(int yes_rsvp_count) {
        this.yes_rsvp_count = yes_rsvp_count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public double getUpdated() {
        return updated;
    }

    public void setUpdated(double updated) {
        this.updated = updated;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Result{" +
                "utc_offset=" + utc_offset +
                ", venue=" + venue +
                ", rsvp_limit=" + rsvp_limit +
                ", headcount=" + headcount +
                ", visibility='" + visibility + '\'' +
                ", waitlist_count=" + waitlist_count +
                ", created=" + created +
                ", maybe_rsvp_count=" + maybe_rsvp_count +
                ", description='" + description + '\'' +
                ", how_to_find_us='" + how_to_find_us + '\'' +
                ", event_url='" + event_url + '\'' +
                ", yes_rsvp_count=" + yes_rsvp_count +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", time=" + time +
                ", updated=" + updated +
                ", group=" + group +
                ", status='" + status + '\'' +
                '}';
    }
}
