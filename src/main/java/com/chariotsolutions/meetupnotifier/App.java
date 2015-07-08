package com.chariotsolutions.meetupnotifier;

import com.google.api.services.calendar.model.Event;

import com.chariotsolutions.meetupnotifier.google.CalendarSample;
import com.chariotsolutions.meetupnotifier.meetup.api.MeetupGoogleEventTranslator;
import com.chariotsolutions.meetupnotifier.meetup.api.MeetupQuery;
import com.chariotsolutions.meetupnotifier.meetup.api.messages.Results;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class App {

  /**
   * Currently being used for testing purposes.
   * @param args Commandline arguments
   */
  public static void main(String[] args) throws IOException, GeneralSecurityException {
    Results resultsObject = MeetupQuery.fetchMeetups();

    Event evt = MeetupGoogleEventTranslator.translateMeetupEvent(
        resultsObject.getResults().get(0));

    com.google.api.services.calendar.Calendar cal = CalendarSample.getCalendarService();
    cal.events().insert("primary", evt).execute();
  }

}

