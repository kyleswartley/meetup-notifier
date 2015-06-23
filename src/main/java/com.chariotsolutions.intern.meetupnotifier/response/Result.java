package com.chariotsolutions.intern.meetupnotifier.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {
    @JsonProperty("utc_offset")
    private int utcOffset;
    private Venue venue;
    @JsonProperty("rsvp_limit")
    private int rsvpLimit;
    private int headcount;
    private String visibility;
    @JsonProperty("waitlist_count")
    private int waitlistCount;
    private double created;
    @JsonProperty("maybe_rsvp_count")
    private int maybeRsvpCount;
    private String description;
    @JsonProperty("how_to_find_us")
    private String howToFindUs;
    @JsonProperty("event_url")
    private String eventUrl;
    @JsonProperty("yes_rsvp_count")
    private int yesRsvpCount;
    private String name;
    private String id;
    private double time;
    private double duration = 1.08e7;
    private double updated;
    private Group group;
    private String status;
    private String timezone;

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public int getUtcOffset() {
        return utcOffset;
    }

    public void setUtcOffset(int utcOffset) {
        this.utcOffset = utcOffset;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public int getRsvpLimit() {
        return rsvpLimit;
    }

    public void setRsvpLimit(int rsvpLimit) {
        this.rsvpLimit = rsvpLimit;
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

    public int getWaitlistCount() {
        return waitlistCount;
    }

    public void setWaitlistCount(int waitlistCount) {
        this.waitlistCount = waitlistCount;
    }

    public double getCreated() {
        return created;
    }

    public void setCreated(double created) {
        this.created = created;
    }

    public int getMaybeRsvpCount() {
        return maybeRsvpCount;
    }

    public void setMaybeRsvpCount(int maybeRsvpCount) {
        this.maybeRsvpCount = maybeRsvpCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHowToFindUs() {
        return howToFindUs;
    }

    public void setHowToFindUs(String howToFindUs) {
        this.howToFindUs = howToFindUs;
    }

    public String getEventUrl() {
        return eventUrl;
    }

    public void setEventUrl(String eventUrl) {
        this.eventUrl = eventUrl;
    }

    public int getYesRsvpCount() {
        return yesRsvpCount;
    }

    public void setYesRsvpCount(int yesRsvpCount) {
        this.yesRsvpCount = yesRsvpCount;
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

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
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
                "utcOffset=" + utcOffset +
                ", venue=" + venue +
                ", rsvpLimit=" + rsvpLimit +
                ", headcount=" + headcount +
                ", visibility='" + visibility + '\'' +
                ", waitlistCount=" + waitlistCount +
                ", created=" + created +
                ", maybeRsvpCount=" + maybeRsvpCount +
                ", description='" + description + '\'' +
                ", howToFindUs='" + howToFindUs + '\'' +
                ", eventUrl='" + eventUrl + '\'' +
                ", yesRsvpCount=" + yesRsvpCount +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", time=" + time +
                ", duration=" + duration +
                ", updated=" + updated +
                ", group=" + group +
                ", status='" + status + '\'' +
                '}';
    }
}
