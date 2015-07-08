package com.chariotsolutions.meetupnotifier.meetup.api;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;

import com.chariotsolutions.meetupnotifier.meetup.api.messages.Result;


import java.util.Date;

public class MeetupGoogleEventTranslator {

  /**
   * Creates a Google Calendar Event from a Result.
   * @param result hi
   * @return The generated event.
   */
  public static Event translateMeetupEvent(Result result) {
    Event evt = new Event()
        .setSummary(result.getName())
        .setLocation(result.getVenue().toString())
        .setDescription(result.getDescription());
    setTimes(evt, result);
    return evt;
  }

  private static void setTimes(Event evt, Result result) {
    long startTime = result.getTime();
    long endTime = startTime + result.getDuration();
    String timezone = result.getTimezone();

    DateTime startDateTime = new DateTime(new Date(startTime));
    DateTime endDateTime = new DateTime(new Date(endTime));

    EventDateTime start = new EventDateTime()
        .setDateTime(startDateTime)
        .setTimeZone(timezone);

    EventDateTime end = new EventDateTime()
        .setDateTime(endDateTime)
        .setTimeZone(timezone);

    evt.setStart(start);
    evt.setEnd(end);
  }
}
