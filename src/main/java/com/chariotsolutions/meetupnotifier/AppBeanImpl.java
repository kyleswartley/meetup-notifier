package com.chariotsolutions.meetupnotifier;


import com.chariotsolutions.meetupnotifier.meetup.api.GoogleConverter;
import com.chariotsolutions.meetupnotifier.meetup.api.MeetupQueryExecutor;
import com.google.api.services.calendar.model.Event;

import com.chariotsolutions.meetupnotifier.meetup.api.MeetupProperties;
import com.chariotsolutions.meetupnotifier.meetup.api.MeetupQuery;
import com.chariotsolutions.meetupnotifier.meetup.api.messages.Result;
import com.chariotsolutions.meetupnotifier.meetup.api.messages.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@EnableScheduling
public class AppBeanImpl {

  private static final Logger logger = LoggerFactory.getLogger(AppBeanImpl.class);

  @Scheduled(fixedRate = 60000L, initialDelay = 4000L)
  public void run() throws IOException {
    for (String meetupGroupName : MeetupProperties.meetupGroups) {
      Results results = new MeetupQueryExecutor("591a1341d1b5e50587c3b485afa34").executeQuery(new MeetupQuery("phillypug"));

      for (Result meetupEvent : results.getResults()) {
        Event evt = new GoogleConverter().convertTo(meetupEvent);
        App.cal.events().insert("primary", evt).execute();
        logger.warn("Oh no I added a thing to the calendar!");
      }
    }
  }
}
