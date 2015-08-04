package com.chariotsolutions.meetupnotifier;


import com.google.api.services.calendar.model.Event;

import com.chariotsolutions.meetupnotifier.meetup.api.GoogleConverter;
import com.chariotsolutions.meetupnotifier.meetup.api.MeetupQuery;
import com.chariotsolutions.meetupnotifier.meetup.api.MeetupQueryExecutor;
import com.chariotsolutions.meetupnotifier.meetup.api.messages.Result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import javax.sql.DataSource;

@Component
@EnableScheduling
public class MeetupNotifierImpl {

  private static final Logger logger = LoggerFactory.getLogger(MeetupNotifierImpl.class);
  @Autowired
  DataSource ds;

  private String[] groups;

  public void queryAndNotify() throws IOException {
    for (String meetupGroupName : groups) {
      JdbcTemplate template = new JdbcTemplate(ds);
      String metupInCalendarQuery = "SELECT count(*) from id_table where meetupID=?";

      List<Result> results = new MeetupQueryExecutor()
          .executeQuery(new MeetupQuery(meetupGroupName)).getResults().stream()
          .filter(t -> template.queryForObject(metupInCalendarQuery, Integer.class, t.getId()) == 0)
          .collect(Collectors.toList());

      List<Event> events = results.stream()
          .map(new GoogleConverter()::convertTo)
          .collect(Collectors.toList());

      Iterator<Result> meetupIter = results.iterator();

      for (Event googleEvent : events) {
        Event insertedEvent = App.cal.events().insert("primary", googleEvent).execute();
        template.update("INSERT INTO id_table VALUES (?, ?)",
                        insertedEvent.getId(), meetupIter.next().getId());
        logger.debug("An event was added to the calendar successfully");
      }
    }
  }

  @Value("${meetup.groups}")
  public void setGroups(String[] groups) {
    this.groups = groups;
  }
}
