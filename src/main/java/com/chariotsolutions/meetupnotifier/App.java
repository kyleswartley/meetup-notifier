package com.chariotsolutions.meetupnotifier;

import com.chariotsolutions.meetupnotifier.meetup.api.MeetupQueryExecutor;
import com.chariotsolutions.meetupnotifier.meetup.api.messages.Result;
import com.google.api.services.calendar.model.Event;

import com.chariotsolutions.meetupnotifier.google.CalendarSample;
import com.chariotsolutions.meetupnotifier.meetup.api.MeetupGoogleEventTranslator;
import com.chariotsolutions.meetupnotifier.meetup.api.MeetupQuery;
import com.chariotsolutions.meetupnotifier.meetup.api.messages.Results;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

public class App {

  /**
   * Currently being used for testing purposes.
   * @param args Commandline arguments
   */
  public static void main(String[] args) throws IOException, GeneralSecurityException {
    Results resultsObject = new MeetupQueryExecutor("Not the api key").executeQuery(new MeetupQuery("phillypug"));

    com.google.api.services.calendar.Calendar cal = CalendarSample.getCalendarService();

    List<Event> events = new ArrayList<Event>();

    for (Result result : resultsObject.getResults()) {
      events.add(MeetupGoogleEventTranslator.translateMeetupEvent(result));
    }

    for (Event event : events) {
      cal.events().insert("primary", event).execute();
    }
  }

}

