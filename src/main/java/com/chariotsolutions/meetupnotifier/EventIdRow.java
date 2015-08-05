package com.chariotsolutions.meetupnotifier;

public class EventIdRow {
  private String googleId;
  private String meetupId;

  public EventIdRow(String googleId, String meetupId) {
    this.googleId = googleId;
    this.meetupId = meetupId;
  }

  public String getGoogleId() {
    return googleId;
  }

  public String getMeetupId() {
    return meetupId;
  }

}
