package com.chariotsolutions.meetupnotifier;


import com.google.api.services.calendar.model.Event;

import com.chariotsolutions.meetupnotifier.meetup.api.GoogleConverter;
import com.chariotsolutions.meetupnotifier.meetup.api.MeetupQuery;
import com.chariotsolutions.meetupnotifier.meetup.api.MeetupQueryExecutor;

import com.chariotsolutions.meetupnotifier.meetup.api.messages.Result;
import com.chariotsolutions.meetupnotifier.meetup.api.messages.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@EnableScheduling
public class AppBeanImpl {

  private static final Logger logger = LoggerFactory.getLogger(AppBeanImpl.class);

  private String[] groups;

  @Scheduled(fixedRate = 60000L, initialDelay = 4000L)
  public void run() throws IOException {
    for (String meetupGroupName : groups) {
      Results results = new MeetupQueryExecutor().executeQuery(new MeetupQuery(meetupGroupName));

      for (Result meetupEvent : results.getResults()) {
        Event googleEvent = new GoogleConverter().convertTo(meetupEvent);
        App.cal.events().insert("primary", googleEvent).execute();
        logger.warn("Oh no I added a thing to the calendar!");
      }
    }
  }

  @Value("${meetup.groups}")
  public void setGroups(String[] groups) {
    this.groups = groups;
  }
}
